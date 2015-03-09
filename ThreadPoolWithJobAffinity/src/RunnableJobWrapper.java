public class RunnableJobWrapper {
	Runnable job;
	int JOB_TYPE_ID;

	RunnableJobWrapper(Runnable ob, int JOB_ID) {
		this.job = ob;
		JOB_TYPE_ID = JOB_ID;
	}

	int getJobID() {
		return JOB_TYPE_ID;
	}

	Runnable getRunnableJob() {
		return job;
	}

}
