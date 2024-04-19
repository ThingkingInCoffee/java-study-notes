package com.hzy.base.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateFormatDemo {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-M");
        System.out.println(format.format(date));
        System.out.println(format1.format(date));
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 9);
        Date time = c.getTime();
        System.out.println(format.format(time));
        System.out.println(format1.format(time));

        final DateTime parse = DateUtil.parse("2024-02-29 00:00:00");
        final DateTime dateTime = DateUtil.offsetMonth(parse, 12);
        System.out.println(DateUtil.format(dateTime, "yyyy-MM-dd HH:mm:ss"));

        final DateTime parse1 = DateUtil.parse("2023-03-01 00:00:00");
        final DateTime dateTime1 = DateUtil.offsetMonth(parse1, 12);
        System.out.println(DateUtil.format(dateTime1, "yyyy-MM-dd HH:mm:ss"));

        final List<DateTime> timeList = DateUtil.rangeToList(DateUtil.parse("2023-03-01 00:00:00"), DateUtil.parse("2023-03-02"), DateField.DAY_OF_YEAR);
        System.out.println(timeList);
        final List<DateTime> timeList2 = DateUtil.rangeToList(DateUtil.parse("2023-03-01 00:00:00"), DateUtil.parse("2023-03-01 00:00:00"), DateField.DAY_OF_YEAR);
        System.out.println(JSON.toJSONString(timeList2, SerializerFeature.WriteDateUseDateFormat));
        System.out.println(JSONObject.toJSONString(timeList2, SerializerFeature.WriteDateUseDateFormat));

        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        a.addAll(b);
        System.out.println(a.size());

        System.out.println(DateUtil.parse("2023-03-01 01:01:10", "yyyy-MM-dd"));

        final long l = DateUtil.betweenDay(DateUtil.parseDate("1970-01-01"), DateUtil.parseDate("2019-01-22"), true);
        System.out.println(l);
        Date today = new Date();
        System.out.println(DateUtil.offsetMonth(today, -12 * 5));
        System.out.println(DateUtil.betweenYear(DateUtil.offsetMonth(today, -12 * 5), DateUtil.offsetSecond(today,1), false));
        DateTime firstDay = DateUtil.parseDate("1970-01-01");
        final long l1 = DateUtil.betweenYear(DateUtil.offsetDay(firstDay, 14616), today, true);
        System.out.println(l1);

        DateTime firstDay1970 = DateUtil.parseDate("2024-01-24");
        long betweenDay = DateUtil.betweenDay(firstDay1970, new Date(), true) + 1;
        System.out.println(betweenDay);
        System.out.println(DateUtil.formatDate(DateUtil.offsetDay(firstDay1970, 1)));

        final DateTime parse2 = DateUtil.parse("2023-03-01 01:01:10", "yyyy-MM-dd");
        final DateTime parse3 = DateUtil.parse("2023-04-11 01:01:10", "yyyy-MM-dd");
        final List<DateTime> timeList1 = DateUtil.rangeToList(parse2, parse3, DateField.MONTH);
        System.out.println(timeList1);

        System.out.println(Validator.isCreditCode("91510100MA6BKY6U36"));

    }


}
