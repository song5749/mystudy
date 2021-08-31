package com.mytest.thread.thread010;

/**
 * Created by shaokun.sanjie on 2016/12/12.
 *单例多线程的支持   内部类
 */
public class InnerSingletion {
    private static class Singletion{
        private static Singletion singletion = new Singletion();
    }

    public static Singletion getInstance(){
        return Singletion.singletion;
    }
}
