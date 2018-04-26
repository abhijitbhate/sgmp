package com.ab.delegate;

import com.ab.beans.Schedule;
import com.ab.beans.TblSchedule;
import com.ab.factory.ConfigFactory;
import com.ab.factory.ValidatorFactory;
import com.ab.validators.AbstractValidator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleValidator {

    public void validateSchedule(Schedule schedule, TblSchedule tblSchedule) {

        List<String> fieldsToValidate = getFieldsToValidate(schedule, tblSchedule);

        if(fieldsToValidate != null && !fieldsToValidate.isEmpty()) {
            AbstractValidator abstractValidator = ValidatorFactory.getValidator(schedule.getFrequency());
            abstractValidator.validate(schedule, fieldsToValidate);
        }else{
            System.out.println("Neither frequency nor schedule properties are changed");
        }
    }

    private List<String> getFieldsToValidate(Schedule schedule, TblSchedule tblSchedule) {
        List<String> fieldsToValidate = new ArrayList<>(0);

        if(!schedule.getFrequency().equals(tblSchedule.getFrequency())) {
            fieldsToValidate = ConfigFactory.getInstance().getValidationConfig().getStringArray(schedule.getFrequency().toLowerCase());
        } else{

            if(schedule.getStartDate() != null && !schedule.getStartDate().toLocalDate().isEqual(tblSchedule.getStartDate())) {
                fieldsToValidate.add("startDate");
            }

            String daysOfWeek = schedule.getRecurrence().stream().map(r -> r.toString()).collect(Collectors.joining(","));
            if(!daysOfWeek.equals(tblSchedule.getDaysOfWeek())) {
                fieldsToValidate.add("recurrence");
            }

            if(schedule.getExecuteAt() != null && !Timestamp.valueOf(schedule.getExecuteAt()).equals(tblSchedule.getScheduleTime())) {
                fieldsToValidate.add("executeAt");
            }

            if(schedule.getExecuteOn() != null && !schedule.getExecuteOn().equals(tblSchedule.getStartDayOfTheMonth())) {
                fieldsToValidate.add("executeOn");
            }
        }

        return fieldsToValidate;
    }
}
