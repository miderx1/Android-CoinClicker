package com.example.coinclicker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CoinsPerSecond extends Service {
    public CoinsPerSecond() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}