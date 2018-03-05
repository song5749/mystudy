package com.tmall.tmcs.thread.future;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Main {
    public static void main(String[] args) {
        FutrueClient futrueClient = new FutrueClient();
        Data data =   futrueClient.request("我是request请求");
        System.out.println("请求发送成功");
        System.out.println("主线程继续做其他的事情");

        String  result = data.getRequest();

        System.out.println("result");

    }
}
