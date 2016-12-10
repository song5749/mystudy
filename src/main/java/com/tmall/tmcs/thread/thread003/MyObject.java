package com.tmall.tmcs.thread.thread003;

/**
 * Created by Administrator on 2016/8/14.
 */
public class MyObject {

    public synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }catch (Exception e){

        }
    }
/*
*
* 1.t1线程持有object对象的lock锁，t2线程可以以异步的方式调用对象中非synchronized得方法
* 2.t1线程持有object对象的lock锁，t2线程调用调用对象中的同步(synchronized)方法则需要等待，也就是同步
*
* */
    public synchronized  void  method2(){
        System.out.printf(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        Thread t1 = new Thread(() ->{
            myObject.method1();
        },"t1");

        Thread t2 = new Thread(() ->{
            myObject.method2();
        },"t2");

        t1.start();
        t2.start();
    }
}
