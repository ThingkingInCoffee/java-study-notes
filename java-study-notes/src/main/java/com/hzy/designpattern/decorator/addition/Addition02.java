package com.hzy.designpattern.decorator.addition;

import com.hzy.designpattern.decorator.Drink;

public class Addition02 extends AdditionAbs {
    public Addition02(Drink drink) {
        super(drink);
        setDesc("调味品0222222222222");
        setPrice(0.5f);
    }
}
