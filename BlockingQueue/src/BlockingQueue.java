import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
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
		int val = (int) this.queue.remove(0);
		System.out.println("Dequeue" + val);
		return val;
	}

}
