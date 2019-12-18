package com.hzy.designpatterns.factory.traditionnal.pizza;

public class PizzaPig extends Pizza {
    public void prepare(String orderType) {
        System.out.println("prepare PizzaPig");
    }
}
