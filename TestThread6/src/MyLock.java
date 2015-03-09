public class MyLock {
	boolean lock;

	MyLock() {
		lock = false;
	}

	synchronized void lock() {
		if (lock == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		lock = true;
	}

	synchronized void unlock() {
		lock = false;
		notify();
	}

	void loop() {
		for (int i = 1; i < 6; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
