import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MyRunnable implements Runnable {
	ConcurrentMap concurrentMap;
	Random rand = new Random();
	static int i;

	MyRunnable() {
		concurrentMap = new ConcurrentHashMap();
	}

	@Override
	public void run() {
		synchronized (this) {
			i++;
		}
		concurrentMap.put(i, rand.nextInt());
		Object value = concurrentMap.get("key");
		System.out.println("Thread:" + Thread.currentThread().getName());
		System.out.println("value:" + concurrentMap.get(i));

	}
}
