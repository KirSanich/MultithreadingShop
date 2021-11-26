package com.company.consumer;

import com.company.product.Product;
import com.company.shop.Shop;

import java.util.ArrayList;

public class Consumer implements Runnable {
    private Shop shop;
    private Product product;
    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                shop.get(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
