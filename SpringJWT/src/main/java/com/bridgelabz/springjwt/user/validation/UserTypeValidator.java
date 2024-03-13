package com.bridgelabz.springjwt.user.validation;

import com.bridgelabz.springjwt.user.entity.ValidateUserType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class UserTypeValidator implements ConstraintValidator<ValidateUserType, String> {


    @Override
    public boolean isValid(String userType, ConstraintValidatorContext constraintValidatorContext) {
        List<String> userTypes = Arrays.asList("Student", "Teacher");

        return userTypes.contains(userType);
    }
}
