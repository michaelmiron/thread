/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/

package XO;


public abstract class Game {
	
	 protected char[][] gameBoard;
	    protected PlayerType currentPlayer;

	    // Constructor
	    public Game() {
	        gameBoard = new char[5][5];
	        initializeBoard();
	    }

	    // Method to print the board
	    public void printBoard() {
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                System.out.print(gameBoard[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    // Abstract method to get the current player's turn
	    public abstract PlayerType getTurn();

	    // Abstract method to get the free cells on the board
	    public abstract Coordinate[] getFreeCells();

	    // Helper method to initialize the board
	    protected void initializeBoard() {
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 5; j++) {
	                gameBoard[i][j] = ' ';
	            }
	        }
	    }

	    // Method to check if a cell is empty
	    public boolean isCellEmpty(int row, int col) {
	        return gameBoard[row][col] == ' ';
	    }

	    // Method to set a symbol in a cell on the board
	    public void setCell(int row, int col, char symbol) {
	        gameBoard[row][col] = symbol;
	    }

		protected abstract boolean winner(PlayerType playerType);

		protected abstract boolean isBoardFull();

		protected abstract void nextTurn();


		
	

}
