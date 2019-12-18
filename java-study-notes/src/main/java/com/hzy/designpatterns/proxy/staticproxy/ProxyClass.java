package com.hzy.designpatterns.proxy.staticproxy;

public class ProxyClass implements CommonInterface {

    private CommonInterface targetClass;

    public ProxyClass (CommonInterface commonInterface) {
        this.targetClass = commonInterface;
    }

    @Override
    public void targetMethod() {
        System.out.println("into proxyClass");
        targetClass.targetMethod();
        System.out.println("out proxyClass");
    }
}
