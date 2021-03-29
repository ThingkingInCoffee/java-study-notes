package com.hzy.java8.localtime;

import java.time.Clock;
import java.time.ZoneId;

public class ClockTest {

    public static void main(String[] args) {
        // clock 基础
        clockBase();
    }


    /**
     * clock 基础
     */
    public static void clockBase(){
        System.out.println(System.currentTimeMillis());
        Clock clock = Clock.system(ZoneId.systemDefault());
        System.out.println(clock.millis());
        Clock clock1 = Clock.systemUTC();
        System.out.println(clock1.millis());
        Clock clock2 = Clock.systemDefaultZone();
        System.out.println(clock2.millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(clock.instant());
    }

}
