package com.hzy.designpattern.strategy.duck;

import com.hzy.designpattern.strategy.fly.FlyNot;
import com.hzy.designpattern.strategy.talk.TalkNot;

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
