package com.diallodev.integrationspringboots3.s3;

import io.awspring.cloud.s3.S3Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller implements S3API {

    private final StorageService service;

    @Override
    public void upload(MultipartFile file) throws IOException {
        service.upload(file);
    }

    @Override
    public S3Resource retrieve(String objectKey) {
        return service.retrieve(objectKey);
    }

    @Override
    public void delete(String objectKey) {
        service.delete(objectKey);
    }
}
