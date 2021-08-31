package com.mytest.thread.masterwork;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Administrator on 2017/12/6.
 */
public class Master {

    //1.需要一个承载任务的集合
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();

    //2使用hashmap去承装所有的任务对象
    private HashMap<String,Thread> worksMap= new HashMap();

    //3需要一个容器承装每一个work并发执行的 结果集
    private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<>();


    //4 构造方法
    public  Master(Worker worker,int workCount){
        //每一个worker对象都需要有 mater的引用workQueue 用户任务的领取， requestMap用于任务的提交
        worker.setWorkerQuen(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < workCount; i++) {
            worksMap.put("子节点"+i,new Thread(worker));
        }
    }

    //5 一个提交任务的方法
    public void submit(Task task){
        workQueue.add(task);
    }

    //6需要一个执行的方法(启动应用程序，让所有work工作)
    public void execute(){
        for (Map.Entry<String, Thread> stringThreadEntry : worksMap.entrySet()) {
            stringThreadEntry.getValue().start();
        }
    }

    // 7 判断线程是否执行完毕
    public boolean isComplete(){ //当线程中还有没有执行完的 线程时 返回false 否则 返回true

        for (Map.Entry<String, Thread> stringThreadEntry : worksMap.entrySet()) {
            if(stringThreadEntry.getValue().getState() != Thread.State.TERMINATED){
                return  false;
            }
        }
        return true;
    }
    //8返回一个结果集
    public int getResult() {
        int allResult = 0;
        for (Map.Entry<String, Object> stringObjectEntry : resultMap.entrySet()) {
            allResult += (Integer) stringObjectEntry.getValue();
        }
        return  allResult;
    }
}
