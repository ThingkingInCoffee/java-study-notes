package com.hzy.java8.localtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);
        LocalDate parse = LocalDate.parse(format, dateTimeFormatter);
        System.out.println(parse);
        LocalDateTime parse1 = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(parse1);
    }
}
