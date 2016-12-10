package com.tmall.tmcs.thread.thread002;

/**
 * Created by Administrator on 2016/8/13.
 *
 * 对象级别的锁  每一个对象都拥有自己的一把锁
 * 当对象中的 对象方法 拥有synchronized修饰时 不同的对象会分别争夺自己对象的锁 而不会影响到其他对象方法的执行
 * 当方法为静态方法的时候则它的锁为类锁 不同的线程则会进行锁竞争
 */
public class MulitThread {
//    static
    private static int i = 0;
//static
    public  synchronized void  printNum(String s){
        try {
            if (s.equals("a")){
                i = 100;
                System.out.println("tag a,set num over");
                Thread.sleep(1000L);
            }else{
                i = 200;
                System.out.println("tag b,set num over");
            }
            System.out.println("tag is "+s+ " i : "+i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MulitThread m1 = new MulitThread();

        MulitThread m2 = new MulitThread();

        Thread t1 = new Thread(() ->{
            m1.printNum("a");
        });

        Thread t2 = new Thread(() ->{
            m2.printNum("b");
        });

        t1.start();
        t2.start();
    }

}
