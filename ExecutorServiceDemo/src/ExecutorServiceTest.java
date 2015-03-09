import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		MyRunnable r = new MyRunnable();

		executorService.execute(r);
		Future future = executorService.submit(r);

		try {
			if (future.get() == null)
				System.out.println("The task got executed");
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
