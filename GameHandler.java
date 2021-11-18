package com.example.tetris;
import java.util.ArrayList;

public class GameHandler {

    public static int highscore;
    public static int score;
    public static int timer;
    public static int fallSpeed;
    public static int level;
    public static ArrayList<Block> blocksList = new ArrayList<Block>();
    public static int [][] gameGrid = new int[10][20];

    public static void new_game(){

       if (score > highscore){
           highscore = score;
       }

       score = 0;
       timer = 0;
       fallSpeed = 0;// should be dependent on timer in some way
       blocksList.clear();

    }
}
