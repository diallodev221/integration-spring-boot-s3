package com.diallodev.integrationspringboots3.s3.validation;

import com.diallodev.integrationspringboots3.s3.BucketExistenceValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BucketExistenceValidator.class)
public @interface BucketExists {

    String message() default "No bucket exists with the configured name.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
