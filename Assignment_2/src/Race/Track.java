
/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
package Race;

public class Track {

	  private int finishedRacers = 0;

	    public void racerFinished() {
	        finishedRacers++;
	        System.out.println("Racer finished! Total finished racers: " + finishedRacers);
	    }

	    public int getFinishedRacers() {
	        return finishedRacers;
	    }
	
	
	
	
	
}
