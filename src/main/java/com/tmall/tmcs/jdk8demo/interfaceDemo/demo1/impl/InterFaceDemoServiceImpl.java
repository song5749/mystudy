package com.tmall.tmcs.jdk8demo.interfaceDemo.demo1.impl;

import com.tmall.tmcs.jdk8demo.interfaceDemo.demo1.InterFaceDemoService;

/**
 * Created by Administrator on 2016/7/24.
 */
public class InterFaceDemoServiceImpl implements InterFaceDemoService {


    @Override
    public void defaultMethod() {
        System.out.println("实现类重写了接口default方法");
    }
}
