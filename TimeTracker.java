package com.example.tetris;

import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public  class TimeTracker {

    public void startTimer(){
    Timer t = new Timer();
    TimerTask tt = new TimerTask() {
        @Override
        public void run() {
        };
    };
    t.schedule(tt, new Date(),1000);
    }

}
