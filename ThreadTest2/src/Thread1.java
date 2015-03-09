public class Thread1 implements Runnable {

	static int i;

	@Override
	public synchronized void run() {
		System.out.println(this.toString());
		increment();
		System.out.println(i);

	}

	private void increment() {
		synchronized (this) {
			for (; i < 100; i++) {

			}
		}
	}

}
