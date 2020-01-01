package com.hzy.designpatterns.adaptor.classadaptor;

/**
 * 类适配器 客户端
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("类适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdaptor());
    }

}
