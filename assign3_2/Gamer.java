package assign3_2;

/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

public class Gamer extends Thread {

	// Counter to keep track of successful coin flips
	private int goodFlipsCounter = 0;

	// Reference to the GamePlay instance
	private GamePlay gameplay;

	// Constructor to initialize the GamePlay instance
	public Gamer(GamePlay gameplay) {
		this.gameplay = gameplay;
	}

	// Method for the Gamer to play the game
	public synchronized void play() {

		// Continue playing until interrupted or 10 rounds are completed
		while (!isInterrupted() && gameplay.getNumOfRounds() <= 10) {
			try {
				// Attempt to flip the coin and handle the result
				int result = gameplay.flipCoin();
				if (result == 1) {
					// Increment the counter for successful flips
					goodFlipsCounter++;
				}
				// Pause for 1 second between flips
				sleep(1000);

			} catch (InterruptedException e) {
				// Handle interruptions by interrupting the thread
				interrupt();
			}
		}
	}

	public int getScore() {
		return goodFlipsCounter;
	}

	@Override
	public void run() {
		play();
	}

}
