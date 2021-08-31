package com.mytest.jdk8demo.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Locale;

/**
 * Created by shaokun.sanjie on 2017/2/10.
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
       dateTest();



    }

    private static void dateTest(){
//        //获得当前日期
//        LocalDate localDate = LocalDate.now();
//        System.out.println("现在的日期是localDate:"+localDate);
//
//        //获得某个具体的日期
//        LocalDate firstDate_2017 = LocalDate.of(2017, Month.JANUARY,01);
//        System.out.println("2017年的第一天:"+firstDate_2017);
//
//        //获得不同地域的时间
//        LocalDateTime todayAsia = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
//        System.out.println("当前亚洲日期是:"+todayAsia);
//        LocalDateTime todayAmerica = LocalDateTime.now(ZoneId.of("America/Phoenix"));
//        System.out.println("当前美洲日期是:"+todayAmerica);
//
//        //获得基准日期点
//        LocalDate epochDay = LocalDate.ofEpochDay(365);
//        System.out.println("基准日期点:"+epochDay);
//
//
//        //某年的第几天的日期是
//        LocalDate yearDay =  LocalDate.ofYearDay(2017,100);
//        System.out.println("2017年第100天的日期"+yearDay);
//
//        //字符串转换为日期类型
//       LocalDate parseDate =  LocalDate.parse("2017-02-01");
//        System.out.println("字符串转换为日期:"+parseDate);
//        LocalDate parseDate2 =  LocalDate.parse("2017.02.13", DateTimeFormatter.ofPattern("yyyy.MM.dd"));
//        System.out.println("字符串转换为日期:"+parseDate2);
//
//        LocalDate preParseDate = parseDate.plusMonths(-1L);
//        System.out.println("上个月是"+preParseDate);


        LocalDateTime localDateTime  = LocalDateTime.now();

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a",Locale.ENGLISH) ));

//        LocalDateTime parseDat3 =  LocalDateTime.parse("2017-02-13 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-01 HH:mm:ss"));
//        System.out.println(parseDat3);
//
//
//        Instant instant = Instant.now();
//        System.out.println(instant.toEpochMilli());
//        System.out.println(System.currentTimeMillis());
    }


}
