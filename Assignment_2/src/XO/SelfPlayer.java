/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

import java.util.Random;

public class SelfPlayer extends Player {

	// Constructor to initialize the SelfPlayer with a specific playerType and game
	public SelfPlayer(PlayerType playerType, Game game) {
		super(playerType, game);
	}

	@Override
	public void makeMove() {
		// If the game is not over then play
		while (!game.isBoardFull() && !game.winner(playerType)) {
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
           // Check if it's the current player's turn
			if (playerType == game.getTurn()) {
				Coordinate[] cells = game.getFreeCells();
				Random rnd = new Random();

				// Check if there are available cells to make a move
				if (cells.length > 0) {
					Coordinate randomCell = cells[rnd.nextInt(cells.length)];
					game.setCell(randomCell.row, randomCell.col, playerType.name().charAt(0));
					game.printBoard();

					if (game.winner(playerType)) {
						System.out.println("Player " + playerType.name() + " Won!");
					} else if (game.isBoardFull()) {
						System.out.println("Tie!");
					} else {
						game.nextTurn();
					}
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
