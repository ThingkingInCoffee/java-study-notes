package com.hzy.designpatterns.factory.traditionnal.pizza;

public class PizzaCheese extends Pizza {
    public void prepare(String orderType) {
        System.out.println("prepare PizzaCheese");
    }
}
