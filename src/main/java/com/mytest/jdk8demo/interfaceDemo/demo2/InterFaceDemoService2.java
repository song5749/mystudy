package com.mytest.jdk8demo.interfaceDemo.demo2;

/**
 * Created by Administrator on 2016/7/24.
 */
public interface InterFaceDemoService2 {

    public static void printStaticSerice(){

        System.out.println("我是接口2的静态方法");
    }


    default void defaultMethod(){

        System.out.println("我是接口2的default方法");
    }

}
