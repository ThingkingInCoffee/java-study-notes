package com.hzy.designPatterns.strategy;

import com.hzy.designPatterns.strategy.duck.WildDuck;

public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.show();
        wildDuck.fly();
        wildDuck.talk();
    }

}
