package com.mytest.StringTest;/**
 * @Auther: shaokun.ssk
 * @Date: 2019/2/1 15:20
 * @Description:
 */

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @Auther: shaokun.ssk
 * @Date: 2019/2/1 15:20
 * @Description:
 */
public class StringEscapeUtilsTest {

    public static void main(String[] args) {
        String a ="\\u677E\\u5C11";
        System.out.println(        StringEscapeUtils.escapeJava(a));


    }
}
