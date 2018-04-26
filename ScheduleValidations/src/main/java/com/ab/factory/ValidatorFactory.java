package com.ab.factory;

import com.ab.validators.AbstractValidator;
import com.ab.validators.DailyValidator;
import com.ab.validators.MonthlyValidator;
import com.ab.validators.WeeklyValidator;

public class ValidatorFactory {

    public static AbstractValidator getValidator(String frequency) {

        AbstractValidator instance = null;

        switch (frequency) {

            case "DAILY" :
                instance = new DailyValidator();
                break;
            case "WEEKLY" :
                instance = new WeeklyValidator();
                break;
            case "MONTHLY" :
                instance = new MonthlyValidator();
                break;
        }

        return instance;

    }
}
