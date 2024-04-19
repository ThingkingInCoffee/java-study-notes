package com.hzy.base.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class WeekTest {

    public static void main(String[] args) {
//        DateTime begin = null, end = null;
//        String[] startSplit = "2019-01".split("-");
//        String[] endSplit = "2023-01".split("-");
//
//        DateTime startWeekDate = DateUtil.offsetWeek(DateUtil.parse(startSplit[0], "yyyy"), Integer.valueOf(startSplit[1]));
//        begin = DateUtil.beginOfWeek(startWeekDate);
//        DateTime endWeekDate = DateUtil.offsetWeek(DateUtil.parse(endSplit[0], "yyyy"), Integer.valueOf(endSplit[1]));
//        end = DateUtil.endOfWeek(endWeekDate);
//        List<DateTime> dateTimes = DateUtil.rangeToList(begin, end, DateField.WEEK_OF_YEAR);
//        for (DateTime dateTime : dateTimes) {
//            DateRangeDTO dateRangeDto = new DateRangeDTO();
//            dateRangeDto.setStartDateTime(DateUtil.beginOfWeek(dateTime));
//            dateRangeDto.setEndDateTime(DateUtil.endOfWeek(dateTime));
//            if (DateUtil.betweenYear(dateRangeDto.getStartDateTime(), dateRangeDto.getEndDateTime(), true) > 0) {
//                dateRangeDto.setAlignStr(DateUtil.format(dateTime, "yyyy") + "年第" + (DateUtil.weekOfYear(DateUtil.offsetDay(dateTime, -1))) + "周");
//            } else {
//                dateRangeDto.setAlignStr(DateUtil.format(dateTime, "yyyy") + "年第" + (DateUtil.weekOfYear(dateTime) - 1) + "周");
//            }
//            System.out.println(dateRangeDto.toString());
//        }


        String format = null;
        String[] startSplit = "2019-01".split("-");
        String[] endSplit = "2023-01".split("-");
        DateTime startWeekDate = DateUtil.offsetWeek(DateUtil.parse(startSplit[0], "yyyy"), Integer.valueOf(startSplit[1]));
        DateTime begin = DateUtil.beginOfWeek(startWeekDate);
        DateTime endWeekDate = DateUtil.offsetWeek(DateUtil.parse(endSplit[0], "yyyy"), Integer.valueOf(endSplit[1]));
        DateTime end = DateUtil.endOfWeek(endWeekDate);
        List<DateTime> dateTimes = DateUtil.rangeToList(begin, end, DateField.WEEK_OF_YEAR);
        List<DateRangeDTO> list = new ArrayList<>();
        String year;
        int weekNum;
        String formatFinal = format != null ? format : "%s年-%s周";
        for (DateTime dateTime : dateTimes) {
            DateRangeDTO dateRangeDto = new DateRangeDTO();
            dateRangeDto.setStartDateTime(DateUtil.beginOfWeek(dateTime));
            dateRangeDto.setEndDateTime(DateUtil.endOfWeek(dateTime));
            year = DateUtil.format(dateTime, "yyyy");
            if (DateUtil.betweenYear(dateRangeDto.getStartDateTime(), dateRangeDto.getEndDateTime(), true) > 0) {
                weekNum = DateUtil.weekOfYear(DateUtil.offsetDay(dateTime, -1));
            } else {
                weekNum = DateUtil.weekOfYear(dateTime) - 1;
            }
            dateRangeDto.setWeekFormat(String.format(formatFinal, year, weekNum));
//            list.add(dateRangeDto);
            System.out.println(dateRangeDto);
        }
    }

}
