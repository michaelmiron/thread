/** 
 * @author EliAlhazov - 318874831
 *         MichaelMiron - 315199109
 **/
//Github: https://github.com/elialhazov/Work_1.git

package XO;

import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Create the game
        Game game;

        // Create menu
        System.out.println("Choose the type of game (1 for User vs User, 2 for User vs Self):");
        int choice = sc.nextInt();

        if (choice == 1) {
            game = new UserGame();
        } else if (choice == 2) {
            game = new SelfGame();
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        // Create players
        Player player1, player2;

        if (choice == 1) {
            player1 = new UserPlayer(PlayerType.X, game);
            player2 = new UserPlayer(PlayerType.O, game);
        } else {
            player1 = new UserPlayer(PlayerType.X, game);
            player2 = new SelfPlayer(PlayerType.O, game);
        }

        // Start the game
        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        try {
            // Wait for both players to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check the winner
        PlayerType winningPlayer = null;
        if (game.winner(PlayerType.X)) {
            winningPlayer = PlayerType.X;
        } else if (game.winner(PlayerType.O)) {
            winningPlayer = PlayerType.O;
        }

        // Print the winner
        System.out.println("Game Over!");
        System.out.println("Winner: " + (winningPlayer != null ? winningPlayer.name() : "No winner yet"));
        
        // close the Scanner
        sc.close();
    }
		
		
		
		
		
		
		
		
		
		
		
}
