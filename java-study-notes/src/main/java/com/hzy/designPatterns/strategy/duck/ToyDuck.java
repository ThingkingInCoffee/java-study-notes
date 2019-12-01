package com.hzy.designPatterns.strategy.duck;

import com.hzy.designPatterns.strategy.fly.FlyNot;
import com.hzy.designPatterns.strategy.fly.FlyStrategy;
import com.hzy.designPatterns.strategy.talk.TalkNot;

public class ToyDuck extends Duck {

    public ToyDuck () {
        this.flyStrategy = new FlyNot();
        this.talkStrategy = new TalkNot();
    }

    @Override
    public void show() {
        System.out.println("玩具鸭子");
    }
}
