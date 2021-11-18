package com.example.tetris;

import java.util.Scanner;

public class Tetris {


    public static void main(String[] args) {

        GameHandler.new_game();
        GameHandler.blocksList.add(new ZBlock());
        UIController UI = new UIController();

        Scanner scan = new Scanner(System.in);
        String scanned;
        GameHandler.printGrid();

        UI.launch();

        while(true){

            scanned = scan.nextLine();
            System.out.println(scanned);

            if(scanned.equals("r")){

                //GameHandler.blocksList.get(0).updateArray(GameHandler.gameGrid);
                GameHandler.updateArray();
                GameHandler.printGrid();

            }

            System.out.println("-------------------------------");

        }
    }
}