package com.luanvo.busa.utils;

public enum ErrorContent {

    ERROR("Có lỗi xảy ra."),
    IMAGE_IS_LARGE("File ảnh dung lượng nhỏ hơn 2048 KB.");

    private String msg;

    ErrorContent(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
