package com.tmall.tmcs.thread.thread004;

/**
 * Created by Administrator on 2016/9/17.
 *
 * 对于对象的同步和异步的方法，我们在设计自己的程序的时候，一定要考虑问题的整体，不然就会出现数据不一致的错误，很经典的错误就是脏读

 * 示例总结：在我们队一个对象的方法进行枷锁*的时候，需要考虑业务的整体性，即为 setvalue/getvalue方法不是加锁synchroinized同步关键字，
 * 保证业务（service的原子性），不然就会出现业务错误（也从侧面保证业务的一致性）
 *
 */
public class DirtyRead {

    private String userName = "ssk";
    private String passWord = "123456";

    public synchronized void setValue(String userName,String passWord){
        this.userName = userName;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.passWord = passWord;
        System.out.println("setValue usrName is "+userName +",passWord is "+passWord);
    }


    public void getValue(){
        System.out.println("getValue usrName is "+this.userName +",passWord is "+this.passWord);
    }

    public static void main(String[] args) throws InterruptedException {
        DirtyRead dirtyRead = new DirtyRead();


        Thread thread = new Thread(() ->{
            dirtyRead.setValue("ghb","456");
        });

        thread.start();
        Thread.sleep(1000);
        dirtyRead.getValue();
    }
}
