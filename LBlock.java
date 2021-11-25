package com.example.tetris;

import java.util.Arrays;

public class LBlock extends Block {

    public int state;
    LBlock(){

        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,5};
        currentCoords[1] = new int[]{2,5};
        currentCoords[2] = new int[]{2,4};
        currentCoords[3] = new int[]{2,3};

        // states are written in my notebook
        state = 2;


    }
    @Override
    public int[][] rotateR(int[][] array){

        return array;

    }

    @Override public int[][] rotateL(int[][] array){
        return array;

    }

    public int[][] checkIfFree(int [][] array){
        int[][] futureCoords = new int[2][2];
        if(this.state == 2){

            if((array[currentCoords[0][0]][currentCoords[0][1]-2] == 0) &&
                    (array[currentCoords[1][0]-1][currentCoords[0][1]-1] == 0 &&
                            array[currentCoords[3][0]+1][currentCoords[3][1]+1] == 0)){
                this.state = 3;
            }

        }else if(this.state == 3){
            if((array[currentCoords[0][0]+2][currentCoords[0][1]] == 0) &&
                    (array[currentCoords[1][0]+1][currentCoords[0][1]-1] == 0 &&
                            array[currentCoords[3][0]+1][currentCoords[3][1]+1] == 0)) {
                this.state = 4;
            }
        }else if(this.state == 4){
            if((array[currentCoords[0][0]][currentCoords[0][1]+2] == 0) &&
                    (array[currentCoords[1][0]+1][currentCoords[0][1]+1] == 0 &&
                            array[currentCoords[3][0]-2][currentCoords[3][1]-1] == 0)) {
                this.state = 1;
            }
        }
        return array;

    }

}
