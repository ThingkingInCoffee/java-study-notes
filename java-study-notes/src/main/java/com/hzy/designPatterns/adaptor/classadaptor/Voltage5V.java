package com.hzy.designPatterns.adaptor.classadaptor;

/**
 * 充电目标电压 5V
 * 因为适配器类 需要继承 220V源类，且单继承，因此目标类需要 为接口类 才能实现 “继承关系”
 */
public interface Voltage5V {

    int outPut5V();


}
