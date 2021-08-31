package com.mytest.thread.thread13;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/3/16.
 *jdk1.8之前
 * ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分，
 * 每个段其实就是一个小的hash table，它们有自己的锁。
 * 只要多个修改操作发生在不同的段上，它们就可以并发进行。
 *
 * jdk1.8 采用了 “数组”+链表+红黑树的方式思想
 *
 *
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
