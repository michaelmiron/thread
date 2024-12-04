/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

import java.util.Arrays;
import java.util.Scanner;

public class UserPlayer extends Player {

	private final Scanner scanner;

    // Constructor to initialize the UserPlayer with a specific playerType and game
    public UserPlayer(PlayerType playerType, Game game) {
        super(playerType, game);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void makeMove() {
        //If the game is not over then play
        while (!game.isBoardFull() && !game.winner(playerType)) {
            // Check if it's the current player's turn
        	if (playerType == game.getTurn()) {
                System.out.println("Current Board:");
                game.printBoard();
                System.out.println("Player " + playerType.name() + ", it's your turn.");

                Coordinate[] cells = game.getFreeCells();
                System.out.println("Available Cells: " + Arrays.toString(cells));

                System.out.println("Enter the row and column (e.g., 1 2):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                // Set the cell on the game board with the user's move
                game.setCell(row, col, playerType.name().charAt(0));
                game.printBoard();

                // Check if the user has won or if the game is a tie
                if (game.winner(playerType)) {
                    System.out.println("Player " + playerType.name() + " Won!");
                    game.nextTurn();  
                } else if (game.isBoardFull()) {
                    System.out.println("Tie!");
                } else {
                    game.nextTurn();  
                }
            } else {
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
	// Override the run method from the Thread class
    @Override
    public void run() {
        makeMove();
    }
	
	
	
	
}
