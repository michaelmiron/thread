/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package Assign3_3;

public class CucumberThread extends Thread {

    // Reference to the SlicerMachine instance
	  private SlicerMachine machine;

	    // Constructor to initialize the SlicerMachine instance
	    public CucumberThread(SlicerMachine machine) {
	        this.machine = machine;
	    }

	    @Override
	    public void run() {
	        // Continue running until interrupted
	        while (!interrupted()) {
	            try {
	                Thread.sleep(500); // Simulate time to add one cucumber
	            } catch (InterruptedException e) {
	            	
	                // If interrupted, set the interrupt flag and return from the run method
	                Thread.currentThread().interrupt();
	                return;
	            }
	            // Add one cucumber to the slicer machine
	            machine.addOneCucumber();
	        }
	    
    
	    
	    
    
    
    	
    	
    }
	
}
