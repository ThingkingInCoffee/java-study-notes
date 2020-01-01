package com.hzy.designpatterns.strategy.fly;

public class FlyBad implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("不擅长飞行");
    }
}
