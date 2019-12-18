package com.hzy.designpatterns.adaptor.objectadaptor;

/**
 * 对象适配器模式
 * 适配器类 聚合 220 伏，实现 输出 5 伏
 */
public class VoltageAdaptor implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdaptor(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    public int outPut5V() {
        int dstV = 0;
        if (voltage220V != null) {
            int v = voltage220V.outPut220();
            System.out.println("对象适配器模式");
            dstV = v/44;
        }
        return dstV;
    }
}
