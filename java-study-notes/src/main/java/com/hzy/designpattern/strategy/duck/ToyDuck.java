package com.hzy.designpattern.strategy.duck;

import com.hzy.designpatterns.strategy.fly.FlyNot;
import com.hzy.designpatterns.strategy.talk.TalkNot;

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
