package com.hzy.designpattern.strategy.duck;

import com.hzy.designpatterns.strategy.fly.FlyStrategy;
import com.hzy.designpatterns.strategy.talk.TalkStrategy;

public abstract class Duck {

    public Duck () {}

    FlyStrategy flyStrategy;

    TalkStrategy talkStrategy;

    public abstract void show();

    public void fly () {
        if (flyStrategy != null) {
            flyStrategy.fly();
        }
    }

    public void talk () {
        if (talkStrategy != null) {
            talkStrategy.talk();
        }
    }

}
