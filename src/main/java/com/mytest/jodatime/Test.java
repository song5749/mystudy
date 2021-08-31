package com.mytest.jodatime;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by shaokun.sanjie on 2017/6/7.
 */
public class Test {

    public static void main(String[] args) {
    // //   System.out.println( DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2017"+"-"+"06"+"-"+"13" +" 18:00:00"));
     //   System.out.println(DateTime.now());
        LocalDate localDate = LocalDate.now();
    //    System.out.printf(localDate.toString());

        LocalDateTime localDateTime =LocalDateTime.now();
        LocalDateTime yesterday18 = localDateTime.plusDays(-1).withHour(18).withMinute(0).withSecond(0);
        System.out.println(localDateTime);

        System.out.println(localDateTime.isAfter(yesterday18));
        System.out.println(yesterday18.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println(LocalDateTime.parse("2018-12-18T11:11:11",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
    }
}
