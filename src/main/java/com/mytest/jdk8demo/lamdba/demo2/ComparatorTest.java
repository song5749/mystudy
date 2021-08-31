package com.mytest.jdk8demo.lamdba.demo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shaokun.ssk on 2016/8/8.
 */
public class ComparatorTest {

    public static void main(String[] args) {
        List<String>  list  = new ArrayList<>();
        list.add("dfsf");
        list.add("acvsfdsa");
        list.add("fdsafcxvxzv");
        list.add("vdfdd");
        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = o1.length() - o2.length();
                return length == 0 ? o1.compareTo(o2) : length;
            }
        });
        System.out.println(list);

        List<Integer>  integerList  = new ArrayList<>();
        integerList.add(10);
        integerList.add(1);
        integerList.add(3);
        integerList.add(5);

        integerList.sort((e,x) -> {
            return  -e.compareTo(x);
        });
        System.out.println(integerList);
    }
}
