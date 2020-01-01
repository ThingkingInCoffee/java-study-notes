package com.hzy.designpattern.proxy.dynamicproxy;


/**
 *
 */
public class Client {

    public static void main(String[] args) {
        CommonInterface targetObj = new TargetClass();

        CommonInterface commonInterface =
                (CommonInterface)new DynamicProxyCLass(targetObj).getProxyInstance();

        System.out.println("CommonInterface is "+commonInterface );

        //通过代理对象调用目标方法
        commonInterface.targetMethod();
    }

}
