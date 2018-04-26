package com.ab.validators;

import com.ab.beans.Schedule;

import java.util.List;

public abstract class AbstractValidator {

    public abstract void validate(Schedule schedule, List<String> fieldsToValidate);
}
