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
        if (isValid(sizeOfMarker, amountTakeAway) &&
                (sizeOfMarker > 0 && amountTakeAway > 0)){
            sizeOfMarker =- amountTakeAway;
            return sizeOfMarker;
        }
        else return sizeOfMarker;
    }

    // returns if the amount to remove from x coloured marker is valid - checks valid move
    public boolean isValid(int sizeOfMarker, int amountTakeAway){
        if ((amountTakeAway <= sizeOfMarker) && sizeOfMarker > 0){
            return true;
        }
        else {
            return false;
        }
    }

    // will check to see which is a zero-position or not by using xor
    // will return either 1, 2, 3 (respective to green, orange, yellow) to let computer know
    // which group of markers to modify
    public int isZeroPos(){
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
    public int randomMove(){
        String marker = randomMarker();
        int chosenAmount = 0;
        chosenAmount = (int) (Math.random() * ((getMarkerAmount(marker) - 1) + 1));

        if (isValid(getMarkerAmount((marker)), chosenAmount)){
            return chosenAmount;
        }
        else{
            return -1;
        }
    }

    // chooses a random marker colour
    public String randomMarker(){
        int stringChooser = (int) (Math.random() * ((3 - 1) + 1));
        if (stringChooser == 1){
            return "green";
        }
        if (stringChooser == 2){
            return "orange";
        }
        else{
            return "yellow";
        }
    }

    public boolean isMyTurn(String whosTurn){
        if ((whosTurn.equals("computer")) || (whosTurn.equals("Computer"))){
            return true;
        }
        else {
            return false;
        }
    }
    // checks to see markers are in a zero position or not and plays accordingly
    public int playWin(){
        if (isZeroPos() == 1){
            return setNewMarker("green", (orange ^ yellow));
        }
        if (isZeroPos() == 2){
            return setNewMarker("orange", (green ^ yellow));
        }
        if (isZeroPos() == 1){
            return setNewMarker("green", (green ^ orange));
        }
        else {
            return setNewMarker(randomMarker(), randomMove());
        }
    }

}


