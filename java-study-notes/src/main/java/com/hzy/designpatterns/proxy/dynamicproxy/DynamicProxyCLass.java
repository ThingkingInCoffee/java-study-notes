package com.hzy.designpatterns.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyCLass {

    //需要维护一个目标对象
    private Object target;

    //通过构造函数传递目标对象
    public DynamicProxyCLass (Object target) {
        this.target = target;
    }

    //给目标对象生成一个代理对象
    public Object getProxyInstance () {
        /*
            public static Object newProxyInstance(ClassLoader loader,
                Class<?>[] interfaces,
                InvocationHandler h)
            1：ClassLoader loader 指定当前目标对象使用的类的加载器，获取加载器的方法固定
            2：Class<?>[] interfaces 目标对象实现的接口类型，使用泛型方法确认类型
            3：InvocationHandler h：事件处理，执行目标对象的方法时，会把当前执行的
                                    目标对象方法作为参数传入

         */

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK start run");
                        Object res = method.invoke(target,args);
                        return res;
                    }
                }
        );
    }

}
