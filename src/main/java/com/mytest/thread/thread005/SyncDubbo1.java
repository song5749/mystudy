package com.mytest.thread.thread005;

/**
 * Created by Administrator on 2016/9/17.
 */
public class SyncDubbo1 {

    public  synchronized  void method1(){
        System.out.println("method1.......");
        method2();
    }

    public  synchronized  void method2(){
        System.out.println("method2.......");
        method3();
    }

    public  synchronized  void method3(){
        System.out.println("method3.......");
    }


    public static void main(String[] args) {
        final  SyncDubbo1 sd = new SyncDubbo1();
        Thread thread = new Thread(() ->{
           sd.method1();
        });
        thread.start();
    }
}
