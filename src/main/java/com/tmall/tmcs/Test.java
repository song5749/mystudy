package com.tmall.tmcs;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaokun.sanjie on 2016/12/27.
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Object> paramsMap = new HashMap<String,Object>();
        paramsMap.put("userId",1224);
        paramsMap.put("aearId",1234);
        System.out.println(JSON.toJSONString(paramsMap));
    }
}
