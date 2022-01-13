package com.example.tetris;

import javafx.scene.paint.Color;

public class ZBlock extends Block {
    int zeros;
    int twos;
    ZBlock(){
        y_shift = -1;
        x_shift = 4;
        color = Color.GREEN;
        zeros = 0;
        twos = 2;
        currentCoords[1][zeros] = 3;
        currentCoords[1][1] = 3;
        currentCoords[2][1] = 3;
        currentCoords[2][twos] = 3;
        identifier = 3;
    }

    @Override
    public void rotate(int dir){

        state+=dir;
        if(state == 2){
            state = 0;
        }else if(state == -1){
            state = 1;
        }
        new_stateClear(attemptCoords);
        if (state == 0) {
            attemptCoords[0][zeros] = 3;
            attemptCoords[1][zeros] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[2][1] = 3;

        } else if (state == 1) {
            attemptCoords[1][twos] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[2][1] = 3;
            attemptCoords[2][zeros] = 3;
        }
        if(!attemptRotation()){
            state += (dir *-1);
        }
    }

}
