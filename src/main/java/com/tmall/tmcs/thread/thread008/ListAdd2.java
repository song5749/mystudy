package com.tmall.tmcs.thread.thread008;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/16.
 * 1。notify 和wait必须配合synchronized来使用
 * 2.wait方法释放锁，notify方法不释放锁
 *
 */
public class ListAdd2 {
    private volatile static List<String> list = new ArrayList();


    public  void addList(){
        list.add("ssk");
    }

    public int listSize(){
        return  list.size();
    }


    public static void main(String[] args) {
        ListAdd2 listAdd1 = new ListAdd2();

        Object lock = new Object();

       Thread t1 =  new Thread(()->{
           synchronized (lock){
               try {
                   for (int i = 0 ;i <10 ;i++) {
                       listAdd1.addList();
                       System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素");

                       Thread.sleep(500);
                       if (list.size() == 5 ){
                           lock.notify();
                       }
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"thread1");

        Thread t2= new Thread(()->{
            synchronized (lock){
                if (list.size() != 5){
                    try {
                        System.out.println("進入T2線程的鎖");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程得到通知:"+Thread.currentThread().getName()+"list size 为5时停止线程");
                throw  new RuntimeException();
            }


        },"Thread2");
        t2.start();
        t1.start();

    }
}
