package com.masivian.test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateString {

    String[] acceptedValues();

    String message() default "Error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
