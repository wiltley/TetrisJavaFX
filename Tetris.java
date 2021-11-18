package com.example.tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

import java.io.IOException;

public class Tetris extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tetris.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Tetris!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        GameHandler.new_game();
        GameHandler.blocksList.add(new LBlock());

        Scanner scan = new Scanner(System.in);
        String scanned;
        GameHandler.printGrid();
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
        //launch();
    }


}