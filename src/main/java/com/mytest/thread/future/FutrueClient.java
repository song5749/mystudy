package com.mytest.thread.future;

/**
 * Created by Administrator on 2017/12/4.
 */
public class FutrueClient {
    public Data request(final String request){
        final FutureData futureData = new FutureData();

        new Thread(()->{
            RealData realData = new RealData(request);
            futureData.setRealData(realData);
        }).start();

        return futureData;
    }

}
