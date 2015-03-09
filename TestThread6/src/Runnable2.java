public class Runnable2 implements Runnable {
	MyLock lock;

	Runnable2(MyLock ob) {
		lock = ob;
	}

	@Override
	public void run() {
		lock.lock();
		for (int i = 5; i > 0; i--) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		lock.unlock();

	}

}
