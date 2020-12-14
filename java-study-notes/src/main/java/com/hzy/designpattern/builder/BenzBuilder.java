package com.hzy.designpattern.builder;

import com.hzy.designpattern.builder.model.BenzModel;
import com.hzy.designpattern.builder.model.CarModel;

import java.util.List;

public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(List<String> sequence) {
        this.benz.setSequence(sequence);
    }
}