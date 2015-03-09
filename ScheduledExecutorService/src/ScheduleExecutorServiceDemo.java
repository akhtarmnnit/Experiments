import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceDemo {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		executor.schedule(new Callable() {
			public Object call() throws Exception {
				System.out.println("Callable called");
				return "Called";
			}
		}, 5, TimeUnit.SECONDS);

		executor.scheduleWithFixedDelay(new Runnable() {
			public void run() {
				System.out.println("Run called");
			}
		}, 5, 5, TimeUnit.SECONDS);

	}
}
