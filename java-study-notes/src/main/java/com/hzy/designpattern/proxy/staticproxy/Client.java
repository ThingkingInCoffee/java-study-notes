package com.hzy.designpattern.proxy.staticproxy;

public class Client {

    public static void main(String[] args) {
        TargetClass target = new TargetClass();
        ProxyClass proxy = new ProxyClass(target);
        proxy.targetMethod();
    }


}
