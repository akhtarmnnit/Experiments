public class MyRunnable implements Runnable {
	ThreadLocal t = new ThreadLocal();

	@Override
	public void run() {
		t.set(Math.random());
		print();

	}

	void print() {
		System.out.println(t.get());
	}

}
