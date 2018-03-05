package com.tmall.tmcs.thread.future;

/**
 * Created by Administrator on 2017/12/4.
 */
public class RealData implements Data {

    private String result;


    public  RealData(String request){
        System.out.println("根据"+request+"进行查询，这是一个耗时的操作");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完成，获得查询结果");
        result = "这个是就是查询结果了";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
