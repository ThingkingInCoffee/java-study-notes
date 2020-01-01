package com.hzy.designpattern.adaptor.objectadaptor;

/**
 * 对象适配器 客户端
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("对象适配器模式");
        Phone phone = new Phone();
        phone.charging(new VoltageAdaptor(new Voltage220V()));
    }

}
