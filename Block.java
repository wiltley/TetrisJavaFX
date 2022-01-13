package com.example.tetris;

import javafx.scene.paint.Color;

public abstract class Block {

    int[][] currentCoords;
    int[][] attemptCoords;
    int[][] convertedAttemptCoords;
    int[][] currentConvertedCoords;
    int[][] previousConvertedCoords;
    public int x_shift;
    public int y_shift;
    public int max_x_shift;
    public int max_y_shift;
    public Color color;

    Block() {

        currentConvertedCoords = new int[4][];
        previousConvertedCoords = new int[4][];
        convertedAttemptCoords = new int[4][];
        for (int i = 0; i < currentConvertedCoords.length; i++) {
            currentConvertedCoords[i] = new int[]{0, 0};
            previousConvertedCoords[i] = new int[]{0, 0};
            convertedAttemptCoords[i] = new int[]{0, 0};
        }
    }

    public void translate(int[][] array, int[][] convertedArray) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    convertedArray[index][0] = i + y_shift + 1;
                    convertedArray[index][1] = j + x_shift + 1;
                    index += 1;
                }
            }
        }

    }

    public boolean attemptRotation() {
        translate(attemptCoords, convertedAttemptCoords);

        for (int i = 0; i < convertedAttemptCoords.length; i++) {
            System.out.println(i);
            if ((GameHandler.gameGrid[convertedAttemptCoords[i][0]][convertedAttemptCoords[i][1]] != 0) && (GameHandler.gameGrid[convertedAttemptCoords[i][0]][convertedAttemptCoords[i][1]] != 3)) {
                System.out.println("failed");
                return false;

            }

        }


        dupeArray(currentCoords, attemptCoords);
        dupeArray(previousConvertedCoords, currentConvertedCoords);
        update();
        return true;

    }

    public void clearPrevious() {
        for (int i = 0; i < previousConvertedCoords.length; i++) {
            GameHandler.gameGrid[previousConvertedCoords[i][0]][previousConvertedCoords[i][1]] = 0;
        }
    }

    public void update() {
        translate(currentCoords, currentConvertedCoords);
        clearPrevious();

        for (int i = 0; i < currentConvertedCoords.length; i++) {
            GameHandler.gameGrid[currentConvertedCoords[i][0]][currentConvertedCoords[i][1]] = 3;
        }
    }

    public void dupeArray(int[][] duped, int[][] todupe) {
        for (int i = 0; i < todupe.length; i++) {
            for (int j = 0; j < todupe[0].length; j++) {
                duped[i][j] = todupe[i][j];
                duped[i][j] = todupe[i][j];
            }
        }
    }

    public void new_stateClear(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    public void drop(int i) {
        // 0 means normal move down, 1 means full drop
        while(true) {
            if (checkBelow()) {
                y_shift = y_shift + 1;
                dupeArray(previousConvertedCoords, currentConvertedCoords);
                update();
                if(i == 0){break;}
            }else{break;}
        }
    }


    public boolean check(int dir){
        for(int i = 0; i < currentConvertedCoords.length; i++){
            if((GameHandler.gameGrid[currentConvertedCoords[i][0]][currentConvertedCoords[i][1]+ dir] != 0) && (GameHandler.gameGrid[currentConvertedCoords[i][0]][currentConvertedCoords[i][1]+ dir] != 3)){
                return false;
            }
        }
        return true;
    }

    public boolean checkBelow(){
            for(int i = 0; i < currentConvertedCoords.length;i ++){
                if((GameHandler.gameGrid[currentConvertedCoords[i][0]+1][currentConvertedCoords[i][1]] != 0 && GameHandler.gameGrid[currentConvertedCoords[i][0]+1][currentConvertedCoords[i][1]]!= 3)){
                    return false;
                }
            }

            return true;
    }

    // dir should be -1 or 1
    public void moveHorizontally(int dir){
        translate(currentCoords,currentConvertedCoords);
        if(check(dir)){
            x_shift = x_shift+ dir;
            dupeArray(previousConvertedCoords, currentConvertedCoords);
        }
        update();
    }

    public void changeToNonActive() {
        for (int i = 0; i < currentConvertedCoords.length; i++) {
            GameHandler.gameGrid[currentConvertedCoords[i][0]][currentConvertedCoords[i][1]] = 2;
        }
    }

    public abstract void rotate(int dir);

}
