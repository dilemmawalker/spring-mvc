package com.dilemmawalker.springMVCValidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //define default course code
    public String value() default "LUV";

//    similarly just by changing the value & message we can keep it to any string of our choice :)

    //define default error message
    public String message() default "must start with LUV";

    //define default groups
    public Class<?>[] groups() default{};

    //define default payloads
    public Class<? extends Payload>[] payload() default{};
}
