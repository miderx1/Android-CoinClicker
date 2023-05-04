package com.example.coinclicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coinclicker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase dadosUsuario;

    ActivityMainBinding binding;
    private SharedPreferences mPrefs;

    private Item click;
    private Item poço;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        criarDadosUsuario();

        mPrefs = getSharedPreferences("my_prefs", MODE_PRIVATE);

        boolean isFirtRun = mPrefs.getBoolean("is_first_run",true);
        if(isFirtRun){

            executeCommand();

            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putBoolean("is_first_run",false);
            editor.apply();

        }

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.shop:
                    replaceFragment(new ShopFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new SettingsFragment());
                    break;
            }


            return true;
        });


    }

    public void criarDadosUsuario(){
        try {
            dadosUsuario = openOrCreateDatabase("dados",MODE_PRIVATE, null);
            dadosUsuario.execSQL("CREATE TABLE IF NOT EXISTS Coin(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT" +
                     ", coins INTEGER " +
                     ", multiplier FLOAT" +
                     ", click_multiplier INTEGER )");

            dadosUsuario.execSQL("CREATE TABLE IF NOT EXISTS Item("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", price INTEGER "+
                    ", multiplier FLOAT" +
                    ", type INTEGER"+
                    ", amount INTEGER)");

            dadosUsuario.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void executeCommand(){
        click = new Item(30,0.2f,1,0);
        poço = new Item(200,2,1,0);

    }

    public Item getClick(){
        return click;
    }

    public Item getPoço(){
        return poço;
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }











}
