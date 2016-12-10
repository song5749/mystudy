package com.tmall.tmcs.thread.thread008;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/16.
 */
public class ListAdd1 {
    private volatile static List<String> list = new ArrayList();


    public  void addList(){
        list.add("ssk");
    }

    public int listSize(){
        return  list.size();
    }


    public static void main(String[] args) {
        ListAdd1 listAdd1 = new ListAdd1();


       Thread t1 =  new Thread(()->{
            try {
                for (int i = 0 ;i <10 ;i++) {
                    listAdd1.addList();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素");

                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"thread1");

        Thread t2= new Thread(()->{
            while (true){
                if(list.size() == 5){
                    System.out.println("当前线程得到通知:"+Thread.currentThread().getName()+"list size 为5时停止线程");
                    throw  new RuntimeException();
                }
            }
        },"Thread2");
        t1.start();
        t2.start();
    }
}
