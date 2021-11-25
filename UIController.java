package com.example.tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UIController extends Application{

        GridPane root = new GridPane();
    private Parent createContent(int x, int y) {
        Region rect= new Region();
        rect.setStyle("-fx-border-style: solid; -fx-border-width: 5; -fx-border-color: black;");
        Rectangle box = new Rectangle(100, 50, Color.TRANSPARENT);

        rect.setTranslateX(25);
        rect.setTranslateY(120);
        rect.setPrefSize(375,750);
        root.getChildren().add(rect);
        transform(box);

        return new Pane(root);
    }

    private void transform(Rectangle box) {
        // we will apply transformations here
        box.setTranslateX(100);
        box.setTranslateY(200);
    }

    private void drawRectangles(int[][] array){

        for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[0].length; j++){
                if (array[i][j] == 2){

                    root.getChildren().add(new Rectangle(20,20, Color.TRANSPARENT));
                }
            }
        }

    }

    @Override
    public void start(Stage stage) throws Exception {


        VBox main = new VBox();
        Scene scene = new Scene(createContent(1,1), 585, 900);

        stage.setTitle("Tetris!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public void launch(){
        Application.launch();
    }
}