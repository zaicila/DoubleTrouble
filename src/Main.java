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
                    System.out.println("Computer's turn.");
                    System.out.println(game.printGame());
                    if (game.isZeroPos(game.zeroPos())) {
                        String winComputerMarker = game.playWinMarker();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "yellow";
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerMarker = "orange";
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "green";
                        }
                        while (winComputerMarker.equals("error") || game.getMarkerAmount(winComputerMarker) == 0) {
                            winComputerMarker = game.randomMarker();
                        }
                        int winComputerAmount = game.playWinAmount();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("yellow");
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerAmount = game.getMarkerAmount("orange");
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("green");
                        }
                        while (winComputerAmount == -1) {
                            winComputerAmount = game.randomMove(winComputerMarker);
                        }
                        System.out.println("I choose " + winComputerMarker + " and to take away " + winComputerAmount + " markers.");
                        int winComputerNewAmount = game.takeAway(game.getMarkerAmount(winComputerMarker), winComputerAmount);
                        game.setNewMarker(winComputerMarker, winComputerNewAmount);
                        whosTurnIsIt = 1;
                    } else {
                        String computerMarker = game.randomMarker();
                        while (computerMarker.equals("error") || game.getMarkerAmount(computerMarker) == 0) {
                            computerMarker = game.randomMarker();
                        }
                        int computerAmount = game.randomMove(computerMarker);
                        while (computerAmount == -1) {
                            computerAmount = game.randomMove(computerMarker);
                        }
                        int computerNewAmount = game.takeAway(game.getMarkerAmount(computerMarker), computerAmount);
                        System.out.println("I choose " + computerMarker + " and to take away " + computerAmount + " markers.");
                        game.setNewMarker(computerMarker, computerNewAmount);
                        whosTurnIsIt = 1;
                    }
                }
                if (whosTurnIsIt == 1) {
                    System.out.println("Your turn.");
                    System.out.println(game.printGame());
                    String userMarker = game.userSelectMarker();
                    while (userMarker.equals("error")) {
                        System.out.println("Spell better or type something valid, try again.");
                        userMarker = game.userSelectMarker();
                    }
                    int userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                    while (userAmount == -1) {
                        System.out.println("Invalid number, try again.");
                        userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                    }
                    int userNewAmount = game.takeAway(game.getMarkerAmount(userMarker), userAmount);
                    game.setNewMarker(userMarker, userNewAmount);
                    whosTurnIsIt = 0;
                } else {
                    System.out.println("Something went wrong.");
                }
            }
        }
        if (input.equals("computer")) {
            whosTurnIsIt = 0;
            while (!game.gameEnd()) {
                if (whosTurnIsIt == 0) {
                    System.out.println("Computer's turn.");
                    System.out.println(game.printGame());
                    if (game.isZeroPos(game.zeroPos())) {
                        String winComputerMarker = game.playWinMarker();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "yellow";
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerMarker = "orange";
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "green";
                        }
                        while (winComputerMarker.equals("error") || game.getMarkerAmount(winComputerMarker) == 0) {
                            winComputerMarker = game.randomMarker();
                        }
                        int winComputerAmount = game.playWinAmount();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("yellow");
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerAmount = game.getMarkerAmount("orange");
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("green");
                        }
                        while (winComputerAmount == -1) {
                            winComputerAmount = game.randomMove(winComputerMarker);
                        }
                        System.out.println("I choose " + winComputerMarker + " and to take away " + winComputerAmount + " markers.");
                        int winComputerNewAmount = game.takeAway(game.getMarkerAmount(winComputerMarker), winComputerAmount);
                        game.setNewMarker(winComputerMarker, winComputerNewAmount);
                        whosTurnIsIt = 1;
                    }
                    if (whosTurnIsIt == 1) {
                        System.out.println("Your turn.");
                        System.out.println(game.printGame());
                        String userMarker = game.userSelectMarker();
                        while (userMarker.equals("error")) {
                            System.out.println("Spell better or type something valid, try again.");
                            userMarker = game.userSelectMarker();
                        }
                        int userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                        while (userAmount == -1) {
                            System.out.println("Invalid number, try again.");
                            System.out.println("userAmount: " + userAmount);
                            userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                        }
                        int userNewAmount = game.takeAway(game.getMarkerAmount(userMarker), userAmount);
                        game.setNewMarker(userMarker, userNewAmount);
                        whosTurnIsIt = 0;
                    } else {
                        System.out.println("Something went wrong.");
                    }
                }
            }
        } else {
            whosTurnIsIt = 0;
            while (!game.gameEnd()) {
                if (whosTurnIsIt == 0) {
                    System.out.println("Computer's turn.");
                    System.out.println(game.printGame());
                    if (game.isZeroPos(game.zeroPos())) {
                        String winComputerMarker = game.playWinMarker();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "yellow";
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerMarker = "orange";
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerMarker = "green";
                        }
                        while (winComputerMarker.equals("error") || game.getMarkerAmount(winComputerMarker) == 0) {
                            winComputerMarker = game.randomMarker();
                        }
                        int winComputerAmount = game.playWinAmount();
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("yellow");
                        }
                        if (game.getMarkerAmount("green") == 0 && game.getMarkerAmount("yellow") == 0) {
                            winComputerAmount = game.getMarkerAmount("orange");
                        }
                        if (game.getMarkerAmount("yellow") == 0 && game.getMarkerAmount("orange") == 0) {
                            winComputerAmount = game.getMarkerAmount("green");
                        }
                        while (winComputerAmount == -1) {
                            winComputerAmount = game.randomMove(winComputerMarker);
                        }
                        System.out.println("I choose " + winComputerMarker + " and to take away " + winComputerAmount + " markers.");
                        int winComputerNewAmount = game.takeAway(game.getMarkerAmount(winComputerMarker), winComputerAmount);
                        game.setNewMarker(winComputerMarker, winComputerNewAmount);
                        whosTurnIsIt = 1;
                    }
                    if (whosTurnIsIt == 1) {
                        System.out.println("Your turn.");
                        System.out.println(game.printGame());
                        String userMarker = game.userSelectMarker();
                        while (userMarker.equals("error")) {
                            System.out.println("Spell better or type something valid, try again.");
                            userMarker = game.userSelectMarker();
                        }
                        int userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                        while (userAmount == -1) {
                            System.out.println("Invalid number, try again.");
                            System.out.println("userAmount: " + userAmount);
                            userAmount = game.userSelectAmount(game.getMarkerAmount(userMarker));
                        }
                        int userNewAmount = game.takeAway(game.getMarkerAmount(userMarker), userAmount);
                        game.setNewMarker(userMarker, userNewAmount);
                        whosTurnIsIt = 0;
                    } else {
                        System.out.println("Something went wrong.");
                    }
                }
                if (whosTurnIsIt == 1) {
                    System.out.println("Computer wins. You suck.");
                } else {
                    System.out.println("You win. Good job.");
                }
            }
        }
    }
}