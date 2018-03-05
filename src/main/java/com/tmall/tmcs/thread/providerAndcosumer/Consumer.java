package com.tmall.tmcs.thread.providerAndcosumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Data> blockingDeque;

    private static Random random = new Random();


    public Consumer(BlockingQueue<Data> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        while (true){
            try {
                Data data = this.blockingDeque.take();
                Thread.sleep(random.nextInt(1000));
                System.out.println("当前消费的线程:"+Thread.currentThread().getName()+",消费成功，消费的数据ID为:"+data.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
