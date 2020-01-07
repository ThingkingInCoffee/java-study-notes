package com.hzy.designpattern.strategy;

import com.hzy.designpattern.strategy.duck.WildDuck;

public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.show();
        wildDuck.fly();
        wildDuck.talk();
    }

}
