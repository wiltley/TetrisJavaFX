package com.example.tetris;
import java.util.LinkedList;

public class GameHandler {

    public static int highscore;
    public static int score;
    public static int timer;
    public static int fallSpeed;
    public static int level;
    public static LinkedList<Block> blocksList = new LinkedList<>();
    public static int current_index;
    public static int [][] gameGrid = new int[22][12];


    //IMPORTANT REMEMBER THAT NEW GAME CLEARS THE ARRAY
    public static void new_game(){

       if (score > highscore){
           highscore = score;
       }

       for(int i = 0; i < gameGrid.length; i++){
           for(int j = gameGrid[i].length-1; j > -1; j--){
               if(j == 0 || j == 11 ||  i == 0 || i == 21){
                   gameGrid[i][j] = 1;
               }else{
                   gameGrid[i][j] = 0;
               }

           }
       }

       score = 0;
       timer = 0;
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
        for(int i =0; i < 100; i ++){
            blocksList.add(new TBlock());
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


    public static void drop(int i){
       if(i == 1){
           blocksList.get(current_index).drop(1);
       }
       else{
           blocksList.get(current_index).drop(0);
       }

        blocksList.get(current_index).changeToNonActive();
        current_index+=1;
        System.out.println("The size of blockslist is: " + blocksList.size());
    }

}
