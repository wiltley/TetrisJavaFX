package com.example.tetris;
public class LBlock extends Block {
    LBlock(){
        // currentCords is an array that holds an array.
        // the array that it holds is containing the x and y coordinates of the block in the main array.
        // fix issue where stuff are inverted
        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,3};
        currentCoords[1] = new int[]{2,3};
        currentCoords[2] = new int[]{2,4};
        currentCoords[3] = new int[]{2,5};


    }
    @Override
    public int[][] rotateR(int[][] array){

        return array;

    }

    @Override
    public int[][] rotateL(int[][] array){

        return array;

    }

}
