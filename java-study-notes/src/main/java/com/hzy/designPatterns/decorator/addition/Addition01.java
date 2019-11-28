package com.hzy.designPatterns.decorator.addition;

import com.hzy.designPatterns.decorator.Drink;

public class Addition01 extends AdditionAbs {


    public Addition01(Drink drink) {
        super(drink);
        setDesc("调味011111111111");
        setPrice(1f);
    }
}
