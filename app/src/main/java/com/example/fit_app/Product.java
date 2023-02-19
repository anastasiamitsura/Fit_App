package com.example.fit_app;

import android.graphics.drawable.Drawable;
import android.view.View;

public abstract class Product implements Item{
    private String name;
    private String money;
    private int pict;

    public Product(String name, String money, int pict) {
        this.name = name;
        this.money = money;
        this.pict = pict;
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

    public abstract void onClick(View rootView);
}
