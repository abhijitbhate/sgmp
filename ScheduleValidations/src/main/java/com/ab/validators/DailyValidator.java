package com.ab.validators;

import com.ab.beans.Schedule;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DailyValidator extends AbstractValidator{

    @Override
    public void validate(Schedule schedule, List<String> fieldsToValidate) {
        for(String field : fieldsToValidate) {
            validate(schedule, field);
        }
    }

    private void validate(Schedule schedule, String field) {

        switch (field) {
            case "startDate":
                if (schedule.getStartDate().toLocalDate().isBefore(LocalDate.now())) {
                    System.out.println("start date validation failed");
                }
                break;

            case "recurrence":
                if (schedule.getRecurrence().size() != schedule.getRecurrence().stream().collect(Collectors.toSet()).size()) {
                    System.out.println("recurrence size check failed");
                }

                if (schedule.getRecurrence().size() != 5) {
                    if (schedule.getRecurrence().size() != 7) {
                        System.out.println("size is neither 5 or 7");
                    }
                }

                if (schedule.getRecurrence().size() == 5 && schedule.getRecurrence().stream().mapToInt(e -> e.intValue()).sum() != 15) {
                    System.out.println("Weekday sum did not match to 15");
                }

                if (schedule.getRecurrence().size() == 7 && schedule.getRecurrence().stream().mapToInt(e -> e.intValue()).sum() != 28) {
                    System.out.println("Everyday sum did not match to 28");
                }

                if (!Arrays.asList(DayOfWeek.values()).stream().map(e -> e.getValue()).collect(Collectors.toList()).containsAll(
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
        }
    }
}
