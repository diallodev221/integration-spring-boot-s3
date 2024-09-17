package com.diallodev.integrationspringboots3.s3;

import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(S3BucketProperties.class)
public class StorageService {

    private final S3Template s3Template;
    private final S3BucketProperties s3BucketProperties;

    public void upload(MultipartFile file) throws IOException {
        var objectKey = file.getOriginalFilename();
        if (objectKey != null) {
            String bucketName = s3BucketProperties.getBucketName();
            s3Template.upload(bucketName, objectKey, file.getInputStream());
        }
    }

    public S3Resource retrieve(String objectKey){
        var bucketName = s3BucketProperties.getBucketName();
        return s3Template.download(bucketName, objectKey);
    }

    public void delete(String objectKey) {
        var bucketName = s3BucketProperties.getBucketName();
        s3Template.deleteObject(bucketName, objectKey);
    }
}
