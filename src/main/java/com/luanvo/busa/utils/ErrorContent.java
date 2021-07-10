package com.luanvo.busa.utils;

public enum ErrorContent {

    ERROR("Có lỗi xảy ra.");

    private String msg;

    ErrorContent(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
