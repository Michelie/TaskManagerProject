package com.michelle.taskmanager.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class StatusValidatior implements ConstraintValidator<Status, String> {

    List<String> statuses = Arrays.asList(
            "COMPLETED", "TODO", "IN_PROGRESS"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return false;
        for (String string : statuses) {
            if (value.equals(string)) return true;
        }
        return false;
    }


}