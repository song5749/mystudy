package com.tmall.tmcs.thread.thread001;

/**
 * Created by Administrator on 2016/8/13.
 */
public class MyThread extends  Thread{
    private int count = 5;
//synchronized
    @Override
    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName()+" count:"+count);
    }

    public static void main(String[] args) {

        /**
         * 当多个线程访问MyThread 的run方法时，是以排队的方式进行访问的（这个排队是按照cpu分配的顺序进行的）
         *  一个线程想要执行synchronized修饰的方法
         *      1.尝试获得锁
         *      2.如果拿到锁就会执行sychronized所修饰方法的内容，如果拿不到，这个线程就会不断的去尝试获得锁，直到拿到为止
         *          而且是多个线程去竞争这把锁（也就是会出现锁竞争的问题）
         *
         *
         */
        MyThread myThread = new MyThread();

        Thread t1 = new Thread(myThread,"t1");

        Thread t2 = new Thread(myThread,"t2");

        Thread t3 = new Thread(myThread,"t3");

        Thread t4 = new Thread(myThread,"t4");

        Thread t5 = new Thread(myThread,"t5");
        t5.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("count:"+myThread.count);

    }
}
