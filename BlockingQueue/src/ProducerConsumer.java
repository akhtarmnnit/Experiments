public class ProducerConsumer {
	public static void main(String[] args) {
		final BlockingQueue queue = new BlockingQueue(3);
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();

	}
}
