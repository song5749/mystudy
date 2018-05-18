package com.tmall.tmcs.BigDecimalTest;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(3);
        BigDecimal b = new BigDecimal(11.01);
        BigDecimal c = new BigDecimal("0.00");

        System.out.println(c);

       // System.out.printf(a.divide(b,3,BigDecimal.ROUND_DOWN)+"");
        //System.out.printf(b.setScale(0,BigDecimal.ROUND_DOWN).toString());

    }
}
