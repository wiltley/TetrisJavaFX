package com.example.tetris;
import java.util.HashMap;

public abstract class Block {

    int[][] currentCoords;
    public int current_state;
    HashMap<Integer, Boolean> possibleStates;

    Block(){

        possibleStates = new HashMap<Integer, Boolean>();

        possibleStates.put(1,false);
        possibleStates.put(2, false);
        possibleStates.put(3, false);
        possibleStates.put(4, false);

    }

    public int[][] updateArray(int [][] array){

        System.out.println(currentCoords.length);
        for(int i = 0; i < currentCoords.length; i++){

            array[currentCoords[i][0]][currentCoords[i][1]]= 2;
        }

        return array;
    }

    public void printAllCoords(){

        for(int i = 0; i < currentCoords.length-2; i++){
            System.out.println(currentCoords[i][0]);
            System.out.println(currentCoords[i][1]);
            System.out.println();
        }
    }

    private int[][] clearPreviousPosition(int[][] array){

        for(int i = 0; i < currentCoords.length; i++){
            array[currentCoords[i][0]][currentCoords[i][1]] = 0;
        }
        return array;
    }

    private int[][] update(int dirX, int dirY, int [][] array){
        clearPreviousPosition(array);
        for(int i = 0; i < currentCoords.length; i++){
            currentCoords[i][0] += dirY;
            currentCoords[i][1] += dirX;

        }

        return updateArray(array);

    }

    // all the check in this function are beyond broken... they barely do anything
    public int[][] moveRight(int[][] array){
        // checks to see if the space around the block is free.
        for(int i = 0; i < currentCoords.length; i++){

            if(array[currentCoords[i][0]][currentCoords[i][1]+1] == 1){

                return array;
            }

        }

        return update(1, 0, array);
    }

    public int[][] moveLeft(int[][] array){

        for(int i = 0; i < currentCoords.length; i++){

            if(array[currentCoords[i][0]][currentCoords[i][1]-1] == 1){

                return array;
            }

        }
        return update(1,0,array);

    }

    public int[][] getSlice(int[][] array){

        int[][] slice = new int[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                slice[i][j] = array[currentCoords[2][0]-1 + i][currentCoords[2][1]-1+j];
            }
        }
        return slice;
    }

    public int[][] moveDown(int[][] array){
        return update(0,1,array);
    }

    public abstract int[][] rotate(int[][] array, int dir);

    public abstract void checkIfFree(int[][] array);

}
