package com.hzy.designPatterns.strategy.duck;

import com.hzy.designPatterns.strategy.fly.FlyBad;
import com.hzy.designPatterns.strategy.fly.FlyNot;
import com.hzy.designPatterns.strategy.talk.TalkGege;
import com.hzy.designPatterns.strategy.talk.TalkNot;

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
