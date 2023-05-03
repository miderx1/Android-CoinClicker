package com.example.coinclicker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton obj1;
    private int obj1_amt;

    private ImageButton obj2;
    private int obj2_amt;

    private ImageButton mult1;
    private int mult1_amt;

    private ImageButton click1;
    private int click1_amt;


    private TextView coinView;

    DecimalFormat df = new DecimalFormat("#");

    Coin coin = Coin.getInstance();

    private float multiplier = coin.getMultiplier();
    private float coins = coin.getCoins();
    private int click_multiplier = coin.getClick_multiplier();



    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        click1 = view.findViewById(R.id.click1);
        click1.setOnClickListener(this);

        mult1 = view.findViewById(R.id.mult1);
        mult1.setOnClickListener(this);

        obj1 = view.findViewById(R.id.obj1);
        obj1.setOnClickListener(this);

        obj2 = view.findViewById(R.id.obj2);
        obj2.setOnClickListener(this);


        coinView = view.findViewById(R.id.coinView);
        coinView.setText(String.valueOf((df.format(coins))));



        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.click1:
                if (coins >= 30)
                {
                    click_multiplier += 1;
                    coins -= 30;
                    coin.setCoins(coins);
                    coin.setClick_multiplier(click_multiplier);
                }
                break;

            case R.id.mult1:
                if (coins >= 30)
                {
                    multiplier += 0.2;
                    coins -= 30;
                    coin.setCoins(coins);
                    coin.setMultiplier(multiplier);
                }

                break;
            case R.id.obj1:
                if (coins >= 100)
                {
                    multiplier += 2;
                    coins -= 100;
                    coin.setCoins(coins);
                    coin.setMultiplier(multiplier);
                }

                break;
            case R.id.obj2:
                if (coins >= 200)
                {
                    multiplier += 5;
                    coins -= 200;
                    coin.setCoins(coins);
                    coin.setMultiplier(multiplier);


                }
                break;


        }

    }
}