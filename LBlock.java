package com.example.tetris;
public class LBlock extends Block {
    int[][] currentCoords;
    LBlock(){
        // currentCords is an array that holds an array.
        // the array that it holds is containing the x and y coordinates of the block in the main array.
        // fix issue where stuff are inverted
        currentCoords = new int[4][];
        currentCoords[0] = new int[]{1,3};
        currentCoords[1] = new int[]{2,3};
        currentCoords[2] = new int[]{2,4};
        currentCoords[3] = new int[]{2,5};

        int firstItem = currentCoords[0][1];
        System.out.println(firstItem);


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

    public int[][] moveDown(int[][] array){
        return update(0,1,array);
    }

}
