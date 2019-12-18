package com.hzy.designpatterns.strategy.duck;

import com.hzy.designpatterns.strategy.fly.FlyBad;
import com.hzy.designpatterns.strategy.talk.TalkGege;

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
