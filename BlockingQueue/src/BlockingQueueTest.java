public class BlockingQueueTest {

	public static void main(String[] args) {
		final BlockingQueue queue = new BlockingQueue(3);
		try {
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(4);

			// queue.enqueue(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int val = (int) queue.dequeue();
					System.out.println(val);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		}).start();

	}

}
