package com.tmall.tmcs.thread.providerAndcosumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 */
public class Provider implements  Runnable{
    //共享缓存
    private BlockingQueue<Data> blockingQueue;
    //多线程是否启动变量，有强制从主内存刷新的功能，及时返回线程的状态
    private volatile boolean isRuning = true;
    //生成ID
    private static AtomicInteger count = new AtomicInteger();

    private static Random random = new Random();

    public Provider(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {

        //程序根据 isRuning 判断是否一致运行还是不运行

        //随机休眠0-1000 毫秒（生产数据的耗时）

        //或者的数据进行累计
        while (isRuning){
            try {
                Thread.sleep(random.nextInt(1000));

                int id = count.incrementAndGet();
                Data data = new Data(id,"数据"+id);

                System.out.println("当前线程："+Thread.currentThread().getName()+",获得数据，id为："+id+",进行状态到公共缓存中...");

                if(!blockingQueue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("提交到公共缓存区失败");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public void stop(){
        this.isRuning = false;
    }
}
