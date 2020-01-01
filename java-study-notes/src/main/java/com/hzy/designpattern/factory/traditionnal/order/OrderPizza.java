package com.hzy.designpattern.factory.traditionnal.order;

import com.hzy.designpatterns.factory.traditionnal.pizza.Pizza;
import com.hzy.designpatterns.factory.traditionnal.pizza.PizzaCheese;
import com.hzy.designpatterns.factory.traditionnal.pizza.PizzaPig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 披萨订单系统
 * 传统模式 破坏了 ocp 原则 即 对扩展开放，对修改关闭
 * 当存在多个订单系统时，若调整一次披萨类型，则 每一个 订单系统都要通过需改 if else 来适配
 */
public class OrderPizza {

    public OrderPizza () {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if (orderType .equals("pig")) {
                pizza = new PizzaPig();
            }else if (orderType.equals("ch")){
                pizza = new PizzaCheese();
            } else {
                break;
            }
            pizza.prepare(orderType);
        } while (true);
    }




    private String getType(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("please input type:");
            String s = in.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
