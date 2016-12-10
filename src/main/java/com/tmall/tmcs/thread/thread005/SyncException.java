package com.tmall.tmcs.thread.thread005;

/**
 * Created by Administrator on 2016/9/17.
 */
public class SyncException {
    private int i = 100;

    public  synchronized  void operation(){
        while (i >0){
            try {
                i--;
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+",i = "+i);
                if(i == 90){
                    Integer.parseInt("a");
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("log info i = "+i);
            }finally {

            }
        }
    }

    public static void main(String[] args) {
        SyncException syncException = new SyncException();

        new Thread(() -> {
            syncException.operation();
        }).start();
    }
}
