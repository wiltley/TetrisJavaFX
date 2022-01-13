package com.example.tetris;


public class LBlock extends Block {

    public int current_state;
    LBlock(){

        super();
        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,5};
        currentCoords[1] = new int[]{2,5};
        currentCoords[2] = new int[]{2,4};
        currentCoords[3] = new int[]{2,3};
        current_state = 2;

    }
    @Override
    public void rotate(int dir){

        int[] axis_rotate_top = new int[]{currentCoords[2][1]-1,currentCoords[2][1]+1};
        int[] axis_rotate_bot = new int[]{currentCoords[2][1]+1,currentCoords[2][1]+1};

        if(current_state+dir == 1){
           currentCoords[0][1]+= 2;
           currentCoords[1] = axis_rotate_top;


        }

    }

    // This entire thing right ehre may not actually be needed. It's just confusing me atm to behonest
    // a different way I could go about checking is seeing if theres any confliction after having rotated
    // and reflecting in array. Would be a lot simpler and I wouldn't need individual checkIfFree for each method.
    /*
        int[][]slice = getSlice(array);

        if(slice[0][1] == 0 && slice[2][1] == 0 && slice[2][2] == 0){ this.possibleStates.put(1, true);}
        else{this.possibleStates.put(1, true);}

        if(slice[1][0] == 0 && slice[1][2] == 0 && slice[0][2] == 0){ this.possibleStates.put(2, true);}
        else{this.possibleStates.put(2, false);}

        if(slice[0][0] == 0 && slice[0][1] == 0 && slice[1][2] == 0){ this.possibleStates.put(3, true);}
        else{this.possibleStates.put(3, false);}

        if(slice[1][0] == 0 && slice[2][0] == 0 && slice[1][2] == 0){this.possibleStates.put(4, true);}
        else{this.possibleStates.put(4,false);}
    */
}

