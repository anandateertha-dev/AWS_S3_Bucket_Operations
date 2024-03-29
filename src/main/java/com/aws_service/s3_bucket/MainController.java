package com.aws_service.s3_bucket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws_service.s3_bucket.Models.BucketNameAndKey;
import com.aws_service.s3_bucket.Models.BucketNameKeyPath;
import com.aws_service.s3_bucket.S3Services.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    private S3Service s3Service;

    @GetMapping("listbuckets")
    public ResponseEntity<Object> getAllBuckets() {
        return s3Service.listTheBucketsSerive();
    }

    @GetMapping("presignedurl")
    public ResponseEntity<Object> getPreSignedURL(@RequestBody BucketNameAndKey bucketNameAndKey)
    {
        return s3Service.preSignedURLService(bucketNameAndKey);
    }

    @PutMapping("putobject")
    public ResponseEntity<Object> putObject(@RequestBody BucketNameKeyPath bucketNameKeyPath)
    {
        return s3Service.putObjectService(bucketNameKeyPath);
    }

    @DeleteMapping("deleteobject")
    public ResponseEntity<Object> deleteObject(@RequestBody BucketNameAndKey bucketNameAndKey)
    {
        return s3Service.deleteObjectService(bucketNameAndKey);
    }

    @GetMapping("createbucket")
    public ResponseEntity<Object> createBucket(@RequestHeader String bucketName)
    {
        return s3Service.createBucketService(bucketName);
    }
    
}
