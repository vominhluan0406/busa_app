package com.luanvo.busa.utils;

import org.json.simple.JSONObject;

public class Response {

    public static final String DATA = "data";
    private static final String CODE = "code";
    private static final String MSG = "message";
    private static final String SUCCESS_MSG = "Success";
    private static final String ERROR_MSG = "Error";
    public static final String PAGE_LIMIT = "limit";
    public static final String TOTAL = "total";
    public static final String URL = "url";



    private static JSONObject response = new JSONObject();

    public static JSONObject success(){
        response.put(DATA,null);
        response.put(CODE,1);
        response.put(MSG,SUCCESS_MSG);
        return response;
    }

    public static JSONObject success(JSONObject data){
        response.put(DATA,data);
        response.put(CODE,1);
        response.put(MSG,SUCCESS_MSG);
        return response;
    }

    public static JSONObject error(String msg){
        response.put(DATA,null);
        response.put(CODE,0);
        response.put(MSG,msg);
        return response;
    }
}
