package com.hzy.designPatterns.strategy.duck;

import com.hzy.designPatterns.strategy.fly.FlyGood;
import com.hzy.designPatterns.strategy.fly.FlyNot;
import com.hzy.designPatterns.strategy.talk.TalkGaga;
import com.hzy.designPatterns.strategy.talk.TalkNot;

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
