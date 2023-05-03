package com.example.coinclicker;

public class Coin {

    private static Coin instance;
    private float coins;
    private float multiplier;
    private int click_multiplier = 1;

    private Coin(){}

    public static synchronized Coin getInstance(){
        if (instance == null) {
            instance = new Coin();
        }

        return instance;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
        this.coins = coins;
    }

    public float getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(float multiplier) {
        this.multiplier = multiplier;
    }

    public int getClick_multiplier() {
        return click_multiplier;
    }

    public void setClick_multiplier(int click_multiplier) {
        this.click_multiplier = click_multiplier;
    }
}
