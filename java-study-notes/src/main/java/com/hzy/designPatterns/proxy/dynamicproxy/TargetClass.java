package com.hzy.designPatterns.proxy.dynamicproxy;


public class TargetClass implements CommonInterface {
    @Override
    public void targetMethod() {
        System.out.println("this is target class method doing");
    }
}