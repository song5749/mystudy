package com.tmall.tmcs.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TestJob extends Thread{
    @Override
    public void run() {
        System.out.println("run");
    }
}

public class ScheduledJob {

    public static void main(String[] args) {

        TestJob testJob = new TestJob();
       ScheduledExecutorService scheduledExecutorService =  Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleWithFixedDelay(testJob,3,3, TimeUnit.SECONDS);
    }
}
