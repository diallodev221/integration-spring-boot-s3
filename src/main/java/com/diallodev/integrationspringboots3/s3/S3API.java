package com.diallodev.integrationspringboots3.s3;

import io.awspring.cloud.s3.S3Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/storage")
public interface S3API {

    @PostMapping
    void upload(@RequestParam("file")MultipartFile file) throws IOException;

    @GetMapping
    S3Resource retrieve(@RequestParam("key") String objectKey);

    @DeleteMapping
    void delete(@RequestParam("key") String objectKey);

}
