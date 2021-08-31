package com.mytest.jdk8demo.encode;

import sun.misc.BASE64Decoder;

import java.net.URLDecoder;

public class EncodeTest {

    public static final BASE64Decoder decoder = new BASE64Decoder();


    public static void main(String[] args) throws Exception {
    // Base64.Decoder decoder =  Base64.getDecoder();

     //   System.out.println( decoder.decode(new String("c6rY28tfixGmADPqNrUqTRQbPNiph+/H7h7XWnYMqGokATU+9sCICI15Abm7nGobBuHHCqiqT5KkYRFAOsF4kw==").getBytes()));

        String decoderStr = new String(decoder.decodeBuffer(URLDecoder.decode("eGlhb3FpYW5n","UTF-8")),"UTF-8") ;

        System.out.println(decoderStr);
//        BenefitExcel benefitExcel = new BenefitExcel();
//
//        System.out.println(benefitExcel.getClass());
    }
}
