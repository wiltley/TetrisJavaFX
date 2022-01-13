package com.example.tetris;

import javafx.scene.paint.Color;

public class SqBlock extends Block {
    SqBlock(){
        color = Color.YELLOW;
        x_shift = 4;
        currentCoords[0][0] = 3;
        currentCoords[0][1] = 3;
        currentCoords[1][0] = 3;
        currentCoords[1][1] = 3;
        identifier = 5;
    }

    @Override
    public void rotate(int dir) {

    }
}
