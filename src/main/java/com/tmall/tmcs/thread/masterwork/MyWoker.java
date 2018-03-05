package com.tmall.tmcs.thread.masterwork;

/**
 * Created by Administrator on 2017/12/6.
 */
public class MyWoker extends  Worker{


    public static Object handle(Task input) {
        Object output = null;

        try {
            Thread.sleep(500);
            output = input.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  output;
    }

}
