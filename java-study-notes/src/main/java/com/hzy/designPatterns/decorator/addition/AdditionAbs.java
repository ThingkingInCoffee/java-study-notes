package com.hzy.designPatterns.decorator.addition;

import com.hzy.designPatterns.decorator.Drink;

public class AdditionAbs extends Drink {

    private Drink drink;

    public AdditionAbs(Drink drink) {
        this.drink = drink;
    }

    public Float cost() {
        return super.getPrice() + drink.cost();
    }

    public String getDesc() {
        return super.desc + "    " + super.getPrice() + "    " + drink.getDesc();
    }
}
