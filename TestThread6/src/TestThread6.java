public class TestThread6 {

	public static void main(String[] args) {
		MyLock lock = new MyLock();
		new Thread(new Runnable1(lock)).start();
		new Thread(new Runnable2(lock)).start();
	}

}
