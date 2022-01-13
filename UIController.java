package com.example.tetris;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;

public class UIController extends Application{

        GridPane root = new GridPane();
        ArrayList<Rectangle> list = new ArrayList<>();
        DropShadow dropShadow = new DropShadow();



    private Parent createContent(int x, int y) {
        Region rect= new Region();
        rect.setStyle("-fx-border-style: solid; -fx-border-width: 5; -fx-border-color: black;");
        Rectangle box = new Rectangle(100, 50, Color.TRANSPARENT);

        rect.setTranslateX(25);
        rect.setTranslateY(55);
        rect.setPrefSize(310,610);
        root.getChildren().add(rect);
        transform(box);

        return new Pane(root);
    }



    private void drawNew(){
        int counter = 0;
        list.clear();
        Rectangle rect = new Rectangle(300, 600, Color.WHITESMOKE);
        rect.setTranslateX(30);
        rect.setTranslateY(55);
        root.getChildren().add(rect);

        for(int i =0; i < GameHandler.gameGrid.length;i++) {
            for (int j = 0; j < GameHandler.gameGrid[0].length; j++) {
                if(GameHandler.gameGrid[i][j] != 1 && GameHandler.gameGrid[i][j] != 0){
                   list.add(new Rectangle(30,30,GameHandler.blocksList.get(0).color));
                   dropShadow.setColor(Color.BLACK);
                   dropShadow.setRadius(5);
                   list.get(counter).setEffect(dropShadow);
                   list.get(counter).setTranslateX(j*30);
                   list.get(counter).setTranslateY(i*30-260);
                   root.getChildren().add(list.get(counter));
                   counter += 1;
                   System.out.println(counter);
                }
            }
        }
    }

    private void transform(Rectangle box) {
        // we will apply transformations here
        box.setTranslateX(100);
        box.setTranslateY(200);
    }

    @Override
    public void start(Stage stage) throws Exception {


        VBox main = new VBox();
        Scene scene = new Scene(createContent(1,1), 430, 680);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:  GameHandler.move(-1); break;
                    case RIGHT: GameHandler.move(1); break;
                    case SPACE: GameHandler.drop(1); break;
                    case UP: GameHandler.rotate(); break;
                }

                drawNew();
            }
        });

        stage.setTitle("Tetris!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public void launch(){
        Application.launch();
    }
}