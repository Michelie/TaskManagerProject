package com.michelle.taskmanager.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class LevelValidator implements ConstraintValidator<Level, String> {

    List<String> levels = Arrays.asList(
            "Completed", "In Progress", "Not Started",
            "Cancelled"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        for (String string : levels) {
            if (value.equals(string)) return true;
        }
        return false;
    }

}
