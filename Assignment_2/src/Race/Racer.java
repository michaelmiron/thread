
/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package Race;

public class Racer implements Runnable {

	// Static variable to keep track of global racer IDs
	private static int globalId = 1;

	private int id;
	private int speed;
	private Track track;

	// Constructor for creating a racer with a specified speed and track
	public Racer(int speed, Track track) {

		// Check if speed between 1 to 10, if no throw exception
		if (speed < 1 || speed > 10) {
			throw new IllegalArgumentException("Speed must be between 1 and 10.");
		}
		this.id = globalId++;
		this.speed = speed;
		this.track = track;
	}

	// Method representing the racer's movement
	public void go() {
		int distance = 0;

		// Loop to simulate the racer's movement over a distance of 100 meters
		for (int i = 1; i <= 100; i++) {
			distance += speed;
			System.out.println("Runner " + id + " ran " + distance + " meters");

			// Check if the racer has completed the race
			if (distance >= 100) {
				// Get the current place of the racer and print a finishing message
				int place = track.getFinishedRacers();
				System.out.println("Runner " + id + " finished in " + place + getPlace(place));
				// Update the track to indicate that the racer has finished
				track.racerFinished();
				break;
			}
		}
	}

	// Private method to get the appropriate suffix for a place
	private static String getPlace(int place) {
		if (place % 100 >= 11 && place % 100 <= 13) {
			return "th";
		}
		switch (place % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}

	// Implementation of the Runnable interface's run method
	@Override
	public void run() {
		go();
	}

	public int getId() {
		return id;
	}

}
