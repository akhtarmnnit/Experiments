public class MyConsumer implements Runnable {
	MyBlockingQueue queue;

	MyConsumer(MyBlockingQueue inputQueue) {
		MyBlockingQueue queue = inputQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
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
