package com.example.tetris;

import java.util.Scanner;

public class Tetris {


    public static void main(String[] args) {

        GameHandler.new_game();
        GameHandler.blocksList.add(new TBlock());
        UIController UI = new UIController();

        Scanner scan = new Scanner(System.in);
        String scanned;
        GameHandler.printGrid();

        UI.launch();

        while(true){

            scanned = scan.nextLine();
            System.out.println(scanned);

            System.out.println("alright something is wrong");
            if(scanned.equals("m")) {

                GameHandler.move(1);
                GameHandler.printGrid();

            }
            if(scanned.equals("r")) {

                GameHandler.rotate();
                GameHandler.printGrid();

            }

            System.out.println("-------------------------------");

        }
    }
}