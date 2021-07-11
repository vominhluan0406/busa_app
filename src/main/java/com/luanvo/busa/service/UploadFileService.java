package com.luanvo.busa.service;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    JSONObject uploadImage(int type, MultipartFile[] files);
}
