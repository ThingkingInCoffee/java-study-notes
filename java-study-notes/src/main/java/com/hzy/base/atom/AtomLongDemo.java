package com.hzy.base.atom;

import sun.rmi.runtime.Log;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hzy
 * @description: AtomLongDemo.java
 * @date 2022/3/12 12:02
 */
public class AtomLongDemo {

    public static void main(String[] args) {
        AtomicLong al = new AtomicLong(0);
        al.getAndIncrement();
        al.incrementAndGet();

        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
    }

}
