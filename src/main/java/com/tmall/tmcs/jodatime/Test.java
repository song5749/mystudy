package com.tmall.tmcs.jodatime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * Created by shaokun.sanjie on 2017/6/7.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println( DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2017"+"-"+"06"+"-"+"13" +" 18:00:00"));
        System.out.println(DateTime.now());
    }
}
