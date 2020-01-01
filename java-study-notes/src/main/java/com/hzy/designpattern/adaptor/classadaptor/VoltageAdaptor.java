package com.hzy.designpattern.adaptor.classadaptor;

/**
 * 类适配器模式
 * 适配器类 继承 220 伏，实现 输出 5 伏
 */
public class VoltageAdaptor extends Voltage220V implements Voltage5V {

    public int outPut5V() {
        int v = outPut220();
        int dstV = v/44;
        return dstV;
    }
}
