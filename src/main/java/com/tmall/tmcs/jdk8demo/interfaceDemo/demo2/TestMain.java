package com.tmall.tmcs.jdk8demo.interfaceDemo.demo2;

import com.tmall.tmcs.jdk8demo.interfaceDemo.demo1.InterFaceDemoService;
import com.tmall.tmcs.jdk8demo.interfaceDemo.demo1.impl.InterFaceDemoServiceImpl;

/**
 * Created by Administrator on 2016/7/24.
 */
public class TestMain {

    public static void main(String[] args) {
        InterFaceDemoService1.printStaticSerice();
        InterFaceDemoService2.printStaticSerice();

        InterFaceDemoServiceImpl interFaceDemoService = new InterFaceDemoServiceImpl();
        interFaceDemoService.defaultMethod();
    }
}
