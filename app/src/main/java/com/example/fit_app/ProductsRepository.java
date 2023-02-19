package com.example.fit_app;

import java.util.Arrays;

public class ProductsRepository {
    private static Item[] products = new Item[0];

    public void addProduct(String name, String money, int pick) {
        Product newProduct;
        newProduct = new ProductsClickView(name, money, pick);
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
