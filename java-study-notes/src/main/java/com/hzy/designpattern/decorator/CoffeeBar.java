package com.hzy.designpatterns.decorator;

import com.hzy.designpatterns.decorator.addition.Addition01;
import com.hzy.designpatterns.decorator.addition.Addition02;
import com.hzy.designpatterns.decorator.coffees.Coffee01;

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
