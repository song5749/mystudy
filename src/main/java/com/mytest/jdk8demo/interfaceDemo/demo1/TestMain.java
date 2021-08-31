package com.mytest.jdk8demo.interfaceDemo.demo1;

import com.mytest.jdk8demo.interfaceDemo.demo1.impl.InterFaceDemoServiceImpl;

/**
 * Created by Administrator on 2016/7/24.
 */
public class TestMain {

    public static void main(String[] args) {
        InterFaceDemoService.printStaticSerice();

        InterFaceDemoServiceImpl interFaceDemoService = new InterFaceDemoServiceImpl();
        interFaceDemoService.defaultMethod();

        InterFaceDemoService   interFaceDemoService1 = new InterFaceDemoServiceImpl();

        interFaceDemoService1.defaultMethod();

    }
}
