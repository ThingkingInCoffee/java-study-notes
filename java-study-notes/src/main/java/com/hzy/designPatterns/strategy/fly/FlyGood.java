package com.hzy.designPatterns.strategy.fly;

public class FlyGood implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("擅长飞行");
    }
}
