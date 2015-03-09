import java.util.LinkedList;
import java.util.List;

public class BlockingJobQueue {

	private List jobQueue = new LinkedList<Runnable>();
	private int maxJobsInQueue = 10;

	public BlockingJobQueue(int maxJobs) {
		this.maxJobsInQueue = maxJobs;
	}

	@SuppressWarnings("unchecked")
	public synchronized void enqueue(Runnable job) throws InterruptedException {
		while (this.jobQueue.size() == this.maxJobsInQueue) {
			// max jobs already been enqueued. The thread must wait for Queue to
			// have slots
			this.wait();
		}
		if (this.jobQueue.size() == 0) {
			this.notifyAll();// Notify all waiting threads that there are no
								// more jobs in queue
		}
		this.jobQueue.add(job);
	}

	public synchronized Runnable dequeue() throws InterruptedException {
		while (this.jobQueue.size() == 0) {

			this.wait();
		}
		if (this.jobQueue.size() == this.maxJobsInQueue) {
			this.notifyAll();
		}
		// System.out.println(Thread.currentThread().getName());
		return (Runnable) this.jobQueue.remove(0);
	}

	public synchronized boolean isEmpty() {
		return (this.jobQueue.size() == 0);

	}

}
