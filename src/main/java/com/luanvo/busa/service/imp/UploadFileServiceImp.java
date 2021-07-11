package com.luanvo.busa.service.imp;

import com.luanvo.busa.service.UploadFileService;
import com.luanvo.busa.utils.ErrorContent;
import com.luanvo.busa.utils.Response;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UploadFileServiceImp implements UploadFileService {

    @Value("${luanvo.ftp.host}")
    private String host;

    @Value("${luanvo.ftp.port}")
    private int port;

    @Value("${luanvo.ftp.username}")
    private String username;

    @Value("${luanvo.ftp.password}")
    private String password;

    @Value("${luanvo.ftp.url_product}")
    private String directPathProduct;

    @Value("${luanvo.ftp.limit}")
    private int limitFTPSize;

    @Value("${luanvo.ftp.url_order}")
    private String directPathOrder;

    @Value("${luanvo.ftp_url}")
    private String serverUrl;

    @Value("${luanvo.ftp.replace}")
    private String replaceUrl;

    @Override
    public JSONObject uploadImage(int type, MultipartFile[] files) {
        try {

            //Kiểm tra size của file
            for (MultipartFile file : files) {
                InputStream in = file.getInputStream();
                BufferedImage originalImage = ImageIO.read(in);
                DataBuffer dataBuffer = originalImage.getData().getDataBuffer();

                long size = (((long) dataBuffer.getSize()) * 4l) / (1024l * 1024l);
                if (size > limitFTPSize) {
                    return Response.error(ErrorContent.IMAGE_IS_LARGE.getMsg());
                }

            }

            List<String> images = this.saveFile(files, type == 1 ? directPathProduct : directPathOrder);
            JSONObject response = new JSONObject();
            response.put(Response.DATA, images);
            return Response.success(response);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ErrorContent.ERROR.getMsg());
        }
    }

    private List<String> saveFile(MultipartFile[] files, String imageDirectory) {
        List<String> result = new ArrayList<>();
        try {
            if (files != null) {
                for (MultipartFile file : files) {
                    if (file.getBytes().length > 0) {
                        String[] tmp = file.getOriginalFilename().split("\\.");
                        String random = String.valueOf(new Random().nextInt(1000));
                        String name = String.valueOf(System.currentTimeMillis()) + random + "." + tmp[1];

                        FTPClient ftpClient = new FTPClient();
                        ftpClient.connect(host, port);
                        ftpClient.login(username, password);
                        ftpClient.enterLocalPassiveMode();
                        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes())) {
                            boolean rs = ftpClient.storeFile(imageDirectory + name, inputStream);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        result.add(serverUrl + imageDirectory.replace(replaceUrl==null?"":replaceUrl,"") + name);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
