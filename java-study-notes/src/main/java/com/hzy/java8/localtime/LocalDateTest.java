package com.hzy.java8.localtime;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTest {

    public static void main(String[] args) {
        // 获取今天的日期 今天的日期:2021-01-12
        getToday();
        // 获取年、月、日信息
        getDateYMD();
        // 创建任意指定日期
        createAnyDate();
        // 检查两个日期相等
        checkDateEquals();
        // 检查生日
        checkBirthday();
        // 获取周期性日期
        getPeriodDate();
        // 检测日期前后大小
        checkBeforeOrAfter();
        // 校验是否闰年
        checkLeapYear();
        // 计算日期间隔
        calculateDaysBetweenTwoDates();
        // 时间格式化
        transferDate();
    }

    /**
     * 获取今天的日期 不含时间
     */
    public static void getToday() {
        // 获取今天的日期
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:" + today); // 今天的日期:2021-01-12
    }

    /**
     * // 获取年、月、日信息
     */
    public static void getDateYMD() {
        LocalDate today01 = LocalDate.now();
        int year = today01.getYear();
        int month = today01.getMonthValue();
        int day = today01.getDayOfMonth();

        System.out.println("year:" + year);
        System.out.println("month:" + month);
        System.out.println("day:" + day);
    }

    /**
     * 创建任意指定日期
     */
    public static void createAnyDate() {
        LocalDate date = LocalDate.of(2018, 2, 6);
        System.out.println("自定义日期:" + date);
    }

    /**
     * 检查两个日期是否相等
     */
    public static void checkDateEquals() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018, 2, 5);
        if (date1.equals(date2)) {
            System.out.println("时间相等");
        } else {
            System.out.println("时间不等");
        }
    }

    /**
     * 检查生日
     * MonthDay.of(LocalDate生日.getMonth(),LocalDate生日.getDayOfMonth());
     * MonthDay.from(LocalDate检查日期)
     * 两个 monthday 对比
     */
    public static void checkBirthday() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2018, 2, 6);
        MonthDay birthday = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(date1);
        if (currentMonthDay.equals(birthday)) {
            System.out.println("是你的生日");
        } else {
            System.out.println("你的生日还没有到");
        }
    }

    /**
     * 获取周期性的日期
     * 一周后
     * 一月之后
     * 一年之后
     */
    public static void getPeriodDate() {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期为:" + today);
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("一周后的日期为:" + nextWeek);
        LocalDate nextMonth = today.plus(2, ChronoUnit.MONTHS);
        System.out.println("一月后的日期为:" + nextMonth);
        LocalDate nextYear = today.plus(-11, ChronoUnit.YEARS);
        System.out.println("十一年后的日期为:" + nextYear);
    }

    /**
     * 检查日期前后比较
     */
    public static void checkBeforeOrAfter() {
        LocalDate now = LocalDate.now();
        LocalDate afterDate = LocalDate.of(2022, 10, 23);
        LocalDate beforeDate = LocalDate.of(2012, 10, 23);
        System.out.println("当前早于未来：" + now.isBefore(afterDate));
        System.out.println("当前晚于过去：" + now.isAfter(beforeDate));
    }

    /**
     * 检测是否闰年
     */
    public static void checkLeapYear() {
        LocalDate now = LocalDate.now();
        boolean check = now.isLeapYear();
        System.out.println("当前是闰年：" + check);
    }

    /**
     * 计算两个日期之间的天数
     */
    public static void calculateDaysBetweenTwoDates(){
        LocalDate now = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2020, 11, 14);
        Period between = Period.between(now, ofDate);
        System.out.println("天数间隔："+ between.getDays());
        System.out.println("月份间隔："+ between.getMonths());
        System.out.println(between.toTotalMonths());
    }

    /**
     * 时间格式化
     */
    public static void transferDate(){
        LocalDate now = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);
        // 不可转时间
//        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format1 = now.format(dateTimeFormatter1);
//        System.out.println(format1);
        LocalDate parse = LocalDate.parse(format, DateTimeFormatter.ISO_DATE);
        System.out.println(parse);
        LocalDate parse1 = LocalDate.parse(format, dateTimeFormatter);
        System.out.println(parse1);
    }

}
