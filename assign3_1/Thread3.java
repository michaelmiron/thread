/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package assign3_1;

import java.util.concurrent.Semaphore;

public class Thread3 implements Runnable {
	
	 private Semaphore c; // Semaphore C
	    private Semaphore a; // Semaphore A
	    private Object lock; //lock object for synchronization

	    // Constructor to initialize Semaphore C, Semaphore A, and the lock object
	    public Thread3(Semaphore c, Semaphore a, Object lock) {
	        this.c = c;
	        this.a = a;
	        this.lock = lock;
	    }

	    @Override
	    public void run() {
	        while (true) { // Infinite loop to keep the thread running
	            try {
	                c.acquire(); // Acquire Semaphore C, blocks if not available
	                System.out.println("Thread C"); 
	                Thread.sleep(1000); // Simulating execution time of code block C

	                synchronized (lock) { // Synchronize on the shared lock object
	                    a.release(); // Release Semaphore A, allowing Thread1 to execute its code block
	                    lock.notify(); // Notify Thread2 to continue
	                }
	            } catch (InterruptedException e) { // Catch and handle InterruptedException
	                e.printStackTrace(); // Print the stack trace of the exception
	            }
	        }
	    }
 
    


 
}