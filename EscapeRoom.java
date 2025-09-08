import java.util.Scanner;

public class EscapeRoom {
    public static void main(String[] args) {
        // Initialize the game board
        GameGUI game = new GameGUI();
        game.createBoard();

        // Set the player's initial position
        int px = 0;
        int py = 0;

        int score = 0;

        Scanner in = new Scanner(System.in);
        String[] validCommands = { "right", "left", "up", "down", "jump", "pickup", "quit", "replay", "help" };

        // Display a welcome message
        System.out.println("Welcome to EscapeRoom!");
        System.out.println("Get to the other side of the room, avoiding walls and invisible traps.");
        System.out.println("Pick up all the prizes.\n");

        boolean play = true;
        while (play) {
            System.out.println("Enter a command: ");
            String input = in.nextLine().toLowerCase(); // Read user input and convert to lowercase for consistency

            if (input.equals("quit")) {
                play = false;
            } else if (input.equals("replay")) {
                score += game.replay();
                System.out.println("Score: " + score);
                System.out.println("Steps: " + game.getSteps());
                System.out.println("Score has been reset.");
                score = 0;
            } else if (input.equals("help")) {
                System.out.println("Valid commands: " + String.join(", ", validCommands));
            } else if (input.equals("pickup")) {
                score += game.pickupPrize();
            } else if (input.equals("right")) {
                px += 1;
            } else if (input.equals("left")) {
                px -= 1;
            } else if (input.equals("up")) {
                py -= 1;
            } else if (input.equals("down")) {
                py += 1;
            } else if (input.equals("jump")) {
                // Implement jumping logic here (e.g., check if jumping is allowed and update px and py accordingly)
            }

            // Check for traps and handle trap logic here
            if (game.isTrap(px, py)) {
                score += game.springTrap(px, py);
            }

            // Move the player and update the score
            score += game.movePlayer(px, py);
        }

        // End the game and display final score and steps
        score += game.endGame();
        System.out.println("Final Score: " + score);
        System.out.println("Total Steps: " + game.getSteps());
    }
}
