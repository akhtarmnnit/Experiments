/*Thread Pool With Job Affinity
Implement a Thread Pool that executes a given set of jobs. This thread pool has Job Affinity ­
all the jobs given to thread pool with the same job id will be executed by the same thread.
/**
 * Represents fixed size thread pool.
 */
public interface IThreadPoolWithJobAffinity {
	/**
	 * Return the thread pool size
	 *
	 * @return an integer containing the poolSize.
	 */
	int poolSize();

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
	void submit(int jobId, Runnable job);

	/**
	 * Graceful shutdown of the thread pool. Waits for all jobs to complete
	 * before shutdown.
	 */
	boolean shutdown();
}
/*
 * Submission 1. Fully functional code with tests. 2. Please create git repo for
 * your code. Please zip and mail us the git repo. 3. Any other supporting
 * documents for the evaluator to understand your implementation.
 */