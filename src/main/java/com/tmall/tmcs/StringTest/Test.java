package com.tmall.tmcs.StringTest;

import org.apache.commons.lang3.StringUtils;

public class Test {

    public static void main(String[] args) {
        String s ="crowdIds:1519#3B11城-高消费流失人群$$tmcs$$NULL$$100#3A1721#3B北京流失人群1112$$tmcs$$NULL$$100";

       String crowId =  crowIdFeatureParse(s);
        System.out.printf(crowId);
    }

    private static String crowIdFeatureParse(String crowIdFeature) {
        String crowId = "";
        String[] crowIdFeatureArray = crowIdFeature.split("#");
        if (crowIdFeatureArray != null && crowIdFeatureArray.length > 0) {

            String crowId1 = crowIdFeatureArray[0];
            String[] crowIdArray1 = crowId1.split(":");
            if (crowIdArray1 != null && crowIdArray1.length > 0) {
                crowId += crowIdArray1[1] + ",";
            }
            for (int i = 1; i < crowIdFeatureArray.length; i++) {
                if (crowIdFeatureArray[i].contains("3A")) {
                    crowId += (crowIdFeatureArray[i].replace("3A", "") + ",");
                }
            }

        }
        if (StringUtils.isNotBlank(crowId)) {
            crowId = crowId.substring(0, crowId.length() - 1);
        }

        return crowId;

    }
}
