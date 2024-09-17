package com.diallodev.integrationspringboots3.s3;

import com.diallodev.integrationspringboots3.s3.validation.BucketExists;
import io.awspring.cloud.s3.S3Template;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BucketExistenceValidator implements ConstraintValidator<BucketExists, String> {

    private final S3Template s3Template;

    @Override
    public boolean isValid(String bucketName, ConstraintValidatorContext constraintValidatorContext) {
        return s3Template.bucketExists(bucketName);
    }
}
