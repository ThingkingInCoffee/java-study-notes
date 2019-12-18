package com.hzy.designpatterns.strategy.talk;

public class TalkNot implements TalkStrategy {
    @Override
    public void talk() {
        System.out.println("不会叫");
    }
}
