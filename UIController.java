package com.example.tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UIController extends Application{

    private Parent createContent() {
        Rectangle box = new Rectangle(100, 50, Color.BLUE);

        transform(box);

        return new Pane(box);
    }

    private void transform(Rectangle box) {
        // we will apply transformations here
        box.setTranslateX(100);
        box.setTranslateY(200);
    }

    @Override
    public void start(Stage stage) throws Exception {


        VBox main = new VBox();
        Scene scene = new Scene(createContent(), 550, 900);

        stage.setTitle("Tetris!");
        stage.setScene(scene);
        stage.show();

    }

    public void launch(){
        Application.launch();
    }
}