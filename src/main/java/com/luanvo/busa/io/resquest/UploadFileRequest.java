package com.luanvo.busa.io.resquest;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadFileRequest {
    private int type;
    private MultipartFile[] files;
}
