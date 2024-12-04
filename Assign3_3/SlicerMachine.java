/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package Assign3_3;

public class SlicerMachine {
	 private int numOfCucumbers = 0;
	    private int numOfTomatoes = 0;
	    private int numOfPreparedSalads = 0;

	    private final int cucumbersNeededForOneSalad = 3;
	    private final int tomatoesNeededForOneSalad = 2;

	    // add one cucumber into the slicer chamber
	    public synchronized void addOneCucumber() {
	        // Wait until there's space for another cucumber in the slicer chamber
	        while (numOfCucumbers >= cucumbersNeededForOneSalad) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // If interrupted, set the interrupt flag and return from the method
	                Thread.currentThread().interrupt();
	                return;
	            }
	        }
	        System.out.println("adding one cucumber to the machine");
	        numOfCucumbers++;
	        // Notify other threads waiting for the slicer chamber
	        notifyAll();
	    }

	    // add one tomato into the slicer chamber
	    public synchronized void addOneTomato() {
	        // Wait until there's space for another tomato in the slicer chamber
	    	while (numOfTomatoes >= tomatoesNeededForOneSalad) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // If interrupted, set the interrupt flag and return from the method
	                Thread.currentThread().interrupt();
	                return;
	            }
	        }
	        System.out.println("adding one tomato to the machine");
	        numOfTomatoes++;
	        // Notify other threads waiting for the slicer chamber
	        notifyAll();
	    }

	    // if there are enough vegetables in the slicer
	    // chamber, make another salad
	    public synchronized void sliceVegetables() {
	        // Wait until there are enough cucumbers and tomatoes for one salad
	    	while (numOfCucumbers < cucumbersNeededForOneSalad || numOfTomatoes < tomatoesNeededForOneSalad) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	                // If interrupted, set the interrupt flag and return from the method
	                Thread.currentThread().interrupt();
	                return;
	            }
	        }
	        // Make a new salad and notify other threads waiting for the slicer chamber
	        makeNewSalad();
	        notifyAll();
	    }

	    // Private method to make a new salad
	    private void makeNewSalad() {
	        System.out.println("== preparing one more salad ==");
	        numOfPreparedSalads++;
	        // update stock
	        numOfTomatoes -= tomatoesNeededForOneSalad;
	        numOfCucumbers -= cucumbersNeededForOneSalad;
	    }

	    // Get the number of salads prepared by the machine
		public synchronized int getNumOfPreparedSalads() {
			return numOfPreparedSalads;
		}

}
