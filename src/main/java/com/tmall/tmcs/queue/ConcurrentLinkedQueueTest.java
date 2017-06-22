package com.tmall.tmcs.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2017/6/22.
 * ConcurrentLinkedQueue 是适合高并发场景的队列，通过无锁的方式实现高并发下的高性能，
 * 通常ConcurrentLinkedQueue的性能要好于BlockingQueue。它实现了一个基于链接节点的无界限程安全队列
 * 该队列遵循了先进先出的原则，头是最先加入的，尾是最后加入的，该队列不允许null元素
 *
 * 重要方法
 *
 * add()和offer()都是加入元素ConcurrentLinkedQueue 中两个方法无区别
 * poll()和peek()是取出头元素，区别在于poll会在取出后删除元素 peek则不会被删除
 *
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        concurrentLinkedQueue.add("a");

        concurrentLinkedQueue.offer("b");
        concurrentLinkedQueue.offer("c");

        System.out.println(concurrentLinkedQueue.poll());
        System.out.println(concurrentLinkedQueue.size());
        System.out.println(concurrentLinkedQueue.peek());
        System.out.println(concurrentLinkedQueue.size());



    }
}
