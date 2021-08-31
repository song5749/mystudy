package com.mytest.thread.executor;

public class MyTask implements Runnable {

    private int taskId;

    private String taskName;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public MyTask(int taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("run taskId = "+this.taskId);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.taskId);
    }
}
