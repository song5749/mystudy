package com.tmall.tmcs.BigDecimalTest;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(3);
        BigDecimal b = new BigDecimal(11);

        System.out.printf(a.divide(b,3,BigDecimal.ROUND_DOWN)+"");

    }
}
