package com.tmall.tmcs.thread.thread13;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/3/16.
 */
public class UserConcurrentMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("k1","11");
        concurrentHashMap.put("k1","22");

        concurrentHashMap.put("k2","22");
        concurrentHashMap.put("k3","33");
        concurrentHashMap.putIfAbsent("k3","fdsfds");

        concurrentHashMap.forEach((e,x) ->{
            System.out.println("key is "+e+",value is "+x);
        });

    }
}
