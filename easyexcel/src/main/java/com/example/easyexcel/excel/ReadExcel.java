package com.example.easyexcel.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.example.easyexcel.excel.model.TableTest;
import com.example.easyexcel.excel.tool.DemoDataListener;
import org.junit.Test;

import java.io.*;

public class ReadExcel {

    // 异步读取
    @Test
    public void simpleRead1() {

        ExcelReader excelReader = null;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("D:/3.xlsx"));
            excelReader = EasyExcel.read(in, TableTest.class, new DemoDataListener()).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } catch (Exception e) {

        } finally {
            // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
            excelReader.finish();
        }

    }
}
