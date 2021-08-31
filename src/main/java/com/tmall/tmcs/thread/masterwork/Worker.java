package com.tmall.tmcs.thread.masterwork;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Worker implements Runnable{

    private ConcurrentLinkedQueue<Task> workQueue;

    private ConcurrentHashMap<String, Object> resultMap;


    public void setWorkerQuen(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }


    //7

    public void run() {
        while (true){
           Task input =  workQueue.poll();
           if(input == null){
               break;
           }
            //真正的处理业务
          Object output =  MyWoker.handle(input);
            resultMap.put("task任务"+input.getId(),output);
        }
    }

    public static Object handle(Task input) {
        return null;
    }

//    private Object handle(Task input) {
//        Object output = null;
//
//        try {
//            Thread.sleep(500);
//            output = input.getValue();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return  output;
//    }
}
