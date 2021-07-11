package com.luanvo.busa.utils;

public class ConvertUtils {

    public static int toInt(Object o){
        try{
            return Integer.parseInt(o.toString());
        }catch (Exception e){
            return 0;
        }
    }

    public static double toDouble(Object o){
        try{
            return Double.parseDouble(o.toString());
        }catch (Exception e){
            return 0;
        }
    }

    public static String toString(Object o){
        try{
            return o.toString();
        }catch (Exception e){
            return null;
        }
    }
}
