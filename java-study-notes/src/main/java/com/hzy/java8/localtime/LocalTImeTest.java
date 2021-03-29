package com.hzy.java8.localtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTImeTest {

    public static void main(String[] args) {
        // 获取当前时间，不含日期
        getNowTime();
        // 时间计算、增减、替换
        calculateTime();
    }

    /**
     * 获取当前时间，不含日期
     */
    public static void getNowTime() {
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间,不含有日期:" + time); // 15:47:26.282
        System.out.println(time.withHour(1)); // 当前时间替换指定小时 01:47:26.282
    }

    /**
     * 时间计算、增减、替换
     */
    public static void calculateTime() {
        LocalTime time = LocalTime.now();
        System.out.println("获取当前的时间:" + time); // 15:53:04.916
        LocalTime newPlusTime = time.plusHours(3);
        System.out.println("3 小时后的时间为:" + newPlusTime); // 18:53:04.916
        LocalTime newMinusTime = time.minusMinutes(55);
        System.out.println("55 分钟之前的时间为:" + newMinusTime); // 14:58:04.916
        LocalDateTime anyDateTime = time.atDate(LocalDate.of(2019, 4, 17));
        System.out.println("指定日期的日期时间为:" + anyDateTime); // 2019-04-17T14:58:04.916
    }

}
