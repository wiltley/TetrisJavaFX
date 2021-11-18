package com.example.tetris;
import java.util.ArrayList;

public class GameHandler {

    public static int highscore;
    public static int score;
    public static int timer;
    public static int fallSpeed;
    public static int level;
    public static ArrayList<LBlock> blocksList = new ArrayList<>();
    public static int [][] gameGrid = new int[20][10];

    //IMPORTANT REMEMBER THAT NEW GAME CLEARS THE ARRAY


    public static void new_game(){

       if (score > highscore){
           highscore = score;
       }

       for(int i = 0; i < gameGrid.length; i++){
           for(int j = 0; j < gameGrid[i].length; j++){

               gameGrid[i][j] = 0;

           }
       }

       score = 0;
       timer = 0;
       fallSpeed = 0;// should be dependent on timer in some way
       blocksList.clear();

    }

    public static void printGrid(){

        for(int i = 0; i < gameGrid.length; i++){

            for(int j = 0; j < gameGrid[0].length; j++){

                System.out.print(gameGrid[i][j]);
            }

            System.out.println("\n");
        }

    }


    //test function

    public static void updateArray(){
       gameGrid  = blocksList.get(0).moveRight(gameGrid);
    }
}
