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
    public int takeaway(int sizeOfMarker, int amountTakeAway){
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
        else return false;
    }
}


