package com.hzy.designpatterns.proxy.cglibproxy;

public class TargetClass {

    public String doSomething() {
        System.out.println("run target method");
        return "return target method string";
    }


}
