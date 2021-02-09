package com.hzy.base.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    }

}
