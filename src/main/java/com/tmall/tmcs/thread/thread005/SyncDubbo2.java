package com.tmall.tmcs.thread.thread005;

/**
 * Created by Administrator on 2016/9/17.
 */
public class SyncDubbo2 {

  static class Main{
      public int i = 10;

      public synchronized  void operationSup(){

          try {

              i--;
              System.out.println("Main print i = "+i);
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }

  }

  static  class  Sub extends  Main{
      public synchronized void operationSub(){
        try {
            while (i > 0){
                i--;
                System.out.println("Sub print i = "+i);
                Thread.sleep(1000);
                this.operationSup();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

      }
  }

    public static void main(String[] args) {
        Sub sub = new Sub();

        sub.operationSub();
    }
}
