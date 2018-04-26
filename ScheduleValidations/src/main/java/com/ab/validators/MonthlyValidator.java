package com.ab.validators;

import com.ab.beans.Schedule;

import java.sql.Timestamp;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonthlyValidator extends AbstractValidator {

    @Override
    public void validate(Schedule schedule, List<String> fieldsToValidate) {
        for(String field : fieldsToValidate) {
            validate(schedule, field);
        }
    }

    private void validate(Schedule schedule, String field) {

        switch (field) {

            case "recurrence":
                if (schedule.getRecurrence().size() != schedule.getRecurrence().stream().collect(Collectors.toSet()).size()) {
                    System.out.println("recurrence size check failed");
                }

                if (!Arrays.asList(Month.values()).stream().map(e -> e.getValue()).collect(Collectors.toList()).containsAll(
                        schedule.getRecurrence())) {
                    System.out.println("values do not match to Days of week");
                }

                break;
            case "executeAt":
                try {
                    Timestamp.valueOf(schedule.getExecuteAt());
                } catch (IllegalArgumentException e) {
                    System.out.println("The time format is not legal");
                }

                break;
            case "executeOn":
                if(schedule.getExecuteOn() < 1 || schedule.getExecuteOn() > 28) {
                    System.out.println("The execute on value is invalid.");
                }
                break;
        }
    }
}
