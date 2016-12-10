package com.tmall.tmcs.thread.thread009;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/10/16.
 */
public class MyQueue {
    //队列集合
    private LinkedList<Object> list = new LinkedList<>();
    //计数器
    private AtomicInteger count = new AtomicInteger();
    //最小值
    private int minCount = 0;
    //最大值
    private int maxCount ;
    //锁
    private Object lock = new Object();

    public MyQueue(int maxCount){
        this.maxCount = maxCount;
    }

    public void put(Object obj){
        synchronized (lock){
            if(maxCount == count.get()){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //加入元素
            list.add(obj);
            //计数器累加
            System.out.println("新加入的元素为:"+obj);
            count.incrementAndGet();
            //唤醒另外的线程
            lock.notify();
        }
    }

    public  Object take(){
        Object obj = null ;
        synchronized (lock) {
            if (minCount == count.get()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            obj =  list.removeFirst();
            System.out.println("移除了一个元素:" + obj);
            count.decrementAndGet();
            lock.notify();
        }
        return obj;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.put("1");
        myQueue.put("2");
        myQueue.put("3");
        myQueue.put("4");
        myQueue.put("5");


        Thread t1 = new Thread(()->{
            myQueue.put("6");
            myQueue.put("7");
        },"t1");
        t1.start();
        Thread t2 = new Thread(()->{
            myQueue.take();
            myQueue.take();
        },"t2");
        t2.start();
    }
}
