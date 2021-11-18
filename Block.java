package com.example.tetris;

abstract class Block {


    private static int blockCount = 0;

    public boolean isRotatable(){

       return true;
    }

    public int getBlockCount(){
        return blockCount;
    }

    public boolean isControllable(){

        return false;
    }

    public boolean iAmLblock(){

        return false;
    }

}
