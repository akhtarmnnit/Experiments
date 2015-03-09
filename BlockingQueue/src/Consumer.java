public class Consumer implements Runnable {
	BlockingQueue queue;

	Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				int val = (int) queue.dequeue();
				// System.out.println(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
