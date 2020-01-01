package com.hzy.designpattern.strategy.fly;

public class FlyGood implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("擅长飞行");
    }
}
