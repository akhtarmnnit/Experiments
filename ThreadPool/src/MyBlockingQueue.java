import java.util.LinkedList;
import java.util.List;

public class MyBlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public MyBlockingQueue(int limit) {
		this.limit = limit;
	}

	@SuppressWarnings("unchecked")
	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {

			this.wait();
		}
		if (this.queue.size() == 0) {
			this.notifyAll();
		}
		// System.out.println(Thread.currentThread().getName());
		System.out.println("Enqueue" + item);
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {

			this.wait();
		}
		if (this.queue.size() == this.limit) {
			this.notifyAll();
		}
		// System.out.println(Thread.currentThread().getName());
		return this.queue.remove(0);
	}

}
