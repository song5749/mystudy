package com.mytest.jdk8demo.lamdba.demo1;

/**
 * Created by shaokun.ssk on 2016/8/8.
 */
public class RunableTest {

    public static void main(String[] args) {
        //匿名内部类
     Thread t =    new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("run...."+i);
                }
            }
        });
        t.start();
//        new Thread(() ->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println("run...."+i);
//            }
//        }).start();

        for (int i = 0; i < 99; i++) {
            System.out.println("main...."+i);
        }

    }
}
