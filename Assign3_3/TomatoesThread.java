/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package Assign3_3;

public class TomatoesThread extends Thread {

	// Reference to the SlicerMachine instance
	private SlicerMachine machine;

	// Constructor to initialize the SlicerMachine instance
	public TomatoesThread(SlicerMachine machine) {
		this.machine = machine;
	}

	@Override
	public void run() {
		// Continue running until the thread is interrupted
		while (!Thread.interrupted()) {
			try {
				// Simulate time to add one tomato by sleeping for 500 milliseconds
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// If interrupted, set the interrupt flag and return from the run method
				Thread.currentThread().interrupt();
				return;
			}

			// Call the method to add one tomato to the slicer machine
			machine.addOneTomato();
		}

	}

}
