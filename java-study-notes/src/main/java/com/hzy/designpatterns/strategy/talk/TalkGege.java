package com.hzy.designpatterns.strategy.talk;

public class TalkGege implements TalkStrategy {
    @Override
    public void talk() {
        System.out.println("咯咯叫");
    }
}
