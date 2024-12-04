/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package assign3_1;

import java.util.concurrent.Semaphore;

public class Thread1 implements Runnable {

	private Semaphore a; // Semaphore A
    private Semaphore b; // Semaphore B

    // Constructor to initialize Semaphore A and B
    public Thread1(Semaphore a, Semaphore b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        while (true) { // Infinite loop to keep the thread running
            try {
                a.acquire(); // Acquire Semaphore A
                System.out.println("Thread A");
                Thread.sleep(1000); // Simulating execution time
                b.release(); // Release Semaphore B, allowing other threads to execute their code blocks
            } catch (InterruptedException e) { // Catch and handle InterruptedException
                e.printStackTrace(); // Print the stack trace of the exception
            }
        }
    }

}
