package com.tmall.tmcs.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Administrator on 2017/7/2.
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();

        Task t1 = new Task();
        t1.setId(1);
        t1.setName("任务1");

        Task t2 = new Task();
        t2.setId(2);
        t2.setName("任务6");


        Task t3 = new Task();
        t3.setId(3);
        t3.setName("任务4");

        priorityBlockingQueue.put(t1);
        priorityBlockingQueue.put(t3);

        priorityBlockingQueue.put(t2);

        System.out.println(priorityBlockingQueue);
        System.out.println(priorityBlockingQueue.poll().getName());
        System.out.println(priorityBlockingQueue);

//        while (true){
//            System.out.println(priorityBlockingQueue.take().getName());
//        }

    }
}
