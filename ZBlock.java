package com.example.tetris;

public class ZBlock extends Block {

    ZBlock(){
        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,3};
        currentCoords[1] = new int[]{1,4};
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
