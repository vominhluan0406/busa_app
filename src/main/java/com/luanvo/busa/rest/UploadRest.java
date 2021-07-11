package com.luanvo.busa.rest;

import com.luanvo.busa.service.UploadFileService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadRest {

    private static final Logger log = LoggerFactory.getLogger(UploadRest.class);

    @Autowired
    UploadFileService uploadFileService;

    @PostMapping("/image")
    public JSONObject uploadImage(@RequestParam("type") int type, @RequestBody MultipartFile[] files) throws IOException {
        log.info("/upload/image -- type: " + type);
        return uploadFileService.uploadImage(type,files);
    }
}
