package com.company.shop;

import com.company.product.Product;

import java.util.List;

public class Shop {

    private final List<Product> amountBalls;

    public Shop(List<Product> amountBalls) {
        this.amountBalls = amountBalls;
    }

    public synchronized void put(Product product) throws InterruptedException {
        while (amountBalls.size() >= 5) {
            System.out.println("Жду пока купят..");
            this.wait();
        }
        amountBalls.add(product);
        System.out.println("Производитель произвел 1 мячик");
        System.out.println("На складе теперь мячиков:" + amountBalls.size());
        this.notifyAll();
    }


    public synchronized void get(Product product) throws InterruptedException {
        while (amountBalls.size() < 1) {
            System.out.println("Жду пока произведут..");
            this.wait();
        }
        amountBalls.remove(product);
        System.out.println("Потребитель купил 1 мячик");
        System.out.println("На складе осталось мячиков:" + amountBalls.size());
        this.notifyAll();

    }

}
