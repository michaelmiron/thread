/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package Assign3_3;

public class SlicerThread extends Thread  {

	// Reference to the SlicerMachine instance
    private SlicerMachine machine;

    // Constructor to initialize the SlicerMachine instance
    public SlicerThread(SlicerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        // Continue running until the thread is interrupted
        while (!Thread.interrupted()) {
            try {
                // Simulate time to slice vegetables by sleeping for 1000 milliseconds (1 second)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // If interrupted, set the interrupt flag and return from the run method
                Thread.currentThread().interrupt();
                return;
            }
            
            // Call the slicer method of the machine to slice vegetables
            machine.sliceVegetables();
        }
    }
	
	
}
