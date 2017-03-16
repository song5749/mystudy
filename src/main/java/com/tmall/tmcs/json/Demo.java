package com.tmall.tmcs.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaokun.sanjie on 2017/2/28.
 */
public class Demo {

    private DataSourceProfile dataSourceProfile;

    private DataDetialProfile dataDetialProfile;


    public Demo() {
        dataSourceProfile = new DataSourceProfile();
        dataDetialProfile = new DataDetialProfile();
    }

    public DataSourceProfile getDataSourceProfile() {
        return dataSourceProfile;
    }

    public void setDataSourceProfile(DataSourceProfile dataSourceProfile) {
        this.dataSourceProfile = dataSourceProfile;
    }

    public DataDetialProfile getDataDetialProfile() {
        return dataDetialProfile;
    }

    public void setDataDetialProfile(DataDetialProfile dataDetialProfile) {
        this.dataDetialProfile = dataDetialProfile;
    }

    class DataSourceProfile{
        private String dataSourceProject;
        private String dataSourceTable;


        public String getDataSourceProject() {
            return dataSourceProject;
        }

        public void setDataSourceProject(String dataSourceProject) {
            this.dataSourceProject = dataSourceProject;
        }

        public String getDataSourceTable() {
            return dataSourceTable;
        }

        public void setDataSourceTable(String dataSourceTable) {
            this.dataSourceTable = dataSourceTable;
        }
    }

    class DataDetialProfile{
        private String dataDetialProject;
        private String dataDetialTable;

        public String getDataDetialProject() {
            return dataDetialProject;
        }

        public void setDataDetialProject(String dataDetialProject) {
            this.dataDetialProject = dataDetialProject;
        }

        public String getDataDetialTable() {
            return dataDetialTable;
        }

        public void setDataDetialTable(String dataDetialTable) {
            this.dataDetialTable = dataDetialTable;
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        demo.dataSourceProfile.setDataSourceProject("tmcs_data_driven_operations");
        demo.dataSourceProfile.setDataSourceTable("dim_tmcs_byr_last_curr_month_state");

        System.out.println(JSON.parseObject(JSON.toJSONString(demo)));

                System.out.println(  JSON.parseObject(JSON.toJSONString(demo),Demo.class));



    }
}
