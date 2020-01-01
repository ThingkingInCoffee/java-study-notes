package com.hzy.designpattern.strategy.talk;

public class TalkGaga implements TalkStrategy {
    @Override
    public void talk() {
        System.out.println("嘎嘎嘎叫");
    }
}
