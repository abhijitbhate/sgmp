package com.ab;

import com.ab.beans.Schedule;
import com.ab.beans.TblSchedule;
import com.ab.delegate.ScheduleValidator;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class ValidateSchedule {

    public static void main(String[] args) {
        ScheduleValidator scheduleValidator = new ScheduleValidator();
        scheduleValidator.validateSchedule(getDailyWeekdaysSchedule(), getDailyWeekdaysDBSchedule());
    }

    public static Schedule getDailyWeekdaysSchedule() {
        Schedule schedule = new Schedule();

        schedule.setFrequency("DAILY");
        schedule.setExecuteAt("2018-04-26 10:00:00");
        schedule.setStartDate(Date.valueOf(LocalDate.now()));
        schedule.getRecurrence().add(1);
        schedule.getRecurrence().add(2);
        schedule.getRecurrence().add(3);
        schedule.getRecurrence().add(4);
        schedule.getRecurrence().add(5);

        return schedule;
    }

    public static TblSchedule getDailyWeekdaysDBSchedule() {
        TblSchedule tblSchedule = new TblSchedule();

        tblSchedule.setFrequency("DAILY");
        tblSchedule.setDaysOfWeek("1,2,3,4,5");
        tblSchedule.setScheduleTime(Timestamp.valueOf("2018-04-26 10:00:00"));
        tblSchedule.setStartDate(LocalDate.now());

        return tblSchedule;
    }

    public static Schedule getDailyEverydaySchedule() {
        Schedule schedule = new Schedule();

        schedule.setFrequency("DAILY");
        schedule.setExecuteAt("2018-04-26 10:00:00");
        schedule.setStartDate(Date.valueOf(LocalDate.now()));
        schedule.getRecurrence().add(1);
        schedule.getRecurrence().add(2);
        schedule.getRecurrence().add(3);
        schedule.getRecurrence().add(4);
        schedule.getRecurrence().add(5);
        schedule.getRecurrence().add(6);
        schedule.getRecurrence().add(7);

        return schedule;
    }

    public static TblSchedule getDailyEverydayDBSchedule() {
        TblSchedule tblSchedule = new TblSchedule();

        tblSchedule.setFrequency("DAILY");
        tblSchedule.setDaysOfWeek("1,2,3,4,5,6,7");
        tblSchedule.setScheduleTime(Timestamp.valueOf("2018-04-26 10:00:00"));
        tblSchedule.setStartDate(LocalDate.now());

        return tblSchedule;
    }

    public static Schedule getWeeklySchedule() {
        Schedule schedule = new Schedule();

        schedule.setFrequency("WEEKLY");
        schedule.setExecuteAt("2018-04-26 10:00:00");
        schedule.getRecurrence().add(1);
        schedule.getRecurrence().add(2);
        schedule.getRecurrence().add(3);
        schedule.getRecurrence().add(4);
        schedule.getRecurrence().add(5);
        schedule.getRecurrence().add(6);
        schedule.getRecurrence().add(7);

        return schedule;

    }

    public static TblSchedule getWeeklyDBSchedule() {
        TblSchedule tblSchedule = new TblSchedule();

        tblSchedule.setFrequency("WEEKLY");
        tblSchedule.setDaysOfWeek("1,2,3,4,5,6,7");
        tblSchedule.setScheduleTime(Timestamp.valueOf("2018-04-26 10:00:00"));

        return tblSchedule;
    }

    public static Schedule getMonthlySchedule() {
        Schedule schedule = new Schedule();

        schedule.setFrequency("MONTHLY");
        schedule.setExecuteOn(10);
        schedule.setExecuteAt("2018-04-26 10:00:00");
        schedule.getRecurrence().add(1);
        schedule.getRecurrence().add(2);
        schedule.getRecurrence().add(3);
        schedule.getRecurrence().add(4);
        schedule.getRecurrence().add(5);
        schedule.getRecurrence().add(6);
        schedule.getRecurrence().add(7);
        schedule.getRecurrence().add(8);
        schedule.getRecurrence().add(9);
        schedule.getRecurrence().add(10);
        schedule.getRecurrence().add(11);
        schedule.getRecurrence().add(12);

        return schedule;

    }

    public static TblSchedule getMonthlyDBSchedule() {
        TblSchedule tblSchedule = new TblSchedule();

        tblSchedule.setFrequency("MONTHLY");
        tblSchedule.setMonthsOfYear("1,2,3,4,5,6,7,8,9,10,11,12");
        tblSchedule.setScheduleTime(Timestamp.valueOf("2018-04-26 10:00:00"));
        tblSchedule.setStartDayOfTheMonth(10);

        return tblSchedule;
    }
}
