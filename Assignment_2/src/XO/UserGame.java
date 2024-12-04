/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;

import java.util.Arrays;
import java.util.Scanner;


public class UserGame extends Game {
	private Scanner scanner;

    public UserGame() {
        gameBoard = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        currentPlayer = PlayerType.X;
        scanner = new Scanner(System.in);
    }

    @Override
    public PlayerType getTurn() {
        return currentPlayer;
    }

    @Override
    public Coordinate[] getFreeCells() {
        Coordinate[] cells;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    count++;
                }
            }
        }
        cells = new Coordinate[count];
        count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == ' ') {
                    cells[count++] = new Coordinate(i, j);
                }
            }
        }
        return cells;
    }

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

    
    synchronized void playTurn(Player p) {
        if (isBoardFull() || winner(currentPlayer)) {
            return;
        }

        if (currentPlayer.equals(getTurn())) {
            System.out.println("Current Board:");
            printBoard();
            System.out.println("Player " + currentPlayer.name() + ", it's your turn.");
            
            Coordinate[] cells = getFreeCells();
            System.out.println("Available Cells: " + Arrays.toString(cells));
            
            System.out.println("Enter the row and column (e.g., 1 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            setCell(row, col, currentPlayer.name().charAt(0));
            printBoard();

            if (winner(currentPlayer)) {
                System.out.println("Player " + currentPlayer.name() + " Won!");
            } else if (isBoardFull()) {
                System.out.println("Tie!");
            } else {
                currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
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
    
    public void nextTurn() {
        currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }
}
