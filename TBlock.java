package com.example.tetris;

public class TBlock extends Block{
    int state;
    TBlock(){
        currentCoords = new int[3][3];
        attemptCoords = new int[3][3];

        x_shift = 0;
        y_shift = 0;
        state = 0;

        for(int i = 0; i < currentCoords[0].length;i++){

            for(int j = 0; j < currentCoords.length;j++){

                currentCoords[i][j] = 0;
                attemptCoords[i][j] = 0;

            }
        }

        currentCoords[0][0] = 2;
        currentCoords[0][1] = 2;
        currentCoords[0][2] = 2;
        currentCoords[1][1] = 2;
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
            attemptCoords[1][0] = 2;
            attemptCoords[1][1] = 2;
            attemptCoords[1][2] = 2;
            attemptCoords[2][1] = 2;

        } else if (state == 1) {
            attemptCoords[0][1] = 2;
            attemptCoords[1][1] = 2;
            attemptCoords[1][2] = 2;
            attemptCoords[2][1] = 2;

        } else if (state == 2) {
            attemptCoords[1][0] = 2;
            attemptCoords[1][1] = 2;
            attemptCoords[1][2] = 2;
            attemptCoords[0][1] = 2;

        }else if(state == 3){
            attemptCoords[1][0] = 2;
            attemptCoords[1][1] = 2;
            attemptCoords[0][1] = 2;
            attemptCoords[2][1] = 2;
        }

    if(!attemptRotation()){
            state += (dir *-1);
        }
    }


}
