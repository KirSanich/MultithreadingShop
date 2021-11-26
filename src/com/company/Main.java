package com.company;

import com.company.consumer.Consumer;
import com.company.producer.Producer;
import com.company.shop.Shop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Shop shop = new Shop(new ArrayList<>());
        Thread thread = new Thread(new Consumer(shop));
        thread.start();
        Thread thread1 = new Thread(new Producer(shop));
        thread1.start();

    }
}
