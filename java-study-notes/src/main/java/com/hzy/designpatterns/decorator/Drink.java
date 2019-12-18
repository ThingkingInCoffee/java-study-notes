package com.hzy.designpatterns.decorator;

/**
 * 饮品类抽象类，用于继承、扩展
 */
public abstract class Drink {

    public String desc;
    private float price = 0.0f;


    public abstract Float cost();

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
