package com.tmall.tmcs.queue;

/**
 * Created by Administrator on 2017/7/2.
 */
public class Task implements  Comparable{

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Task taks = (Task)o;
        return this.id > taks.getId() ? 1: (this.id < taks.getId() ? -1 :0);
    }

    @Override
    public String toString() {
        return this.getId()+","+this.getName();
    }
}
