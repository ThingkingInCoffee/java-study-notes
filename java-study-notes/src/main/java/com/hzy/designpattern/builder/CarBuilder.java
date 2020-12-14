package com.hzy.designpattern.builder;

import com.hzy.designpattern.builder.model.CarModel;

import java.util.List;

public abstract class CarBuilder {
    //建造一个模型，你要给我一个顺序要求，就是组装顺序
    public abstract void setSequence(List<String> sequence);

    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}