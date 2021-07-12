package com.luanvo.busa.utils;

public enum ErrorContent {

    ERROR("Có lỗi xảy ra."),
    IMAGE_IS_LARGE("File ảnh dung lượng nhỏ hơn 2048 KB."),
    AUTHEN_FAIL("Phiên bản đăng nhập hết hạn.");

    private String msg;

    ErrorContent(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
