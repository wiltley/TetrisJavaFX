package com.example.tetris;

public class SBlock extends Block{

    SBlock(){
        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,4};
        currentCoords[1] = new int[]{1,3};
        currentCoords[2] = new int[]{2,3};
        currentCoords[3] = new int[]{2,2};
    }

    @Override
    public void rotate(int dir) {

    }


}
