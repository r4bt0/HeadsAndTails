package me.r4bt.headsandtails;

import android.app.Application;

public class MyApplication extends Application {
    private int probabilityHeads = 50;

    public int getProbabilityHeads() {
        return probabilityHeads;
    }

    public void setProbabilityHeads(int probabilityHeads) {
        this.probabilityHeads = probabilityHeads;
    }
}
