package com.hzy.designpatterns.proxy.staticproxy;

public class TargetClass implements CommonInterface {
    @Override
    public void targetMethod() {
        System.out.println("this is target class method");
    }
}
