package com.tmall.tmcs.thread.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UseThreadPoolExecutor {

    public static void main(String[] args) {

        /**
         * 在使用有界队列的时候，若有新任务需要执行，如果线程池里面的实际线程数小于corePoolSize，则优先创建线程
         * 若大于corePoolSize，则会将任务加入队列
         * 若队列已满，且总线程数大不于maximumPoolSize的前提下，创建新的线程
         * 若线程大于maximumPoolSize，则执行拒绝策略，或其他自定义方式
         *
         *拒绝策略
         * 1.AbortPolicy 默认的拒绝策略 直接抛出异常组织系统正常工作
         * 2.CallerRunsPolicy 只要线程池未关闭，该策略直接在调用者的线程中，运行当前被丢弃的任务
         * 3.DiscardOldestPolicy 丢弃最好的一个请求，尝试再次提交当前任务
         * 4.DiscardPolicy 丢弃无法处理的任务，不给于理会
         * 5.RejectedExecutionHandler 继承这个接口自己写拒绝策略
         *
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, //corePoolSize 核心线程
                2, //最大线程数
                60, //空闲的时间
                TimeUnit.SECONDS, //时间的单位
                new ArrayBlockingQueue<Runnable>(3)
                ,new ThreadPoolExecutor.CallerRunsPolicy()
        );


        MyTask myTask1= new MyTask(1,"task1");
        MyTask myTask2= new MyTask(2,"task2");

        MyTask myTask3= new MyTask(3,"task3");

        MyTask myTask4= new MyTask(4,"task4");

        MyTask myTask5= new MyTask(5,"task5");
        MyTask myTask6= new MyTask(6,"task6");


        threadPoolExecutor.execute(myTask1);
        threadPoolExecutor.execute(myTask2);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask4);
        threadPoolExecutor.execute(myTask5);
        threadPoolExecutor.execute(myTask6);

        threadPoolExecutor.shutdown();

    }

}
