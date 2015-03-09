class MyRunnable implements Runnable {
	int val;

	MyRunnable(int val) {
		this.val = val;
	}

	@Override
	public void run() {
		increment();
	}

	private synchronized void increment() {
		System.out.println(val);
		val++;
	}

}