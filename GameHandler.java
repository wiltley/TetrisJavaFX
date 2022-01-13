package com.example.tetris;
import javafx.scene.paint.Color;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class GameHandler {

    public static int highscore;
    public static int score;
    public static int fallSpeed;
    public static int level;
    public static LinkedList<Block> blocksList = new LinkedList<>();
    public static LinkedList<Integer> clearList = new LinkedList<>();
    public static int current_index;
    public static int [][] gameGrid = new int[22][12];
    public static Color [][] colorGrid = new Color[22][12];
    public static int randomBlock;


    //IMPORTANT REMEMBER THAT NEW GAME CLEARS THE ARRAY
    public static void new_game(){

       if (score > highscore){
           highscore = score;
       }

       for(int i = 0; i < gameGrid.length; i++){
           for(int j = gameGrid[i].length-1; j > -1; j--){
               if(j == 0 || j == 11 ||  i == 0 || i == 21){
                   gameGrid[i][j] = 1;
                   colorGrid[i][j] = Color.TRANSPARENT;
               }else{
                   gameGrid[i][j] = 0;
                   colorGrid[i][j] = Color.TRANSPARENT;
               }

           }
       }
        //might wanna make this its own class
       score = 0;
       fallSpeed = 0;// should be dependent on timer in some way
       blocksList.clear();
       current_index = 0;
        newBlock();
        System.out.println("The size of blockslist is: " + blocksList.size());

    }

    public static void printGrid(){
        for(int i = 0; i < gameGrid.length; i++){
            for(int j = 0; j < gameGrid[0].length; j++){
                System.out.print(gameGrid[i][j]);
            }
            System.out.println("\n");
        }
    }

    public static void newBlock(){
        Random number = new Random();
        for(int i =0; i < 100; i ++){

            randomBlock = number.nextInt(5);
            if(randomBlock == 4){ blocksList.add(new SqBlock());}
            if(randomBlock == 3){ blocksList.add(new TBlock());}
            if(randomBlock == 2){ blocksList.add(new ZBlock());}
            if(randomBlock == 1){ blocksList.add(new SBlock());}

        }

    }


    public static void move(int dir){
        System.out.println("The size of blockslist is: " + blocksList.size());
        if(dir == 1){
            blocksList.get(current_index).moveHorizontally(1);
        }else{
            blocksList.get(current_index).moveHorizontally(-1);
        }
        printGrid();
    }
    public static void rotate(){

        System.out.println("The size of blockslist is: " + blocksList.size());
        blocksList.get(current_index).rotate(1);
        printGrid();
    }

    public static int checkLineClear() {

        int flag = 0;
        int counter = 0;

        for (int i = 0; i < gameGrid.length-1; i++) {
            flag = 0;

            for (int j = 1; j < gameGrid[i].length - 2; j++) {
                if(flag == 0) {
                   if(gameGrid[i][j] == 0){
                       flag = 1;
                   }
                }
            }

            if(flag == 0){
                for (int j = 1; j < gameGrid[i].length-1; j++) {
                    gameGrid[i][j] = 0;
                }
                counter+=1;
            }
        }
        return counter;
    }

    public static void shiftGrid(int d){

    }

    public static void endTurn(){
        blocksList.get(current_index).changeToNonActive();
        current_index+=1;
        printGrid();
        blocksList.get(current_index).update();
        int toShift = checkLineClear();
        if(toShift != 0){}

    }

    public static void drop(int i){
       if(i == 1){
           blocksList.get(current_index).drop(1);
           endTurn();
       }
       else{
           blocksList.get(current_index).drop(0);
       }

        System.out.println("The size of blockslist is: " + blocksList.size());
    }

}
