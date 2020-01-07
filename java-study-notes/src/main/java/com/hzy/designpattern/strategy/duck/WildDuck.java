package com.hzy.designpattern.strategy.duck;

import com.hzy.designpattern.strategy.fly.FlyGood;
import com.hzy.designpattern.strategy.talk.TalkGaga;

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
