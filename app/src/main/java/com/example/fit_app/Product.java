package com.example.fit_app;

import android.graphics.Color;
import android.view.View;

public abstract class Product implements Item{
    private String name;
    private String money;
    private int pict;
    private int color;

    public Product(String name, String money, int pict, int color) {
        this.name = name;
        this.money = money;
        this.pict = pict;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getMoney() {
        return money;
    }

    public int getPict() {
        return pict;
    }
    public int getColor() {
        return color;
    }

    public abstract void onClick(View rootView);
}
