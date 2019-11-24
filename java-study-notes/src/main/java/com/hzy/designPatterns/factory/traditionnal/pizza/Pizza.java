package com.hzy.designPatterns.factory.traditionnal.pizza;

public abstract class Pizza {

    private String name;

    private String type;

    public abstract void prepare(String orderType);

}
