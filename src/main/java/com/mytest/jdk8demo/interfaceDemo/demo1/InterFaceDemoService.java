package com.mytest.jdk8demo.interfaceDemo.demo1;

/**
 * Created by Administrator on 2016/7/24.
 */
public interface InterFaceDemoService {

    public static void printStaticSerice(){
        System.out.println("我是接口的静态方法");
    }


    default void defaultMethod(){
        System.out.println("我是接口的default方法");
    }

}
