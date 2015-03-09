public class oddEvenThread extends Thread {
	final static boolean ODD_TURN = true;
	final static boolean EVEN_TURN = false;
	static boolean turn;
	int initialvalue;

	oddEvenThread(int initial_value) {
		initialvalue = initial_value;
		turn = ODD_TURN;
	}

	class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = initialvalue; i < 100; i = i + 2) {
				if (initialvalue == 1) {
					waitTurn(ODD_TURN);
				} else {
					waitTurn(EVEN_TURN);
				}
				System.out.println(i);
				toggleTurn();
			}

		}

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

	public synchronized void print() {
		Runnable r = new MyRunnable();
		new Thread(r).start();

	}

}
