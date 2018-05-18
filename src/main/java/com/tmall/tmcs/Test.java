package com.tmall.tmcs;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tmall.tmcs.thread.thread13.TestA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shaokun.sanjie on 2016/12/27.
 */
public class Test {

    public static void main(String[] args) {
//        Map<String, Object> paramsMap = new HashMap<String,Object>();
//        paramsMap.put("userId",1224);
//        paramsMap.put("aearId",1234);
//        System.out.println(JSON.toJSONString(paramsMap));
        TestA  a = new TestA();
        a.setI(null);

        List<Integer> list  = Lists.newArrayList(1,2);

        Integer i = new Integer(1);

        System.out.println(list.contains(i));

        List<Boolean> list1 = Lists.newArrayList();
        list1.add(false);
        list1.add(true);
        list1.add(false);
        list1.add(true);
        list1.sort((x,y)->{
            System.out.println(x.compareTo(y)+"");
            return x.compareTo(y);
        });

        System.out.printf("list1:"+JSON.toJSONString(list1));

    }


}
