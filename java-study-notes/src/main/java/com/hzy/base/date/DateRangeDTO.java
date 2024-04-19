package com.hzy.base.date;

import cn.hutool.core.date.DateTime;

public class DateRangeDTO {

    private DateTime startDateTime;

    private DateTime endDateTime;

    private String weekFormat;

    @Override
    public String toString() {
        return "DateRangeDTO{" +
                "startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", weekFormat='" + weekFormat + '\'' +
                '}';
    }

    public DateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(DateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public DateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(DateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getWeekFormat() {
        return weekFormat;
    }

    public void setWeekFormat(String weekFormat) {
        this.weekFormat = weekFormat;
    }
}
