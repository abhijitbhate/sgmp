package com.ab.beans;

import java.sql.Timestamp;
import java.time.LocalDate;

public class TblSchedule {

    private String frequency;
    private LocalDate startDate;
    private Integer startDayOfTheMonth;
    private String daysOfWeek;
    private String monthsOfYear;
    private Timestamp scheduleTime;

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getStartDayOfTheMonth() {
        return startDayOfTheMonth;
    }

    public void setStartDayOfTheMonth(Integer startDayOfTheMonth) {
        this.startDayOfTheMonth = startDayOfTheMonth;
    }

    public String getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getMonthsOfYear() {
        return monthsOfYear;
    }

    public void setMonthsOfYear(String monthsOfYear) {
        this.monthsOfYear = monthsOfYear;
    }

    public Timestamp getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Timestamp scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
