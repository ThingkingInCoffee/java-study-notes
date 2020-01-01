package com.hzy.designpattern.adaptor.objectadaptor;

/**
 * 充电的手机   充电方法
 */
public class Phone {

    void charging(Voltage5V voltage5V){
        if (voltage5V.outPut5V() == 5) {
            System.out.println("可以充电了");
        } else {
            System.out.println("电压不符合");
        }
    }

}
