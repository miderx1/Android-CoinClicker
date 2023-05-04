package com.example.coinclicker;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();

        SharedPreferences prefs = getSharedPreferences("my_prefs",MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean("is_first_run",true);
        if(isFirstRun){
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("is_first_run",false);
            editor.apply();
        }
    }

}
