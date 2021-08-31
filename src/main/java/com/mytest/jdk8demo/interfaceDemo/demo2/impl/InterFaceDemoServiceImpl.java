package com.mytest.jdk8demo.interfaceDemo.demo2.impl;

import com.mytest.jdk8demo.interfaceDemo.demo2.InterFaceDemoService2;
import com.mytest.jdk8demo.interfaceDemo.demo2.InterFaceDemoService1;

/**
 * Created by Administrator on 2016/7/24.
 */
public class InterFaceDemoServiceImpl implements InterFaceDemoService1, InterFaceDemoService2 {

    @Override
    public void defaultMethod() {
        System.out.println("重写了接口default方法");
    }
}
