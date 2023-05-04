package com.example.coinclicker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class PerSecond extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Coin coin = Coin.getInstance();

        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            public void run(){
            coin.incrementCoin(coin.getMultiplier());

            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Não é necessário para um serviço simples
        return null;
    }
}