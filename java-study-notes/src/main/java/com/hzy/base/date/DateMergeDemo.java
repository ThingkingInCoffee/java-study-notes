package com.hzy.base.date;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DateMergeDemo {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval l1 = new Interval(DateUtil.parse("2023-01-01 01:00:00"), DateUtil.parse("2023-01-01 08:00:00"));
        intervals.add(l1);
        Interval l2 = new Interval(DateUtil.parse("2023-01-01 02:00:00"), DateUtil.parse("2023-01-01 07:00:00"));
        intervals.add(l2);
        Interval l3 = new Interval(DateUtil.parse("2023-01-01 11:00:00"), DateUtil.parse("2023-01-01 12:00:00"));
        intervals.add(l3);
        Interval l4 = new Interval(DateUtil.parse("2023-01-01 09:00:00"), DateUtil.parse("2023-01-01 21:00:00"));
        intervals.add(l4);
        Interval l5 = new Interval(DateUtil.parse("2023-01-01 19:00:00"), DateUtil.parse("2023-01-01 22:00:00"));
        intervals.add(l5);

        List<Interval> merge = merge(intervals);
        String strings = merge.stream().map(x -> DateUtil.formatDateTime(x.getStart()) + "-" + DateUtil.formatDateTime(x.getEnd())).collect(Collectors.joining(","));
        System.out.println(strings);

        intervals = new ArrayList<>();
        Interval ll1 = new Interval(DateUtil.parse("2022-12-30 01:00:00"), DateUtil.parse("2023-01-01 08:00:00"));
        intervals.add(ll1);
        Interval ll2 = new Interval(DateUtil.parse("2023-01-01 02:00:00"), DateUtil.parse("2023-01-01 07:00:00"));
        intervals.add(ll2);
        Interval ll3 = new Interval(DateUtil.parse("2023-01-01 11:00:00"), DateUtil.parse("2023-01-01 12:00:00"));
        intervals.add(ll3);
        Interval ll4 = new Interval(DateUtil.parse("2023-01-01 09:00:00"), DateUtil.parse("2023-01-01 17:00:00"));
        intervals.add(ll4);
        Interval ll5 = new Interval(DateUtil.parse("2023-01-01 19:00:00"), DateUtil.parse("2023-01-01 22:00:00"));
        intervals.add(ll5);
        Date min = DateUtil.parse("2023-01-01 00:00:00");
        Date max = DateUtil.parse("2023-01-01 23:59:59");
        merge = mergeWithLimit(intervals, min, max);
        strings = merge.stream().map(x -> DateUtil.formatDateTime(x.getStart()) + "-" + DateUtil.formatDateTime(x.getEnd())).collect(Collectors.joining(","));
        System.out.println(strings);

        merge = listGapWithLimit(merge, min, max);
        strings = merge.stream().map(x -> DateUtil.formatDateTime(x.getStart()) + "-" + DateUtil.formatDateTime(x.getEnd())).collect(Collectors.joining(","));
        System.out.println(strings);

        min = DateUtil.parse("2023-01-01 00:20:09");
        max = DateUtil.parse("2023-01-01 04:59:19");
        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 04:58:19"), DateUtil.parse("2023-01-01 04:59:20"), DateUnit.MINUTE));
        merge = splitEveryHour(min, max);
        strings = merge.stream().map(x -> DateUtil.formatDateTime(x.getStart()) + "-" + DateUtil.formatDateTime(x.getEnd())).collect(Collectors.joining(","));
        System.out.println(strings);

        List<DateTime> range = DateUtil.rangeToList(DateUtil.parse("2022-12-31 13:59:59"), DateUtil.parse("2023-01-02 23:59:59"), DateField.DAY_OF_YEAR);
        String collect = range.stream().map(x -> DateUtil.formatDateTime(x)).collect(Collectors.joining(","));
        System.out.println(collect);

        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 08:08:28"),DateUtil.parse("2023-01-01 10:41:35"), DateUnit.MINUTE, true));
        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 19:47:08"),DateUtil.parse("2023-01-01 21:51:04"), DateUnit.MINUTE, true));
        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 11:51:08"),DateUtil.parse("2023-01-01 15:04:27"), DateUnit.MINUTE, true));
        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 21:51:10"),DateUtil.parse("2023-01-01 23:59:59"), DateUnit.MINUTE, true));


        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 00:00:00"),DateUtil.parse("2023-01-01 00:01:01"), DateUnit.SECOND, true));
        System.out.println(DateUtil.between(DateUtil.parse("2023-01-01 00:00:00"),DateUtil.parse("2023-01-01 23:59:59"), DateUnit.SECOND, true));

        System.out.println(BigDecimal.ONE.add(BigDecimal.ONE).divide(BigDecimal.TEN));

        List<DateTime> timeList = DateUtil.rangeToList(DateUtil.parse("2023-01-01 00:00:00"), DateUtil.parse("2024-02-01 00:00:00"), DateField.MONTH);
        List<DateTime> dateList = DateUtil.rangeToList(DateUtil.parse("2023-01-01 00:00:00"), DateUtil.parse("2024-01-01 00:00:00"), DateField.DAY_OF_YEAR);

    }

    /**
     * 将多个时间碎片合并，去除重合时间段
     *
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<Interval> collect = intervals.stream().sorted(Comparator.comparing(Interval::getStart)).collect(Collectors.toList());
        List<Interval> result = new ArrayList<>();
        Date start = collect.get(0).getStart();
        Date end = collect.get(0).getEnd();
        for (int i = 1; i < collect.size(); i++) {
            // 无效的时间范围
            if (collect.get(i).getStart().compareTo(collect.get(i).getEnd()) >= 0) {
                continue;
            }
            if (collect.get(i).getStart().compareTo(end) <= 0) {
                start = new Date(Math.min(start.getTime(), collect.get(i).getStart().getTime()));
                end = new Date(Math.max(end.getTime(), collect.get(i).getEnd().getTime()));
            } else {
                result.add(new Interval(start, end));
                start = collect.get(i).getStart();
                end = collect.get(i).getEnd();
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    /**
     * 将多个时间片段合并去重，并且限制到指定范围内
     *
     * @param intervals
     * @param min
     * @param max
     * @return
     */
    public static List<Interval> mergeWithLimit(List<Interval> intervals, Date min, Date max) {
        for (Interval interval : intervals) {
            if (interval.getStart() == null || interval.getStart().compareTo(min) < 0) {
                interval.setStart(min);
            }
            if (interval.getEnd() == null || interval.getEnd().compareTo(max) > 0) {
                interval.setEnd(max);
            }
        }
        List<Interval> filterList
                = intervals.stream()
                .filter(x -> !(x.getStart().compareTo(max) > 0 || x.getEnd().compareTo(min) < 0))
                .collect(Collectors.toList());
        return merge(filterList);
    }

    /**
     * 获取min-max范围内时间段差集间隙
     *
     * @param intervals
     * @param min
     * @param max
     * @return
     */
    public static List<Interval> listGapWithLimit(List<Interval> intervals, Date min, Date max) {
        List<Interval> res = new ArrayList<>();
        // 先合并时间
        List<Interval> mergeList = mergeWithLimit(intervals, min, max);
        // 合并后没有符合范围的数据，直接返回限制范围时间
        if (CollectionUtil.isEmpty(mergeList)) {
            res.add(new Interval(min, max));
        } else {
            Date begin = min, end = max;
            for (int i = 0; i < mergeList.size(); i++) {
                Interval interval = mergeList.get(i);
                // ___====__===_
                if (interval.getStart().compareTo(begin) > 0) {
                    res.add(new Interval(begin, interval.getStart()));
                    begin = interval.getEnd();
                } else {
                    // ===____====
                    if (interval.getEnd().compareTo(end) >= 0) {
                        break;
                    } else {
                        begin = interval.getEnd();
                    }
                }
                // 最后处理
                if (i == mergeList.size() - 1 && begin.compareTo(end) < 0) {
                    res.add(new Interval(begin, end));
                }
            }
        }
        return res;
    }

    public static List<Interval> splitEveryHour(Date begin, Date end) {
        List<Interval> res = new ArrayList<>();
        do {
            Date endOfHour = DateUtil.endOfHour(begin);
            if (endOfHour.compareTo(end) >= 0) {
                endOfHour = end;
            }
            res.add(new Interval(begin, endOfHour));
            begin = DateUtil.offsetSecond(endOfHour, 1);
        } while (begin.compareTo(end) <= 0);
        return res;
    }

    static class Interval {
        private Date start;
        private Date end;

        public Interval(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return start.equals(interval.start) && end.equals(interval.end);
        }
    }

}
