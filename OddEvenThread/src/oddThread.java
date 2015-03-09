public class oddThread extends Thread {
	oddEvenMonitor monitor;

	oddThread(oddEvenMonitor mon) {
		monitor = mon;
	}

	class MyRunnable implements Runnable {

		@Override
		public void run() {
			for (int i = 1; i < 10; i = i + 2) {
				monitor.waitTurn(monitor.ODD_TURN);
				System.out.println("odd");
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
