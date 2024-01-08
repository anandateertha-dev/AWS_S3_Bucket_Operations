package com.aws_service.s3_bucket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws_service.s3_bucket.S3Services.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    private S3Service s3Service;

    @GetMapping("listbuckets")
    public ResponseEntity<Object> getAllBuckets() {
        return s3Service.listTheBucketsSerive();
    }
    
}