package com.tmall.tmcs.excel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sun.reflect.generics.tree.Tree;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * Created by shaokun.sanjie on 2017/6/10.
 */
public class SendCounp618Util {

    public static void main(String[] args) throws Exception {
        InputStream excelFile = new FileInputStream("E:/发券生成测试.xlsx");

        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(excelFile);
        } catch (Exception ex) {
            wb = new HSSFWorkbook(excelFile);
        }
        Sheet counturySheet =  wb.getSheet("全国优惠券");
        Sheet citySheet =  wb.getSheet("城市优惠券");

        getAllJson(counturySheet);
        getAllJson(citySheet);

    }

    private static void getAllJson(Sheet sheet) throws Exception {
        Iterator<Row> IterableCell =  sheet.iterator();

        List<BenefitExcel> counturylist = Lists.newArrayList();
        while (IterableCell.hasNext()){

            String date = null;
            String benefitName = null;
            String benefitId = null;
            String benefitType = null;

            Row row = IterableCell.next();
            System.out.println(row.getRowNum());
            if(row.getRowNum() == 0){
                continue;
            }

            for (int i = 0; i <4 ; i++) {
                Cell cell =  row.getCell(i);
                if(cell == null){
                    continue;
                }
                if(i == 0){
                    date = cell.getStringCellValue().toString();


                }
                if(i == 1){
                    benefitName = cell.getStringCellValue().toString();
                }
                if(i == 2){

                    try {
                        benefitId =   cell.getNumericCellValue()+"";
                    } catch (Exception e) {
                        benefitId =   cell.getStringCellValue();

                    }
                    System.out.println(benefitId);
                    if(benefitId.contains(".0")){
                        benefitId = benefitId.substring(0,benefitId.length()-2);
                    }

                }
                if(i == 3){
                    try {
                        benefitType =   cell.getNumericCellValue()+"";
                    } catch (Exception e) {
                        benefitType =   cell.getStringCellValue();

                    }
                    if(benefitType.contains(".0")){
                        benefitType = benefitType.substring(0,benefitType.length()-2);
                        System.out.println(benefitType);
                    }


                }

            }
            if(StringUtils.isBlank(date) || StringUtils.isBlank(benefitName) || StringUtils.isBlank(benefitId)  || StringUtils.isBlank(benefitType)){
                continue;
            }

            if((benefitName.contains("超市购物券") && Integer.parseInt(benefitType) !=0 )
                    || (benefitName.contains("母婴购物券") && Integer.parseInt(benefitType) !=2 )
                    || (benefitName.contains("生鲜购物券") && Integer.parseInt(benefitType) !=1 )){
                throw new Exception("名称和类型不匹配，请检查");
            }
            BenefitExcel benefitExcel = new BenefitExcel(date,Long.parseLong(benefitId),Integer.parseInt(benefitType));


            counturylist.add(benefitExcel);
        }

        Map<String, List<BenefitExcel>> map = counturylist.stream().sorted((x,y) ->{
            return  x.getBenefitType().compareTo(y.getBenefitType());
        }).collect(Collectors.groupingBy(BenefitExcel::getData));

        TreeMap<String, List<BenefitExcel>>  treeMap = new TreeMap<String, List<BenefitExcel>>(map);
        System.out.println(JSON.toJSONString(treeMap));
    }


    static class BenefitExcel{
       @JSONField(serialize=false)
        private String data;
        private Long benefitId;
        private Integer benefitType;


        public BenefitExcel() {
        }

        public BenefitExcel(String data, long benefitId, int benefitType) {
            this.data = data;
            this.benefitId = benefitId;
            this.benefitType = benefitType;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Long getBenefitId() {
            return benefitId;
        }

        public void setBenefitId(Long benefitId) {
            this.benefitId = benefitId;
        }

        public Integer getBenefitType() {
            return benefitType;
        }

        public void setBenefitType(Integer benefitType) {
            this.benefitType = benefitType;
        }
    }


}


