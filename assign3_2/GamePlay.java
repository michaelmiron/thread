/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package assign3_2;

import java.util.Random;

public class GamePlay {

	// Flag to indicate whether the coin is available
	private boolean coin_available = false;

	// Counter to keep track of the number of rounds played
	private int rounds_counter = 0;

	// Method to make the coin available or not
	public synchronized void makeCoinAvail(boolean val) {

		coin_available = val;

		// Check if the coin is made available or not
		if (val) {
			System.out.println("Coin is available now");
			// Notify waiting threads that the coin is available
			notifyAll();
		} else {
			System.out.println("Coin is not available now");
		}

	}

	// Method to simulate flipping the coin
	public synchronized int flipCoin() throws InterruptedException {

		// Check if the coin is not available, and wait until it becomes available
		if (!coin_available) {
			System.out.println(Thread.currentThread().getName() + " is waiting for coin");
			wait();
		}

		// Flip the coin and update counters
		System.out.println(Thread.currentThread().getName() + " is flipping coin");
		coin_available = false;
		rounds_counter++;
		int result = new Random().nextInt(2);

		// Simulate some processing time
		Thread.sleep(1000);

		// Make the coin available again and notify all waiting threads
		coin_available = true;
		notifyAll();

		return result;

	}

	// Method to get the number of rounds played
	public synchronized int getNumOfRounds() {
		return rounds_counter;
	}

}
