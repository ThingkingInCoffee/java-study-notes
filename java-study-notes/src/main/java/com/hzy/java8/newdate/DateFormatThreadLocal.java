package com.hzy.java8.newdate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  通过 ThreadLocal c处理时间类的 并发问题
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd") );

    public static Date convert(String dateString) throws ParseException {
        return df.get().parse(dateString);
    }

}
