package com.hzy.designpatterns.strategy.duck;

import com.hzy.designpatterns.strategy.fly.FlyGood;
import com.hzy.designpatterns.strategy.talk.TalkGaga;

public class WildDuck extends Duck {

    public WildDuck() {
        this.flyStrategy = new FlyGood();
        this.talkStrategy = new TalkGaga();
    }

    @Override
    public void show() {
        System.out.println("野生鸭子");
    }
}
