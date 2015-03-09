public class MyProducer implements Runnable {
	MyBlockingQueue queue;

	MyProducer(MyBlockingQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				queue.enqueue(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
