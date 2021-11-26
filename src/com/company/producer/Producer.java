package com.company.producer;

import com.company.product.Product;
import com.company.shop.Shop;

import java.util.ArrayList;

public class Producer implements Runnable{
    Shop shop;
    Product product;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                shop.put(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
