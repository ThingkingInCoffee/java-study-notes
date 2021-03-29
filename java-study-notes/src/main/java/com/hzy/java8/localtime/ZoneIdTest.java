package com.hzy.java8.localtime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdTest {

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("America/New_York");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时区的当前时间为：" + now);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now, zoneId);
        System.out.println("指定美国时区的当前zoned格式时间为：" + zonedDateTime);
        Instant instant = zonedDateTime.toInstant();
        System.out.println(instant);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("指定美国时区的当前时间为：" + localDateTime1);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        System.out.println("转换localDateTime：" + localDateTime);
    }

}
