/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package assign3_2;

public class Judge extends Thread {

	// Reference to the GamePlay instance
	private GamePlay gameplay;

	// Constructor to initialize the GamePlay instance
	public Judge(GamePlay gameplay) {
		this.gameplay = gameplay;
	}

	// Method to manage the availability of the coin
	public void manageCoin() {
		// Continue managing the coin until interrupted
		while (!isInterrupted()) {
			// Synchronize on the GamePlay instance to safely manipulate the coin
			// availability
			synchronized (gameplay) {
				try {
					// Make the coin unavailable and wait for 1 second
					gameplay.makeCoinAvail(false);
					Thread.sleep(1000);

					// Make the coin available again and wait for 0.5 seconds
					gameplay.makeCoinAvail(true);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// Handle interruptions by interrupting the thread
					interrupt();
				}
			}
		}
	}

	// Override the run method to start managing the coin when the thread is started
	@Override
	public void run() {
		manageCoin();
	}
}
