import java.util.HashSet;
import java.util.Set;

public class ThreadFromPool extends Thread {

	private BlockingJobQueue blockingJobQueue = null;
	private boolean isThreadStopped = false;
	private int threadID;
	private final Set<IThreadCompletedJobListener> listeners = new HashSet<IThreadCompletedJobListener>();

	public ThreadFromPool(BlockingJobQueue queue, int ID) {
		this.blockingJobQueue = queue;
		this.threadID = ID;
	}

	public void run() {
		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) blockingJobQueue.dequeue();
				runnable.run();
				// notifyJobCompletionToListeners();//Use to notify the listener
				// that got job completed
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public int getThreadID() {
		return threadID;
	}

	public synchronized final void addJobCompletetedListener(
			final IThreadCompletedJobListener listner) {
		listeners.add(listner);
	}

	public synchronized final void removeJobCompletetedListener(
			final IThreadCompletedJobListener listner) {
		listeners.remove(listner);
	}

	private synchronized final void notifyJobCompletionToListeners() {
		for (IThreadCompletedJobListener listener : listeners) {
			listener.notifyJobCompleted(this);
		}
	}

	public synchronized void doStop() {
		// Stop this thread only if there are no jobs to be executed
		if (this.blockingJobQueue.isEmpty() == true) {
			isThreadStopped = true;
			this.stop();
		}
	}

	public synchronized boolean isStopped() {
		return isThreadStopped;
	}
}