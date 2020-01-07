package com.hzy.designpattern.decorator;

import com.hzy.designpattern.decorator.addition.Addition01;
import com.hzy.designpattern.decorator.addition.Addition02;
import com.hzy.designpattern.decorator.coffees.Coffee01;

public class CoffeeBar {

    public static void main(String[] args) {
        Drink order = new Coffee01();

        System.out.println(order.cost());
        System.out.println(order.getDesc());

        order = new Addition01(order);
        System.out.println(order.cost());
        System.out.println(order.getDesc());

        order = new Addition02(order);
        System.out.println(order.cost());
        System.out.println(order.getDesc());


    }

}
