import java.util.Scanner;
import java.util.Random;

public class NimGame {
  public static void main(String[] args) {
    // Create a Scanner object for reading input
    Scanner scanner = new Scanner(System.in);
    // --------------------------------------------VARIABLES---------------------------------------
    // Initializes the number of stones in the pile
    int stonemin = 10; // minimum amount of pieces
    int stonemax = 50; // maximum amount of pieces
    Random random = new Random();
    int Number = random.nextInt((stonemax - stonemin) + 1) + stonemin; // decides number of stones
    Boolean userTurn = false;
    Boolean CompTurn = false;
    Boolean yes = false;
    Random rand = new Random(); // random variable
    int playerRand = rand.nextInt(2) + 1; // random
    int playerNum = 0;
    int compNum = 0;
    // -------------------------------------Directions + Player input of
    // Name------------------------------------------------------------
    System.out.println("Directions: Who ever removes the last stone loses:");
    System.out.println("");
    System.out.println("Player Name?: ");
    String name = scanner.nextLine();
    System.out.println("Hello, " + name + "!");
    System.out.println("Would You like to play?: ");
    String confirmation = scanner.nextLine();
    if (confirmation.equalsIgnoreCase("yes")) {
      yes = true;
    } else if ((confirmation.equalsIgnoreCase("no"))) {
      yes = false;
    }
    // -------------------------------------Main
    // Code-------------------------------------------------
    // Keep playing the game until there are no more stones left in the pile
    while (Number > 0 || yes == true) {
      if (playerRand == 1) {
        // turn number of player
        int playerNum2 = playerNum += 1;
        // Prompt the player to enter the number of stones to remove
        userTurn = true;
        System.out.println("");
        System.out.println("===============" + name + " Turn " + playerNum2 + "===============");
        System.out.println("There are " + Number + " stones in the pile.");
        System.out.print("Enter the number of stones to remove (1 - " + Number / 2 + "): ");
        int Remove = scanner.nextInt();
        Number -= Remove;
        System.out.println("There are now " + Number + " stones in the pile");
        playerRand = 0;
        // Make sure the player's move is valid (i.e. they remove a valid number of
        // stones)
        if (Remove < 1 || Remove > Number) {
          System.out.println("Invalid move. Please enter a number between (1 - " + Number / 2 + ").");
          System.out.print("Enter the number of stones to remove (1 - " + Number / 2 + "): ");
          System.out.print("Enter the number of stones to remove (1 - " + Number / 2 + "): ");
          int Remove2 = scanner.nextInt();
          Remove2 = Remove;
        }
        // -------------------------------------Artificial
        // Intelligence----------------------------------------
        // Computer playing the game
      } else {
        userTurn = false;
        CompTurn = true;
        if (Number > 0) {
          int compMin = 1;
          int compMax = 0;
          if (Number < 3) {
            compMax = Number;
          } else {
            compMax = Number / 2;
          }
          int compStones = random.nextInt((compMax - compMin) + 1) + compMin;
          // turn number of player
          int compNum2 = compNum += 1;
          userTurn = false;
          System.out.println("");
          System.out.println("===============Computer Turn " + compNum2 + "===============");
          System.out.println("There are now " + Number + " stones in the pile");
          System.out.println("The computer has removed " + compStones + " stones from the pile.");
          Number -= compStones;
          System.out.println("There are now " + Number + " stones in the pile.");
          playerRand = 1;
        }
      }
      // ---------------------------------------Ending
      // Code------------------------------------------------
      // The game is over, so print a game over message
      if (Number == 0) {
        System.out.println("==============================");
        System.out.println("Game over. There are no more stones left in the pile.");
        if (userTurn == false) {
          System.out.println("The player won the game!!!");
          break;
        } else if (CompTurn == true) {
          System.out.println("The computer won the game!!!");
          break;
        }
      }
    } // while statement
    System.out.println("Would you like to play again (y/n): ");
    String again = scanner.nextLine();
    if (again.equalsIgnoreCase("yes")) {
      yes = true;
    } else if (again.equalsIgnoreCase("no")) {
      System.out.println("okay!");
    }
  } // public static statment
} // public class statement