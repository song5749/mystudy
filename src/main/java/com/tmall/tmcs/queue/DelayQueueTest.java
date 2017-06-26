package com.tmall.tmcs.queue;

import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2017/6/26.
 *
 *DelayQueue 是带有时间延迟的Queue,其中的元素只有其指定的延迟时间到了，才能从队列中获得该元素
 * DelayQueue中的元素必须实现Delayed接口，DelayQueue 是一个无界队列，应用场景很多，比如对缓存超的数据进行移除，任务超时处理，空闲连接的关闭
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue delayQueue = new DelayQueue();
    }
}
