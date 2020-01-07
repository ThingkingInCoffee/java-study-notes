package com.hzy.designpattern.strategy.duck;

import com.hzy.designpattern.strategy.fly.FlyBad;
import com.hzy.designpattern.strategy.talk.TalkGege;

public class LocalDuck extends Duck {

    public LocalDuck() {
        this.flyStrategy = new FlyBad();
        this.talkStrategy = new TalkGege();
    }

    @Override
    public void show() {
        System.out.println("本地鸭子");
    }
}
