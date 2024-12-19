import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {

    public static void main(String[] args) {
        MTAMain mtaMain = new MTAMain();
        mtaMain.process();
    }

    static class MTAMain  {
        // Create a thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        public MTAMain () {
        }

        public void process() {
            // Check eligible deliveries & personalizataion info
            // create all delivery parts and span 5 mtachild threads to process each part
            for (int i = 0; i < 10; i++) {
                executorService.submit(new MTAChild(i));
            }

            // Shut down the executor service
            executorService.shutdown();
        }
    }

    static class MTAChild implements Runnable {
        private int taskId;

        public MTAChild(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task ID : " + this.taskId + " performed by " 
                + Thread.currentThread().getName());
        }
    }
    
}