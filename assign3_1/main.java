/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package assign3_1;

import java.util.concurrent.Semaphore;

public class main {
	   public static void main(String[] args) {
		   
	        // Initialize semaphores and a lock object
		   Semaphore semaphoreA = new Semaphore(1);
	        Semaphore semaphoreB = new Semaphore(0);
	        Semaphore semaphoreC = new Semaphore(0);
	        Object lock = new Object();

	        // Create threads
	        Thread thread1 = new Thread(new Thread1(semaphoreA, semaphoreB));
	        Thread thread2 = new Thread(new Thread2(semaphoreB, semaphoreC, lock));
	        Thread thread3 = new Thread(new Thread3(semaphoreC, semaphoreA, lock));

	        // Start threads
	        thread1.start();
	        thread2.start();
	        thread3.start();
	   }
}
