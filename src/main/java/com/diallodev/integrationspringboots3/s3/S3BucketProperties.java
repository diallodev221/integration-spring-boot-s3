package com.diallodev.integrationspringboots3.s3;

import com.diallodev.integrationspringboots3.s3.validation.BucketExists;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "com.diallodev.aws.s3")
public class S3BucketProperties {

    @BucketExists
    @NotBlank(message = "S3 bucket name must be configured")
    private String bucketName;
}
