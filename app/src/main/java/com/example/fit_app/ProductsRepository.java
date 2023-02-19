package com.example.fit_app;

import android.graphics.Color;

import java.util.Arrays;

public class ProductsRepository {
    private static Item[] products = new Item[0];

    public void addProduct(String name, String money, int pick, int color) {
        Product newProduct;
        newProduct = new ProductsClickView(name, money, pick, color);
        addItem(newProduct);
    }

    private void addItem(Item newElement) {
        Item[] newProducts =  Arrays.copyOf(products, products.length + 1);
        newProducts[newProducts.length - 1] = newElement;
        products = newProducts;
    }

    public Item[] getContacts() {
        return products;
    }
}
