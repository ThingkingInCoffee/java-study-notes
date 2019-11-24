package com.hzy.designPatterns.factory.traditionnal.pizza;

public class PizzaCheese extends Pizza {
    public void prepare(String orderType) {
        System.out.println("prepare PizzaCheese");
    }
}
