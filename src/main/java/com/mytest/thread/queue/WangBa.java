package com.mytest.thread.queue;

import java.util.concurrent.DelayQueue;

/**
 * Created by Administrator on 2017/7/2.
 */
public class WangBa implements  Runnable {
    private DelayQueue<WangMing> delayQueue = new DelayQueue<>();


    public boolean yingye = true;

    public void shangji(int id,String name ,int money){
        WangMing wangMing = new WangMing(id,name,money* 1000+System.currentTimeMillis());
        System.out.println("网名为:"+name+",身份证为:"+id+",交钱："+money+"，开始上机。。。。");
        delayQueue.add(wangMing);
    }


    public void xiajia(WangMing wangMing){
        System.out.println("网名为:"+wangMing.getName()+",身份证为:"+wangMing.getId()+"下机了。。。。");

    }

    @Override
    public void run() {
        while (yingye){
            try {
                System.out.println("上机中"+System.currentTimeMillis());
              WangMing wangMing = delayQueue.take();
                xiajia(wangMing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("网吧开始营业了....");
        WangBa wangBa = new WangBa();
        Thread thread = new Thread(wangBa);
        thread.start();

        wangBa.shangji(1,"路人甲",1);
        wangBa.shangji(3,"路人乙",10);
        wangBa.shangji(2,"路人丙",5);
    }
}
