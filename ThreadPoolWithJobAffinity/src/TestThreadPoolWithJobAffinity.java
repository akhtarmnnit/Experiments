import java.util.HashMap;

public class TestThreadPoolWithJobAffinity {
	public static void main(String args[]) {
		HashMap<Integer, Integer> jobTypeVsNumThreads = new HashMap<Integer, Integer>();
		// Let there be 3 threads for RunnableJobType1 which are more in number
		jobTypeVsNumThreads.put(new Integer(0), new Integer(3));
		// Let there be 2 threads for RunnableJobType2 which are more in number
		jobTypeVsNumThreads.put(new Integer(1), new Integer(2));
		// Let there be 1 thread for RunnableJobType3 which are very less in
		// number
		jobTypeVsNumThreads.put(new Integer(2), new Integer(3));
		ThreadPoolJobAffinity pool = new ThreadPoolJobAffinity(
				jobTypeVsNumThreads, 10);
		// Submit 10 jobs of RunnableJobType1
		for (int i = 0; i < 10; i++) {
			pool.submit(0, new RunnableJobType1(null));
		}

		// Submit 6 jobs of RunnableJobType2
		for (int i = 0; i < 6; i++) {
			pool.submit(1, new RunnableJobType2(null));
		}

		// Submit 2 jobs of RunnableJobType3
		for (int i = 0; i < 2; i++) {
			pool.submit(2, new RunnableJobType3(null));
		}

		pool.shutdown();

	}
}
