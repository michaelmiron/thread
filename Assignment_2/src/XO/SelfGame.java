/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

import java.util.Random;

public class SelfGame extends Game {

	//Constructor initializes the game board and set the player
	SelfGame() {
		
        // Initialize the game board with empty spaces
		gameBoard = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBoard[i][j] = ' ';
			}
		}
		// Set player X
		currentPlayer = PlayerType.X;
	}

    // Method to get the current turn player type
	public PlayerType getTurn() {
		return currentPlayer;
	}

	// Method to get an array of coordinates representing free cells on the game board

	public Coordinate[] getFreeCells() {
		Coordinate[] cell;
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					count++;
				}
			}
		}
		cell = new Coordinate[count];
		count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					cell[count++] = new Coordinate(i, j);
				}
			}
		}
		return cell;
	}

    // Protected method to check if the game board is full
	protected boolean isBoardFull() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
// Protected method to check winner
	protected boolean winner(PlayerType p) {
		for (int i = 0; i < 5; i++) {
			if ((gameBoard[i][0] == p.name().charAt(0) && gameBoard[i][1] == p.name().charAt(0)
					&& gameBoard[i][2] == p.name().charAt(0) && gameBoard[i][3] == p.name().charAt(0))) {
				return true;
			} else if ((gameBoard[0][i] == p.name().charAt(0) && gameBoard[1][i] == p.name().charAt(0)
					&& gameBoard[2][i] == p.name().charAt(0) && gameBoard[3][i] == p.name().charAt(0))) {
				return true;
			}
		}
		if ((gameBoard[0][0] == p.name().charAt(0) && gameBoard[1][1] == p.name().charAt(0)
				&& gameBoard[2][2] == p.name().charAt(0) && gameBoard[3][3] == p.name().charAt(0)
				|| gameBoard[1][1] == p.name().charAt(0) && gameBoard[2][2] == p.name().charAt(0)
						&& gameBoard[3][3] == p.name().charAt(0) && gameBoard[4][4] == p.name().charAt(0)
				|| gameBoard[0][1] == p.name().charAt(0) && gameBoard[1][2] == p.name().charAt(0)
						&& gameBoard[2][3] == p.name().charAt(0) && gameBoard[3][4] == p.name().charAt(0)
				|| gameBoard[1][0] == p.name().charAt(0) && gameBoard[2][1] == p.name().charAt(0)
						&& gameBoard[3][2] == p.name().charAt(0) && gameBoard[4][3] == p.name().charAt(0))) {
			return true;
		}
		return false;

	}
	
	// Synchronized method to play a turn for the specified player

	synchronized void playTurn(Player p) {
		  if (isBoardFull() || winner(currentPlayer)) {
		        return;
		    }

		    if (currentPlayer.equals(getTurn())) {
		        Coordinate[] cells = getFreeCells();
		        Random rnd = new Random();
		        Coordinate randomCell = cells[rnd.nextInt(cells.length)];
		        setCell(randomCell.row, randomCell.col, currentPlayer.name().charAt(0));
		        printBoard();

		        if (winner(currentPlayer)) {
		            String result = (currentPlayer == PlayerType.X) ? "Player 1 Won!" : "Player 2 Won!";
		            System.out.println(result);
		        } else if (isBoardFull()) {
		            System.out.println("Tie!");
		        } else {
		            currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
		            
		            // Notify the waiting thread if the turn is completed
		            notify();
		        }
		    } else {
		        try {
		            wait();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
	}
	
    // Method to switch to the next turn
	public void nextTurn() {
        currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }

}
