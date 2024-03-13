package com.bridgelabz.springjwt.user.entity;

import com.bridgelabz.springjwt.user.validation.UserTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface ValidateUserType {
    public String message() default "Invalid userType: It should be either Student or Teacher";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
