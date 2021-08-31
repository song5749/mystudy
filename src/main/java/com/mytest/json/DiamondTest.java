package com.mytest.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @Auther: shaokun.ssk
 * @Date: 2019/1/24 16:28
 * @Description:
 */
public class DiamondTest {


    public static void main(String[] args) {
        String str = "{\n" +
                "    \"com.taobao.item.switcher.IcAppSwitcher\":{\n" +
                "    \t\"enableItemCache\":true,\n" +
                "        \"enableIpmInterface\": true,\n" +
                "        \"useTrunkTableWhenMissingCache\":true,\n" +
                "        \"enableGenerateInnerId\": true,\n" +
                "        \"enableMultiSouringQuery\":true,\n" +
                "        \"enableGroupCache\":true,\n" +
                "        \"enableGpuCache\":true,\n" +
                "        \"enableSkuRelatedMappingCache\":true,\n" +
                "        \"enableItemPublishMessage\":true,\n" +
                "        \"disableOvlSellerUpShelf\":true,\n" +
                "        \"freeQcTestSellers\":[1524,100000329,100000312, 100032900,100000313,100000315,100000316,100000317,100000318,100000319,100000320,100000321,100000322,100000323,100000324,100000325,100000326,100000327,100000328,100000329,100032900,100047849,100052929,1114],\n" +
                "    \t\"writeFixAttrToDB\":true,\n" +
                "        \"enableBuyerMonitor\":true,\n" +
                "        \"enableImageUrlProcessBeforeSave\":true,\n" +
                "        \"ventureImageDomains\":[\"sg-live.slatic.net\",\"sg-live-01.slatic.net\",\"sg-live-02.slatic.net\",\"sg-live-03.slatic.net\"],\n" +
                "        \"supportHttpsExternaDomains\":[\n" +
                "        \"img04.taobaocdn.com\"\n" +
                "        ,\"img03.taobaocdn.com\"\n" +
                "        ,\"img02.taobaocdn.com\"\n" +
                "        ,\"img01.taobaocdn.com\"\n" +
                "        ,\"img.taobaocdn.com\"\n" +
                "        ,\"img.alicdn.com\"\n" +
                "        ,\"gd4.alicdn.com\"\n" +
                "        ,\"gd3.alicdn.com\"\n" +
                "        ,\"gd2.alicdn.com\"\n" +
                "        ,\"gd1.alicdn.com\"\n" +
                "        ,\"gaitaobao4.alicdn.com\"\n" +
                "        ,\"gaitaobao3.alicdn.com\"\n" +
                "        ,\"gaitaobao2.alicdn.com\"\n" +
                "        ,\"gaitaobao1.alicdn.com\"\n" +
                "        ,\"g04.a.alicdn.com\"\n" +
                "        ,\"g03.a.alicdn.com\"\n" +
                "        ,\"g02.a.alicdn.com\"\n" +
                "        ,\"g01.a.alicdn.com\"\n" +
                "        ,\"g.search3.alicdn.com\"\n" +
                "        ,\"g.search2.alicdn.com\"\n" +
                "        ,\"g.search1.alicdn.com\"\n" +
                "        ,\"g.search.alicdn.com\"\n" +
                "        ,\"cbu01.alicdn.com\"\n" +
                "        ,\"ae01.alicdn.com\"\n" +
                "        ,\"my-test-11.slatic.net\"\n" +
                "        ,\"th-test-11.slatic.net\"\n" +
                "        ,\"vn-test-11.slatic.net\"\n" +
                "        ,\"ph-test-11.slatic.net\"\n" +
                "        ,\"id-test-11.slatic.net\"\n" +
                "        ],\n" +
                "        \"centFactor\":100\n" +
                "    }\n" +
                "}";

        Map<String, Map<String, String>> strMap = JSON.parseObject(str, Map.class);


        //"com.taobao.item.switcher.IcAppSwitcher.enableSkuRelatedMappingCache":"true"
        strMap.entrySet().stream().forEach(x ->{
          String key =  x.getKey();

            Map<String, String> mapValue =  x.getValue();
            mapValue.entrySet().stream().forEach( y ->{
                System.out.println(",\"com.taobao.item.switcher.IcAppSwitcher."+y.getKey()+"\""+":\""+String.valueOf(y.getValue()).replace("\"","\\\"")+"\"");
            });
        });

    }
}
