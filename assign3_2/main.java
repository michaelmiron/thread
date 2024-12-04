/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package assign3_2;

public class main {

	public static void main(String[] args) {

        // Create a GamePlay instance
		GamePlay gameplay = new GamePlay();

        // Create two Gamer instances with the GamePlay instance
        Gamer player1 = new Gamer(gameplay);
        Gamer player2 = new Gamer(gameplay);

        // Create a Judge instance with the GamePlay instance
        Judge judge = new Judge(gameplay); // Initialize the GamePlay instance

        // Start the threads for players and the judge
        player1.start();
        player2.start();
        judge.start();

        try {
            // Wait for the players to finish
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the judge after the players finish
        judge.interrupt();

        // Get the scores of each player
        int scorePlayer1 = player1.getScore();
        int scorePlayer2 = player2.getScore();

        if (scorePlayer1 > scorePlayer2) {
            System.out.println("Player 1 wins");
        } else if (scorePlayer1 < scorePlayer2) {
            System.out.println("Player 2 wins");
        } else {
            System.out.println("Tie");
        }
    

	    
		
		
		
		
		
		
		
		
	}

}
