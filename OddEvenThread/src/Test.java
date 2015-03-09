public class Test {
	public static void main(String args[]) {
		oddEvenMonitor mon = new oddEvenMonitor();
		new oddThread(mon).print();
		new EvenThread(mon).print();
		Thread t = new Thread();
		t.interrupt();
	}

}
