package com.hzy.designpattern.builder;

import com.hzy.designpattern.builder.model.BMWModel;
import com.hzy.designpattern.builder.model.CarModel;

import java.util.List;

public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();

    public CarModel getCarModel() {
        return this.bmw;
    }

    public void setSequence(List<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}