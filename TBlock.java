package com.example.tetris;

import javafx.scene.paint.Color;

public class TBlock extends Block{
    TBlock(){
        color = Color.MEDIUMPURPLE;
        currentCoords[0][0] = 3;
        currentCoords[0][1] = 3;
        currentCoords[0][2] = 3;
        currentCoords[1][1] = 3;
        x_shift = 4;
        identifier = 4;
    }

@Override
    public void rotate(int dir) {
        state+=dir;
        if(state == 4){
            state = 0;
        }else if(state == -1){
            state = 1;
        }
        new_stateClear(attemptCoords);
        if (state == 0) {
            attemptCoords[1][0] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[1][2] = 3;
            attemptCoords[2][1] = 3;

        } else if (state == 1) {
            attemptCoords[0][1] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[1][2] = 3;
            attemptCoords[2][1] = 3;

        } else if (state == 2) {
            attemptCoords[1][0] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[1][2] = 3;
            attemptCoords[0][1] = 3;

        }else if(state == 3){
            attemptCoords[1][0] = 3;
            attemptCoords[1][1] = 3;
            attemptCoords[0][1] = 3;
            attemptCoords[2][1] = 3;
        }

    if(!attemptRotation()){
            state += (dir *-1);
        }
    }


}
