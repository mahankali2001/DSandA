import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading {
    public static void main(String[] args) {
        // MTAMain spans MTAChild threads using thread pooling
        MTAMain mtaMain = new MTAMain(2);
        mtaMain.process();
    }

    static class MTAMain  {
        // Thread pooling
        ExecutorService executorService = null;

        public MTAMain (int MTAChildThreadCount) {
            executorService = Executors.newFixedThreadPool(MTAChildThreadCount);
        }

        public void process() {
            // Check & get eligible delivery templates & delivery segment personalizataion info
            // create delivery part xml files with all needed data
            // Span MTAChild threads to process delivery parts
            for (int i = 0; i < 4; i++) {
                executorService.submit(new MTAChild(i));
            }

            // Shut down the executor service
            executorService.shutdown();
        }
    }

    static class MTAChild implements Runnable {
        private Lock lock = new ReentrantLock();
        private int counter = 0;
        private int taskId;

        public MTAChild(int taskId) {
            this.taskId = taskId;
        }

        /**
         * MTA child create batch of emails/Push msgs from each delivery part send it to mail sending service
         * */ 
        @Override
        public void run() {
            System.out.println("Task ID : " + this.taskId + " performed by " 
                + Thread.currentThread().getName());

            // Thread synchronization
            lock.lock();
            try {
                // shared resource
                counter++;

                System.out.println("Counter: " + counter + " updated by " + Thread.currentThread().getName());
                Thread.sleep(2000);
            } 
             catch (InterruptedException e) {
                e.printStackTrace();
            } 
            finally{
                lock.unlock();
            }
        }
    }
    
}
// Thread safety is achieved by using the ReentrantLock class. The lock() method is used to acquire the lock, and the unlock() method is used to release the lock. This ensures that only one thread can access the shared resource at a time, preventing
// Deadlocs - two or more threads are waiting for each other to release the lock, causing all threads to be blocked indefinitely. This can be avoided by ensuring that the lock is released after it is acquired, as shown in the example
// Performance - Locks can be more expensive than synchronized blocks, as they involve more overhead. However, they provide more flexibility and control over the locking mechanism.