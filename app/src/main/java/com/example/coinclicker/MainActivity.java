package com.example.coinclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView coinCounter;
    private ImageButton coin;

    int cont;
    float coin_multiplier;
    float click_multiplier = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coinCounter = findViewById(R.id.coinCounter);
        coin = findViewById(R.id.coin);


    }

    public void startService(View view){
        Intent intent = new Intent(this, CoinsPerSecond.class);
        intent.putExtra("multiplier", coin_multiplier);
        startService(intent);


    }

    public void stopService(View view){
        Intent it = new Intent("COINS_SECONDS");
        stopService(it);

    }


    public void basicClick(View v){
        cont += click_multiplier;
        coinCounter.setText(String.valueOf(cont));
    }
}
