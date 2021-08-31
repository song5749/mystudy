package com.mytest.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shaokun.sanjie on 2017/6/10.
 */
public class ExcelUtil {


    private HSSFWorkbook getHSSFWorkbookByStringFile(String file) throws IOException {

        InputStream ExcelFileToRead = new FileInputStream(file);

        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

        return wb;
    }

}
