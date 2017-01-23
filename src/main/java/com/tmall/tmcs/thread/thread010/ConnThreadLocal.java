package com.tmall.tmcs.thread.thread010;

/**
 * Created by shaokun.sanjie on 2016/12/12.
 */
public class ConnThreadLocal {
    public   ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void  setThreadLocal(String value){
        threadLocal.set(value);
    }

    public String getThreadLocal() {
        return threadLocal.get();
    }

    public static void main(String[] args) throws  Exception{
        ConnThreadLocal connThreadLocal = new ConnThreadLocal();

        Thread thread1 = new Thread(()->{
            connThreadLocal.setThreadLocal("zhangsan");
            System.out.println(Thread.currentThread().getName()+":" +connThreadLocal.getThreadLocal());
        },"t1");

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":" +connThreadLocal.getThreadLocal());

        },"t2");
        thread1.start();
        thread2.start();
    }
}
