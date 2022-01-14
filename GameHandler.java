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
    public static void initialize(int[][] grid, int resetColor){
        for(int i = 0; i < grid.length; i++){
            for(int j = grid[i].length-1; j > -1; j--){
                if(j == 0 || j == 11 ||  i == 0 || i == 21){
                    grid[i][j] = 1;
                }else{
                    grid[i][j] = 0;
                }

                if(resetColor == 1) {
                    colorGrid[i][j] = Color.TRANSPARENT;
                }

            }
        }
    }
    public static void new_game(){

       if (score > highscore){
           highscore = score;
       }

       initialize(gameGrid, 1);

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

    public static boolean checkFull(int index, int n){
        for(int i =1; i < gameGrid[index].length-1;i++){
           if(gameGrid[index][i] != n){
               return false;
           }
        }
        return true;
    }

    public static int checkLineClear() {

        int counter = 0;
        for (int i = 0; i < gameGrid.length-1; i++) {
            if(checkFull(i, 2)){
                for (int j = 1; j < gameGrid[i].length-1; j++) {
                    //gameGrid[i][j] = 2;
                    colorGrid[i][j] = Color.TRANSPARENT;
                }
                counter+=1;
            }
        }
        return counter;
    }

    public static void reconstruct(int d){
        for(int i = 1; i < gameGrid.length-1; i++){
            if(checkFull(i, 2)){
                for(int j = i; j > 1; j--){
                    for(int k = 0; k < gameGrid[i].length; k ++){
                        gameGrid[j][k] = gameGrid[j-1][k];
                        colorGrid[j][k]= colorGrid[j-1][k];

                    }

                    //these two lines below, without the for loop above caused me a massive headache
                    //--reminder to investigate into the behaviour of these two lines and the "why" behind the stupid bug i spent 2 hours trying to fix.
                    //gameGrid[j] = gameGrid[j-1];
                    //colorGrid[j]= colorGrid[j-1];

                }

            }
        }
    }

    public static void endTurn(){
        //System.out.println("called");
        blocksList.get(current_index).changeToNonActive();
        int toShift = checkLineClear();
        if(toShift != 0){reconstruct(toShift);}
        //printGrid();
        current_index+=1;
        blocksList.get(current_index).update();

    }

    public static void drop(int i){
       if(i == 1){
           blocksList.get(current_index).drop(1);
           endTurn();
       }
       else{
           blocksList.get(current_index).drop(0);
       }

        //System.out.println("The size of blockslist is: " + blocksList.size());

    }

}
