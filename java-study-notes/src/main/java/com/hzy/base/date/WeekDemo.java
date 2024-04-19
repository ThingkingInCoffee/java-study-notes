package com.hzy.base.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class WeekDemo {

    public static void main(String[] args) {
        final DateTime parse = DateUtil.parse("2022-12-25");
        final DateTime dateTime = DateUtil.endOfDay(parse);
        System.out.println(DateUtil.formatDateTime(dateTime));
        final int weekOfYear = DateUtil.weekOfYear(parse);
        System.out.println(weekOfYear);
        DateTime startWeekDate = DateUtil.offsetWeek(DateUtil.parse("2022", "yyyy"), 51);
        System.out.println(DateUtil.formatDateTime(startWeekDate));
        DateTime begin = DateUtil.beginOfWeek(startWeekDate);
        System.out.println(DateUtil.formatDateTime(begin));
        DateTime endWeekDate = DateUtil.offsetWeek(DateUtil.parse("2023", "yyyy"), 5);
        System.out.println(DateUtil.formatDateTime(endWeekDate));
        DateTime end = DateUtil.endOfWeek(endWeekDate);
        System.out.println(DateUtil.formatDateTime(end));
        List<DateTime> dateTimes = DateUtil.rangeToList(begin, end, DateField.WEEK_OF_YEAR);
        final List<String> collect = dateTimes.stream().map(x -> DateUtil.formatDateTime(x)).collect(Collectors.toList());
        System.out.println(collect.stream().collect(Collectors.joining(",")));
        final DateTime parse1 = DateUtil.parse("2022-12", "yyyy-MM");
        final DateTime parse2 = DateUtil.parse("2023-03", "yyyy-MM");
        List<DateTime> dateTimes1 = DateUtil.rangeToList(parse1, parse2, DateField.DAY_OF_YEAR);
        final List<String> collect1 = dateTimes1.stream().map(x -> DateUtil.formatDateTime(x)).collect(Collectors.toList());
        System.out.println(collect1.stream().collect(Collectors.joining(",")));
        final int i = DateUtil.weekOfYear(DateUtil.parseDateTime("2023-01-02 00:00:00"));
        System.out.println(i);

        final DateTime end1 = DateUtil.endOfMonth(DateUtil.parseDate("2023-01-01"));
        System.out.println(DateUtil.formatDateTime(end1));

        final int week0 = DateUtil.weekOfYear(DateUtil.parseDateTime("2022-12-31 00:00:00"));
        System.out.println(week0);
        final int week = DateUtil.weekOfYear(DateUtil.parseDateTime("2023-01-01 00:00:00"));
        System.out.println(week);
        final int week1 = DateUtil.weekOfYear(DateUtil.parseDateTime("2023-01-02 00:00:00"));
        System.out.println(week1);
        final Date beginOfWeek = DateUtil.beginOfWeek(DateUtil.parseDateTime("2023-01-01 00:00:00"));
        System.out.println(beginOfWeek);
        final int week2 = DateUtil.weekOfYear(beginOfWeek);
        System.out.println(week2);
        final DateTime dateTime1 = DateUtil.offsetDay(beginOfWeek, -1);
        System.out.println(dateTime1);
        final int week3 = DateUtil.weekOfYear(dateTime1);
        System.out.println(week3);
        final DateTime dateTime2 = DateUtil.offsetWeek(beginOfWeek, 1);
        System.out.println(dateTime2);
        final int week4 = DateUtil.weekOfYear(dateTime2);
        System.out.println(week4);

        System.out.println(DateUtil.betweenYear(DateUtil.parseDate("2022-12-26"), DateUtil.parseDate("2023-01-01"), true));

        System.out.println("2023-01-01-weekOfYear" + DateUtil.weekOfYear(DateUtil.parseDate("2023-01-01")));
        System.out.println("2023-01-01-beginOfWeek" + DateUtil.formatDate(DateUtil.beginOfWeek(DateUtil.parseDate("2023-01-01"))));
        System.out.println("2022-12-26-weekOfYear" + DateUtil.weekOfYear(DateUtil.parseDate("2022-12-26")));
        System.out.println("2022-12-25-weekOfYear" + DateUtil.weekOfYear(DateUtil.parseDate("2022-12-25")));
        System.out.println(DateUtil.offsetWeek(DateUtil.beginOfYear(DateUtil.parse("2023", "yyyy")), 1));
        System.out.println(DateUtil.offsetWeek(DateUtil.beginOfYear(DateUtil.parse("2022", "yyyy")), 51));
        getWeek("2022", 51);
        getWeek("2022", 52);
        getWeek("2023", 1);
        getWeek("2023", 2);
        getWeek("2023", 51);
        getWeek("2023", 52);
        getWeek("2023", 53);
        getWeek("2024", 1);
        getWeek("2024", 2);

        getWeek2("2022", 51);
        getWeek2("2022", 52);
        getWeek2("2023", 1);
        getWeek2("2023", 2);
        getWeek2("2023", 51);
        getWeek2("2023", 52);
        getWeek2("2023", 53);
        getWeek2("2024", 1);
        getWeek2("2024", 2);
//        List<DateTime> dayTimeList = DateUtil.rangeToList(DateUtil.beginOfDay(new Date()), DateUtil.endOfDay(new Date()), DateField.SECOND);
//        List<String> dayTimeListStr = dayTimeList.stream().map(x -> DateUtil.formatDateTime(x)).collect(Collectors.toList());
//        System.out.println(dayTimeListStr.stream().collect(Collectors.joining(",")));
    }

    public static void getWeek(String year, int num) {
        System.out.println("参数:" + year + "-" + num + "周");
        final DateTime beginOfYear = DateUtil.beginOfYear(DateUtil.parse(year, "yyyy"));
        System.out.println("beginOfYear:" + DateUtil.formatDate(beginOfYear));
        final DateTime beginOfWeekYear = DateUtil.beginOfWeek(beginOfYear);
        System.out.println("beginOfWeekYear:" + DateUtil.formatDate(beginOfWeekYear));
        final DateTime offsetWeek = DateUtil.offsetWeek(beginOfYear, num);
        System.out.println("offsetWeek:" + DateUtil.formatDate(offsetWeek));
        final DateTime beginOfWeek = DateUtil.beginOfWeek(offsetWeek);
        System.out.println("beginOfWeek:" + DateUtil.formatDate(beginOfWeek));
    }

    public static void getWeek2(String year, int num) {
        System.out.println("参数:" + year + "-" + num + "周");
        DateTime beginOfYear = DateUtil.beginOfYear(DateUtil.parse(year, "yyyy"));
        System.out.println("beginOfYear:" + DateUtil.formatDate(beginOfYear));
        DateTime beginOfWeekYear = DateUtil.beginOfWeek(beginOfYear);
        System.out.println("beginOfWeekYear:" + DateUtil.formatDate(beginOfWeekYear));
        if (beginOfWeekYear.compareTo(beginOfYear) < 0) {
            beginOfWeekYear = DateUtil.offsetWeek(beginOfWeekYear, 1);
            System.out.println("beginOfFirstWeek:" + DateUtil.formatDate(beginOfWeekYear));
            DateTime beginOfFirstWeek0 = DateUtil.offsetWeek(beginOfWeekYear, 0);
            System.out.println("beginOfFirstWeek0:" + DateUtil.formatDate(beginOfFirstWeek0));
        }
        final DateTime offsetWeek = DateUtil.offsetWeek(beginOfWeekYear, num - 1);
        System.out.println("offsetWeek:" + DateUtil.formatDate(offsetWeek));
        final DateTime beginOfWeek = DateUtil.beginOfWeek(offsetWeek);
        System.out.println("beginOfWeek:" + DateUtil.formatDate(beginOfWeek));
        DateTime endOfWeek = DateUtil.offsetDay(beginOfWeek, 6);
        System.out.println("endOfWeek:" + DateUtil.formatDate(endOfWeek));
        endOfWeek = DateUtil.endOfWeek(beginOfWeek);
        System.out.println("endOfWeek:" + DateUtil.formatDate(endOfWeek));
    }


}
