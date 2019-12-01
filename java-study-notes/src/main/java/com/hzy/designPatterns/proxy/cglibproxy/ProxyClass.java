package com.hzy.designPatterns.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * cglib 代理工厂类 通过 实现 拦截器 intercept 方法 实现调用 目标对象的方法
 * 需引入 cglib 相关 jar 包
 * getProxyInstance 方法 获取代理对象
 */
public class ProxyClass implements MethodInterceptor {

    Object target;

    public ProxyClass (Object target) {
        this.target = target;
    }

    //返回一个代理对象
    public Object getProxyInstance(){
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //传入父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //返回子类对象
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib proxy start");
        Object obj = method.invoke(target, objects);
        return obj;
    }
}
