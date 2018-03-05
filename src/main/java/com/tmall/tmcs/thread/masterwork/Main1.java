package com.tmall.tmcs.thread.masterwork;

import java.util.Random;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Main1 {

    public static void main(String[] args) {
        Master master = new Master(new MyWoker(), 10);
        Random rendom = new Random();
        for (int i = 1; i <= 100; i++) {
            Task task = new Task(i, "任务" + i, rendom.nextInt(1000));
            master.submit(task);
        }

        master.execute();
        long startTime = System.currentTimeMillis();
        while (true) {
            if (master.isComplete()) {
                long end = System.currentTimeMillis() -startTime;
                int allResult = master.getResult();
                System.out.println("最终执行的结果:"+allResult+",用时+"+end+"毫秒");
                break;

            }
        }
    }
}
