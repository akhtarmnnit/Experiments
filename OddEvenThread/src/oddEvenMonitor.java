public class oddEvenMonitor {
	static final boolean ODD_TURN = true;
	static final boolean EVEN_TURN = false;
	volatile static boolean turn;

	oddEvenMonitor() {
		turn = ODD_TURN;
	}

	public synchronized void waitTurn(boolean inputturn) {
		while (turn != inputturn) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void toggleTurn() {
		turn = turn ^ true;
		notify();
	}

}
