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
    public int[][] rotate(int[][] array, int dir){

        if(possibleStates.get(current_state+dir)){
            
        }
        return array;

    }

    @Override
    public void checkIfFree(int [][] array) {

        int[][]slice = getSlice(array);

        if(slice[0][1] == 0 && slice[2][1] == 0 && slice[2][2] == 0){ this.possibleStates.put(1, true);}
        else{this.possibleStates.put(1, true);}

        if(slice[1][0] == 0 && slice[1][2] == 0 && slice[0][2] == 0){ this.possibleStates.put(2, true);}
        else{this.possibleStates.put(2, false);}

        if(slice[0][0] == 0 && slice[0][1] == 0 && slice[1][2] == 0){ this.possibleStates.put(3, true);}
        else{this.possibleStates.put(3, false);}

        if(slice[1][0] == 0 && slice[2][0] == 0 && slice[1][2] == 0){this.possibleStates.put(4, true);}
        else{this.possibleStates.put(4,false);}

    }

}
