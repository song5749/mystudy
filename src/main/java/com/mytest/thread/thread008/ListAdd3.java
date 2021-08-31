package com.mytest.thread.thread008;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/10/16.
 */
public class ListAdd3 {
    private volatile static List<String> list = new ArrayList();


    public void addList() {
        list.add("ssk");
    }

    public int listSize() {
        return list.size();
    }


    public static void main(String[] args) {
        ListAdd3 listAdd1 = new ListAdd3();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Object lock = new Object();

        Thread t1 = new Thread(() -> {

            try {
                for (int i = 0; i < 10; i++) {
                    listAdd1.addList();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "添加了一个元素");

                    Thread.sleep(500);
                    if (list.size() == 5) {
                        countDownLatch.countDown();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "thread1");

        Thread t2 = new Thread(() -> {
            if (list.size() != 5) {
                try {
                    System.out.println("進入T2線程的鎖");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("当前线程得到通知:" + Thread.currentThread().getName() + "list size 为5时停止线程");
            throw new RuntimeException();
        }, "Thread2");
        t1.start();
        t2.start();


    }
}
