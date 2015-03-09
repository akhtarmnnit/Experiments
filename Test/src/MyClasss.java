public class MyClasss {
	int val = 2;

	public static void main(String args[]) {
		Runnable r = new MyRunnable(4);
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
	}

}
