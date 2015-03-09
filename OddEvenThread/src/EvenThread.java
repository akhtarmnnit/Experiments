public class EvenThread extends Thread {
	oddEvenMonitor monitor;

	EvenThread(oddEvenMonitor mon) {
		monitor = mon;
	}

	class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 2; i < 10; i = i + 2) {
				monitor.waitTurn(monitor.EVEN_TURN);
				System.out.println("even");
				System.out.println(i);
				monitor.toggleTurn();
			}

		}

	}

	public void print() {
		Runnable r = new MyRunnable();
		new Thread(r).start();

	}
}
