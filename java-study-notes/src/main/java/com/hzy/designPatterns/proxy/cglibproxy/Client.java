package com.hzy.designPatterns.proxy.cglibproxy;

public class Client {

    public static void main(String[] args) {
        TargetClass targetClass = new TargetClass();
        TargetClass proxyInstance = (TargetClass) new ProxyClass(targetClass).getProxyInstance();
        String res = proxyInstance.doSomething();
        System.out.println(res);
    }

}
