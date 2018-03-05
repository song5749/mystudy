package com.tmall.tmcs.thread.providerAndcosumer;

import java.util.concurrent.*;

/**
 * 生产者和消费者的演示
 */
public class ProviderAndConsumerMain {
    public static void main(String[] args) {
        //公共缓存区
        BlockingQueue<Data> blockingQueue = new LinkedBlockingDeque<>(10);

        //生产者
        Provider p1 = new Provider(blockingQueue);
        Provider p2 = new Provider(blockingQueue);
        Provider p3 = new Provider(blockingQueue);
        //消费者
        Consumer c1 = new Consumer(blockingQueue);
        Consumer c2 = new Consumer(blockingQueue);
        Consumer c3 = new Consumer(blockingQueue);


        ExecutorService cachePool = Executors.newCachedThreadPool();

        cachePool.execute(p1);
        cachePool.execute(p2);
        cachePool.execute(p3);
        cachePool.execute(c1);
        cachePool.execute(c2);
        cachePool.execute(c3);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p1.stop();
        p2.stop();
        p3.stop();

    }


}
