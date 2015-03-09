import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreadPoolJobAffinity implements IThreadPoolWithJobAffinity,
		IThreadCompletedJobListener {

	private List<BlockingJobQueue> taskQueueues = null;
	private List<ThreadFromPool> threads = new ArrayList<ThreadFromPool>();
	private boolean isStopped = false;

	public ThreadPoolJobAffinity(Map<Integer, Integer> JobTypeVsNoOfThreads,
			int maxNoOfTasksPerJobType) {
		// We have each taskQueue dedicated for a Job Type
		taskQueueues = new ArrayList<BlockingJobQueue>();

		for (Integer key : JobTypeVsNoOfThreads.keySet()) {
			int jobID = key.intValue();
			int numThreadToAllocateForJob = JobTypeVsNoOfThreads.get(key)
					.intValue();
			BlockingJobQueue taskQueueForTheJobType = new BlockingJobQueue(
					maxNoOfTasksPerJobType);
			taskQueueues.add(taskQueueForTheJobType);
			// For each thread pass a reference to the same taskQueue
			for (int i = 0; i < numThreadToAllocateForJob; i++) {
				threads.add(new ThreadFromPool(taskQueueForTheJobType, jobID));
			}
		}

		for (ThreadFromPool thread : threads) {
			// For each pool thread add the master as listener.
			thread.addJobCompletetedListener(this);
			thread.start();
		}
	}

	@Override
	public synchronized int poolSize() {
		return threads.size();
	}

	/**
	 * Execute a given job. The jobId determines the thread which executes the
	 * job.All the jobs submitted with the same job Id should be executed by the
	 * same thread of the pool. Multiple jobs submitted for a given job id
	 * should be executed in the order of submission.
	 *
	 * @param jobId
	 *            a string containing job id.
	 * @param job
	 *            a Runnable representing the job to be executed.
	 */
	@Override
	public synchronized void submit(int jobId, Runnable job) {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");
		// Based on jobID, get the taskQueue to which it must be sent
		// Get the taskQueue that is associated with the Job Type
		BlockingJobQueue taskQueue = taskQueueues.get(jobId);

		try {
			// enqueue the job in this taskQueue so that it is only
			// executed by the threads associated with this taskQueue
			taskQueue.enqueue(job);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Graceful shutdown of the thread pool.Each pool thread will only stop if
	 * there are no jobs available to execute i.e. Waits for all jobs to
	 * complete before shutdown.Client is resposible for ensuring the shutdown
	 * has happened
	 */
	@Override
	public synchronized boolean shutdown() {
		for (ThreadFromPool poolthread : threads) {
			poolthread.removeJobCompletetedListener(this);
			if (poolthread.isStopped() == false) {
				poolthread.doStop();// try stopping
			}
			if (poolthread.isStopped() == false) {
				return false;// return that the shutdown could not happen
			}
		}
		this.isStopped = true;// shutdown did happen
		return isStopped;
	}

	@Override
	public synchronized void notifyJobCompleted(ThreadFromPool thread) {
		System.out.println("A job got succesfully executed from job type:"
				+ thread.getThreadID());

	}
}