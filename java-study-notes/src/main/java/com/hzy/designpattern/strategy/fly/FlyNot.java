package com.hzy.designpattern.strategy.fly;

public class FlyNot implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("无法飞行");
    }
}
