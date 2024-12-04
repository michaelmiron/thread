/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

// Create Thread
public abstract class Player extends Thread {
	
	//variables to store playerType and reference to the game
	protected PlayerType playerType;
	    protected Game game;

	    //Constructor initialize the Player type and game
	    public Player(PlayerType playerType, Game game) {
	        this.playerType = playerType;
	        this.game = game;
	    }

	    // Abstract method to be implemented by subclasses to make a move
	    public abstract void makeMove();
	

}
