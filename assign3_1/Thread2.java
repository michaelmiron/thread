/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package assign3_1;

import java.util.concurrent.Semaphore;

public class Thread2 implements Runnable {

	 private Semaphore b; // Semaphore B
	    private Semaphore c; // Semaphore C
	    private Object lock; // lock object for synchronization

	    // Constructor to initialize Semaphore B, Semaphore C, and the lock object
	    public Thread2(Semaphore b, Semaphore c, Object lock) {
	        this.b = b;
	        this.c = c;
	        this.lock = lock;
	    }

	    @Override
	    public void run() {
	        while (true) { // Infinite loop to keep the thread running
	            try {
	                b.acquire(); // Acquire Semaphore B, blocks if not available
	                System.out.println("Thread B"); 
	                Thread.sleep(1000); // Simulating execution time 

	                synchronized (lock) { // Synchronize on the shared lock object
	                    c.release(); // Release Semaphore C, allowing Thread3 to execute its code block
	                    lock.wait(); // Wait for signal from Thread3 to proceed
	                }

	            } catch (InterruptedException e) { // Catch and handle InterruptedException
	                e.printStackTrace(); // Print the stack trace of the exception
	            }
	        }
	    }
}
