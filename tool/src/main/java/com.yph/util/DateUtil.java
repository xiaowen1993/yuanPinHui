package com.yph.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String getDateString(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS+0800");
        Date now=new Date();
        String date = simpleDateFormat.format(now);
        return date;
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(getDateString());
        System.out.println(getDateString());
        Thread.sleep(1000);
        System.out.println(getDateString());
        System.out.println(getDateString());
    }


}
