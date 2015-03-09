import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	public static void main(String args[]) {
		ExecutorService executorService = Executors.newCachedThreadPool();

		Future future = executorService.submit(new Callable() {
			public Object call() throws Exception {
				System.out.println("Asynchronous Callable");
				return "Callable Result";
			}
		});

		try {
			System.out.println("future.get() = " + future.get());
			executorService.shutdown();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
