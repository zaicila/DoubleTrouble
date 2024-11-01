import java.util.Scanner;

public class gameSetup {
    private int green;
    private int orange;
    private int yellow;
    // constructor; sets up initial amount of green, orange, and yellow markers
    public gameSetup(){
        green = 3;
        orange = 7;
        yellow = 5;
    }

    // sets new amount of markers
    // marker is a string that will be either 'green', 'orange', or 'yellow' to signify which marker
    // is being changed
    public int setNewMarker(String marker, int markerNewAmount){
        if (marker.equals("green")){
            green = markerNewAmount;
            return green;
        }
        if (marker.equals("orange")){
            orange = markerNewAmount;
            return orange;
        }
        if (marker.equals("yellow")){
            yellow = markerNewAmount;
            return yellow;
        }
        else return -1;
    }

    // takes in original x marker amount and removes the amount to take away from x
    // markers and returns the new amount
    public int takeAway(int sizeOfMarker, int amountTakeAway){
        if (isValid(sizeOfMarker, amountTakeAway)){
            return sizeOfMarker - amountTakeAway;
        }
        else return 0;
    }

    // returns if the amount to remove from x coloured marker is valid - checks valid move
    public boolean isValid(int sizeOfMarker, int amountTakeAway){
        if (amountTakeAway <= sizeOfMarker && sizeOfMarker > 0){
            return true;
        }
        else {
            return false;
        }
    }

    // will check to see which is a zero-position or not by using xor
    // will return either 1, 2, 3 (respective to green, orange, yellow) to let computer know
    // which group of markers to modify
    public int zeroPos(){
        if(green > (orange ^ yellow)){
            return 1;
        }

        if(orange > (green ^ yellow)){
            return 2;
        }

        if(yellow > (green ^ orange)){
            return 3;
        }
        //should never hit this case
        else{
            return -1;
        }
    }

    // checks if game is in zero position and returns boolean
    public boolean isZeroPos(int pos){
        return (pos == 1 || pos == 2 || pos == 3);
    }

    // prints the amount of green, orange, and yellow markers
    public String printGame(){
        return "Green markers: " + green + "\nOrange markers: " + orange + "\nYellow markers: " + yellow;
    }

    public boolean gameEnd(){
        return (green <= 0 && orange <= 0 && yellow <= 0);
    }

    // ----------------------COMPUTER MOVES--------------------------------

    // used by the computer to get the marker amount for a colour
    public int getMarkerAmount(String markerColour){
        if (markerColour.equals("green")){
            return green;
        }

        if (markerColour.equals("orange")){
            return orange;
        }

        if (markerColour.equals("yellow")){
            return yellow;
        }

        // should never hit this case
        else{
            return -1;
        }
    }

    // chooses a random number between 1 and the amount of markers left and returns the random number
    // will also check to make sure move is valid before returning the amount
    public int randomMove(String markerColour) {
        int markerAmount = getMarkerAmount(markerColour);
        int chosenAmount = (int) (Math.random() * (markerAmount - 1)) + 1;

        if (isValid(markerAmount, chosenAmount)) {
            return chosenAmount;
        } else {
            return -1;
        }
    }


    // chooses a random marker colour
    public String randomMarker(){
        int stringChooser = (int) (Math.random() * ((3 - 1) + 1));
        if (stringChooser == 1 && getMarkerAmount("green") != 0){
            return "green";
        }
        if (stringChooser == 2 && getMarkerAmount("orange") != 0){
            return "orange";
        }
        if (stringChooser == 3 && getMarkerAmount("yellow") != 0){
            return "yellow";
        }

        else if(getMarkerAmount("green") == 0 && getMarkerAmount("orange") == 0){
            return "yellow";
        }

        else if(getMarkerAmount("orange") == 0 && getMarkerAmount("yellow") == 0){
            return "green";
        }

        else if(getMarkerAmount("yellow") == 0 && getMarkerAmount("green") == 0){
            return "orange";
        }

        else{
            return "error";
        }

    }

    // checks to see markers are in a zero position or not and plays accordingly
    public String playWinMarker(){
        if (zeroPos() == 1){
            return "green";
        }
        if (zeroPos() == 2){
            return "orange";
        }
        if (zeroPos() == 1){
            return "green";
        }
        else {
            return randomMarker();
        }
    }

    public int playWinAmount(){
        if (zeroPos() == 1){
            return orange ^ yellow;
        }
        if (zeroPos() == 2){
            return green ^ yellow;
        }
        if (zeroPos() == 3){
            return green ^ orange;
        }
        else {
            return randomMove(randomMarker());
        }
    }

    public void computerTurn(){
        System.out.println("Computer's turn.");
        System.out.println(printGame());
        if (isZeroPos(zeroPos())) {
            String winComputerMarker = playWinMarker();
            if (getMarkerAmount("green") == 0 && getMarkerAmount("orange") == 0) {
                winComputerMarker = "yellow";
            }
            if (getMarkerAmount("green") == 0 && getMarkerAmount("yellow") == 0) {
                winComputerMarker = "orange";
            }
            if (getMarkerAmount("yellow") == 0 && getMarkerAmount("orange") == 0) {
                winComputerMarker = "green";
            }
            while (winComputerMarker.equals("error") || getMarkerAmount(winComputerMarker) == 0) {
                winComputerMarker = randomMarker();
            }
            int winComputerAmount = playWinAmount();
            if (getMarkerAmount("green") == 0 && getMarkerAmount("orange") == 0) {
                winComputerAmount = getMarkerAmount("yellow");
            }
            if (getMarkerAmount("green") == 0 && getMarkerAmount("yellow") == 0) {
                winComputerAmount = getMarkerAmount("orange");
            }
            if (getMarkerAmount("yellow") == 0 && getMarkerAmount("orange") == 0) {
                winComputerAmount = getMarkerAmount("green");
            }
            while (winComputerAmount == -1) {
                winComputerAmount = randomMove(winComputerMarker);
            }
            System.out.println("I choose " + winComputerMarker + " and to take away " + winComputerAmount + " markers.");
            int winComputerNewAmount = takeAway(getMarkerAmount(winComputerMarker), winComputerAmount);
            setNewMarker(winComputerMarker, winComputerNewAmount);
        }
        else {
            String computerMarker = randomMarker();
            while (computerMarker.equals("error") || getMarkerAmount(computerMarker) == 0) {
                computerMarker = randomMarker();
            }
            int computerAmount = randomMove(computerMarker);
            while (computerAmount == -1) {
                computerAmount = randomMove(computerMarker);
            }
            int computerNewAmount = takeAway(getMarkerAmount(computerMarker), computerAmount);
            System.out.println("I choose " + computerMarker + " and to take away " + computerAmount + " markers.");
            setNewMarker(computerMarker, computerNewAmount);
        }
    }
    // ----------------------USER MOVES--------------------------------

    // has the user select a marker and returns the selection
    public String userSelectMarker(){
        System.out.println("Please choose a colour: green, orange, yellow");
        gameSetup game = new gameSetup();
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        if(input.equals("green")){
            return "green";
        }

        if(input.equals("orange")){
            return "orange";
        }

        if(input.equals("yellow")){
            return "yellow";
        }

        else{
            return "error";
        }
    }

    public int userSelectAmount(int markerAmount){
        System.out.println("Please the amount of markers you want to take away");
        gameSetup game = new gameSetup();
        Scanner userInput = new Scanner(System.in);
        int input = userInput.nextInt();
        if(isValid(markerAmount, input)){
            return input;
        }
        else{
            return -1;
        }
    }

    public void userTurn(){
        System.out.println("Your turn.");
        System.out.println(printGame());
        String userMarker = userSelectMarker();
        while (userMarker.equals("error")) {
            System.out.println("Spell better or type something valid, try again.");
            userMarker = userSelectMarker();
        }
        int userAmount = userSelectAmount(getMarkerAmount(userMarker));
        while (userAmount == -1) {
            System.out.println("Invalid number, try again.");
            userAmount = userSelectAmount(getMarkerAmount(userMarker));
        }
        int userNewAmount = takeAway(getMarkerAmount(userMarker), userAmount);
        setNewMarker(userMarker, userNewAmount);
    }

}

