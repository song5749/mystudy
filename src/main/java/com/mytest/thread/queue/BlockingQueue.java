package com.mytest.thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Administrator on 2017/6/23.
 * add方法在添加元素的时候，若超出了度列的长度会直接抛出异常：
 * put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素
 * offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
 *
 *    poll: 若队列为空，返回null。
 *   remove:若队列为空，抛出NoSuchElementException异常。
 *   take:若队列为空，发生阻塞，等待有元素。
 *
 */
public class BlockingQueue {
    public static void main(String[] args) throws  Exception{
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
//        arrayBlockingQueue.add("1");
//        arrayBlockingQueue.add("1");
//        arrayBlockingQueue.add("2");
//
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("b");
//        arrayBlockingQueue.put("c");

//        System.out.println( arrayBlockingQueue.offer("1"));
//        System.out.println( arrayBlockingQueue.offer("1"));
//
//        System.out.println(arrayBlockingQueue.offer("1"));
//
//        System.out.println(arrayBlockingQueue.size());


//        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
//
//        linkedBlockingQueue.offer("1");
//        linkedBlockingQueue.offer("2");
//        linkedBlockingQueue.offer("3");
//
//        linkedBlockingQueue.offer("4");
//        linkedBlockingQueue.offer("5");
//
////        for (String s : linkedBlockingQueue) {
////            System.out.println(s);
////        }
//
//        List<String> list = Lists.newArrayList();
//        linkedBlockingQueue.drainTo(list,3);
//
//        System.out.println(list.size());


        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        synchronousQueue.add("1");

    }

}
