/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package Assign3_3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		// Create a SlicerMachine instance
		SlicerMachine machine = new SlicerMachine();

		// Create threads for each ingredient type
		CucumberThread cucumberThread = new CucumberThread(machine);
		TomatoesThread tomatoesThread = new TomatoesThread(machine);
		SlicerThread slicerThread = new SlicerThread(machine);

		// Start the threads for each ingredient type
		cucumberThread.start();
		tomatoesThread.start();
		slicerThread.start();

		try {
			Thread.sleep(numOfSaladsToPrepare * 2000); // Simulate the time for preparing salads
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Interrupt the threads to stop the simulation
		cucumberThread.interrupt();
		tomatoesThread.interrupt();
		slicerThread.interrupt();

		System.out.println("Done. Total Salads Prepared: " + machine.getNumOfPreparedSalads());

		// Close the scanner
		scan.close();
	}

}
