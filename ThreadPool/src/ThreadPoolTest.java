public class ThreadPoolTest {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(10, 2);
		MyBlockingQueue queue = new MyBlockingQueue(10);
		try {
			pool.execute(new MyProducer(queue));
			pool.execute(new MyConsumer(queue));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
