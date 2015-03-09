public class Runnable1 implements Runnable {
	MyLock lock;

	Runnable1(MyLock ob) {
		lock = ob;

	}

	@Override
	public void run() {
		lock.lock();
		lock.loop();
		lock.unlock();

	}

}
