package com.hzy.designpattern.decorator.coffees;

import com.hzy.designpattern.decorator.Drink;

/**
 * 咖啡抽象类   饮品类的一种
 */
public class CoffeeAbs extends Drink {

    @Override
    public Float cost() {
        return super.getPrice();
    }
}
