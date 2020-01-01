package com.hzy.designpattern.adaptor.interfaceadaptor;

public class Client {

    public static void main(String[] args) {
        AbsAdaptor absAdaptor = new AbsAdaptor(){
            public void m1() {
                System.out.println("使用 m1 方法");
            }
        };

        absAdaptor.m1();
    }

}
