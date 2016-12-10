package com.tmall.tmcs.jdk8demo.interfaceDemo.demo2.impl;

import com.tmall.tmcs.jdk8demo.interfaceDemo.demo1.InterFaceDemoService;
import com.tmall.tmcs.jdk8demo.interfaceDemo.demo2.InterFaceDemoService1;
import com.tmall.tmcs.jdk8demo.interfaceDemo.demo2.InterFaceDemoService2;

/**
 * Created by Administrator on 2016/7/24.
 */
public class InterFaceDemoServiceImpl implements InterFaceDemoService1,InterFaceDemoService2 {

    @Override
    public void defaultMethod() {
        System.out.println("重写了接口default方法");
    }
}
