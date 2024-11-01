import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gameSetup game = new gameSetup();
        int whosTurnIsIt = 0; // computer's turn is 0, user's turn is 1
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Double Trouble!");
        System.out.println("In this game, you and your opponent will choose a colour pile to take markers from and how many to take.");
        System.out.println("Whoever takes the last marker is the winner. Good luck!");
        System.out.println("Choose who goes first: user or computer");
        String input = userInput.nextLine();
        if (input.equals("user")) {
            whosTurnIsIt = 1;
            while (!game.gameEnd()) {
                if (whosTurnIsIt == 0) {
                    game.computerTurn();
                    whosTurnIsIt = 1;
                } else if (whosTurnIsIt == 1) {
                    game.userTurn();
                    whosTurnIsIt = 0;
                }
            }
            if(whosTurnIsIt == 1) {
                System.out.println("Computer wins. You suck.");
            }
            if(whosTurnIsIt == 0) {
                System.out.println("User wins. Congrat!");
            }
        }
        else if (input.equals("computer")) {
            whosTurnIsIt = 0;
            while (!game.gameEnd()) {
                if (whosTurnIsIt == 0) {
                    game.computerTurn();
                    whosTurnIsIt = 1;
                } else if (whosTurnIsIt == 1) {
                    game.userTurn();
                    whosTurnIsIt = 0;
                }
            }
            if(whosTurnIsIt == 1) {
                System.out.println("Computer wins. You suck.");
            }
            if(whosTurnIsIt == 0) {
                System.out.println("User wins. Congrat!");
            }
        }
        else if (!input.equals("computer") || !input.equals("user")) {
            whosTurnIsIt = 0;
            System.out.println("You stink at typing, so I will go first.");
            while (!game.gameEnd()) {
                if (whosTurnIsIt == 0) {
                    game.computerTurn();
                    whosTurnIsIt = 1;
                } else if (whosTurnIsIt == 1) {
                    game.userTurn();
                    whosTurnIsIt = 0;
                }
            }
            if(whosTurnIsIt == 1) {
                System.out.println("Computer wins. You suck.");
            }
            if(whosTurnIsIt == 0) {
                System.out.println("User wins. Congrat!");
            }
        }
    }
}