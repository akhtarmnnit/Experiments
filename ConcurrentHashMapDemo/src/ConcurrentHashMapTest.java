public class ConcurrentHashMapTest {
	public static void main(String args[]) {
		MyRunnable r = new MyRunnable();
		Thread t1 = new Thread(r);
		t1.setName("One");
		Thread t2 = new Thread(r);
		t2.setName("two");
		Thread t3 = new Thread(r);
		t3.setName("three");
		Thread t4 = new Thread(r);
		t4.setName("four");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
