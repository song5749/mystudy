package com.tmall.tmcs.StringTest;

import java.math.BigDecimal;

public class TestSubstring {

    public static void main(String[] args) {
        String a = "1234,";
        a = a.substring(0,a.length()-1);
        System.out.println(a);

        String b = "3.00300001067E11";
        BigDecimal bigDecimal = new BigDecimal(b);

        System.out.println(bigDecimal.longValue());

    }
}
