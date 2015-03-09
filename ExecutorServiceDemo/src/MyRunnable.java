public class MyRunnable implements Runnable {
	int i = 0;

	@Override
	public void run() {
		synchronized (this) {
			i++;
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
		}

	}

}
