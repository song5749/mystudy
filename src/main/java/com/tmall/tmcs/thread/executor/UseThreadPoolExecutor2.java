package com.tmall.tmcs.thread.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UseThreadPoolExecutor2 {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws Exception{

        /**
         * 在使用无界队列时,及LinkedBlockingQueue。
         * 与有界队列相比，除非系统资源耗尽，否则无界的任务队列不存在任务入队失败的情况
         * 当新的任务到来，系统的线程数小于corePoolSize时，则新建线程执行任务，
         * 当任务达到corePoolSize后，就不会继续增加。
         * 若后续仍有新的任务加入，而且没有空闲的线程的时候，则任务直接进入无界队列进行等待。
         * 若任务的创建和处理速度相差较大的时候，无界队列会持续增长，直到内存耗尽
         *
         * *
         */
        BlockingQueue blockingQueue =
                new LinkedBlockingQueue();
                  //  new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5, //corePoolSize 核心线程
                10, //最大线程数
                60, //空闲的时间
                TimeUnit.SECONDS, //时间的单位
                blockingQueue
        );


        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println("threadName is "+Thread.currentThread().getName()+",task id "+atomicInteger.addAndGet(1));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(1000);
        System.out.println("queue size "+blockingQueue.size());

       // threadPoolExecutor.shutdown();

    }

}
