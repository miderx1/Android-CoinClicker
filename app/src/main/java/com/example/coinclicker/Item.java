package com.example.coinclicker;

public class Item {

    private int price;
    private float multiplier;
    private int type;
    private int amount;
    //Tipo 1 = Ferramenta
    //Tipo 2 = Melhoria

    public Item(int price, float multiplier, int type, int amount){
        this.price = price;
        this.multiplier = multiplier;
        this.type = type;
        this.amount = amount;
    }

    public void Buy(){

        Coin coin = Coin.getInstance();

        if (this.type == 1){
            coin.incrementCoin(multiplier);
        }

        this.price = this.price + (int)(50/100*this.price);
        this.amount += 1;

    }

}
