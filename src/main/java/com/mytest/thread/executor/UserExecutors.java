package com.mytest.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Executor框架
 * 为了更好的控制多线程，jdk提供了一套线程框架Executor，帮助开发人员更好的控制线程，
 * 他们都在java.util.concurrent包下,是jdk并发包的核心，其中一个比较重要的类Executors，
 * 它扮演线程工厂的角色，我们通过Executors可以创建特定功能的线程池
 *
 */
public class UserExecutors {

    public static void main(String[] args) {
        /**
         * 该方法返回一个固定数量的线程池，该方法的线程数量始终不变
         * 当一个任务提交时，若线程中有空闲的线程，则立即执行，
         * 若没有则任务被暂缓在一个任务队列中等待有空闲的线程去执行
         *
         */
       ExecutorService pool1 =  Executors.newFixedThreadPool(10);

        /**
         * 创建一个 只有一个线程的线程池，若有空闲则执行，若没有空闲线程则暂缓在任务队列中
         */
        ExecutorService pool2 =  Executors.newSingleThreadExecutor();

        /**
         * 返回一个可根据实际情况调整线程数量的线程池，不限制线程最大线程数量，
         * 若用空闲的线程则执行任务，若无任务则不创建线程，并且每一个空线程会在60秒后进行回收
         */
        ExecutorService pool3 = Executors.newCachedThreadPool();

        /**
         * 该方法返回一个ScheduledExecutorService对象，但是该线程可以指定线程的数量
         * 类似于java的 TIMES 定时器
         */
        ExecutorService pool4 = Executors.newScheduledThreadPool(10);

        //new ThreadPoolExecutor()
    }

}
