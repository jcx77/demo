package com.ureport2.demo.custom;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(自定义报表 生成ureport2报表的xml文件)
 * @Param:
 * @return:
 * @Author: zcx
 * @Date: 2020/11/24 18:39
 */
@Component
public class CreateXml {
    //表格头部 字母坐标
    String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    //
    // @Test
    public void test() {
        createReport("");
    }

    //
    public List<Map<String, Object>> loadReportData(String dsName, String datasetName, Map<String, Object> parameters) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map =new HashMap<>();
        map.put("name","张三");
        map.put("sex","男");
        map.put("age","18");
        list.add(map);
        Map<String, Object> map1 =new HashMap<>();
        map1.put("name","李四");
        map1.put("sex","男");
        map1.put("age","20");
        list.add(map1);
        Map<String, Object> map2 =new HashMap<>();
        map2.put("name","tom");
        map2.put("sex","男");
        map2.put("age","222");
        list.add(map2);
        return list;
    }
    /**
     * @Description: TODO(创建报表xml文件 ， 前台直接打开指定报表文件即可 。
     *加载数据方式为bean加载 ， 创建xml时需定义sql ， 在bean load方法中读取sql加载对饮数据)
     * $('#ii').attr('src', "../../../../ureport/preview?_u=" + id + "&" + $('#fm').serialize());
     * @Param: [file]
     * @return: void
     * @Author: zcx
     * @Date: 2020/11/24 18:47
     */

    public void createReport(String file) {
        Document doc = getDocumentByXml();
        //创建xml根部
        Element root = doc.addElement("ureport");
        //获取列头
        List<String> colList = getColList();

        //报表name坐标  列坐标  行坐标
        int length = 0, colLength = 1, rowLength = 1;
        for (String s : colList) {
            Element cell = addCell(root, "None", getName(length++) + rowLength, 1, colLength++, null, null);
            addCellStyle(cell);
            addSimpleValue(cell, s);
        }
        length = 0;
        colLength = 1;
        rowLength ++;
        //获取字段
        List<String> zdList = getZd();
        for (String s : zdList) {
            Element cell = addCell(root, "Down", getName(length++) + rowLength, 2, colLength++, null, null);
            addCellStyle(cell);
            addDatasetValue(cell,"a","group",s);
        }
        addPaper(root);
        for (int i = 1; i <= rowLength; i++) {
            // (i != rowLength) {
                addRow(root, i + "", null);
            //} else {
                //addRow(root, i + "", "summary");
            //}
        }
        for (int i = 1; i < colLength; i++) {
            addColumn(root, i + "");
        }
        //
        //数据集 拼接
        Element dataset = addDatasource(root, "a");
        for (String s : zdList) {
            addField(dataset, s);
        }

        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            FileOutputStream fos = new FileOutputStream("D:/3600/11.xml");
            XMLWriter xw = new XMLWriter(fos,format);
            xw.setEscapeText(false);
            xw.write(doc);
            xw.flush();
            xw.close();

        } catch (IOException e) {

        }
    }

    /**
     * @Description: TODO()
     * @Param: [root, expand (Down)(None), name, row, col，colOrRowSpan 合并行或列，size 合并大小]
     * colOrRowSpan  row-span行合并  col-span列合并
     * @return: org.dom4j.Element
     * @Author: zcx
     * @Date: 2020/11/9 9:05
     */
    public Element addCell(Element root, String expand, String name, int row, int col, String colOrRowSpan, String size) {
        Element cell = root.addElement("cell");
        cell.addAttribute("expand", expand);
        cell.addAttribute("name", name);
        cell.addAttribute("row", row + "");
        cell.addAttribute("col", col + "");
        if (colOrRowSpan != null) {
            cell.addAttribute(colOrRowSpan, size);
        }
        return cell;
    }

    /**
     * @Description: TODO(添加边框线)
     * @Param: []
     * @return: void
     * @Author: zcx
     * @Date: 2020/11/12 10:34
     */
    public void addBorder(Element cellStyle) {
        cellStyle.addElement("left-border").addAttribute("width", ReportConstant.BORDER_WIDTH).addAttribute("style", "solid").addAttribute("color", ReportConstant.BORDER_COLOR);
        cellStyle.addElement("right-border").addAttribute("width", ReportConstant.BORDER_WIDTH).addAttribute("style", "solid").addAttribute("color", ReportConstant.BORDER_COLOR);
        cellStyle.addElement("top-border").addAttribute("width", ReportConstant.BORDER_WIDTH).addAttribute("style", "solid").addAttribute("color", ReportConstant.BORDER_COLOR);
        cellStyle.addElement("bottom-border").addAttribute("width", ReportConstant.BORDER_WIDTH).addAttribute("style", "solid").addAttribute("color", ReportConstant.BORDER_COLOR);
    }

    /**
     * @Description: TODO(添加style样式)
     * @Param: [cell]
     * @return: void
     * @Author: zcx
     * @Date: 2020/11/12 11:00
     */
    public void addCellStyle(Element cell) {
        Element cellStyle = cell.addElement("cell-style");
        cellStyle.addAttribute("font-size", ReportConstant.FONT_SIZE);
        cellStyle.addAttribute("align", "center");
        cellStyle.addAttribute("valign", "middle");
        addBorder(cellStyle);
    }

    public void addSimpleValue(Element cell, String value) {
        cell.addElement("simple-value").setText("<![CDATA[" + value + "]]>");
    }

    public void addExpressionValue(Element cell, String value) {
        cell.addElement("expression-value").setText(value);
    }

    /**
     * @Description: TODO()
     * @Param: [cell , datasetname , aggregate (条件), property 代码]
     * @return: void
     * @Author: zcx
     * @Date: 2020/11/9 9:51
     */
    public void addDatasetValue(Element cell, String datasetname, String aggregate, String property) {
        if ("".equals(aggregate) || null == aggregate) {
            aggregate = "group";
        }
        Element dataset = cell.addElement("dataset-value");
        dataset.addAttribute("dataset-name", datasetname);
        dataset.addAttribute("aggregate", aggregate);
        dataset.addAttribute("property", property);
        dataset.addAttribute("order", "none");
        dataset.addAttribute("mapping-type", "simple");
    }

    public void addPaper(Element root) {
        root.addElement("paper").addAttribute("type", "A4").addAttribute("orientation", "portrait").addAttribute("paging-mode", "fitpage");
    }

    /**
     * @Description: TODO(添加数据源)
     * @Param: [root, datasetname]
     * @return: org.dom4j.Element
     * @Author: zcx
     * @Date: 2020/11/12 13:21
     */
    public Element addDatasource(Element root, String datasetname) {
        Element datasource = root.addElement("datasource");
        datasource.addAttribute("name", "数据源");
        datasource.addAttribute("type", "spring");
        datasource.addAttribute("bean", "createXml");

        Element dataset = datasource.addElement("dataset");
        dataset.addAttribute("name", datasetname);
        dataset.addAttribute("type", "bean");
        dataset.addAttribute("method", "loadReportData");
        dataset.addAttribute("clazz", "");
        return dataset;
    }

    /**
     * @Description: TODO(添加字段信息)
     * @Param: [dataset, dm]
     * @return: void
     * @Author: zcx
     * @Date: 2020/11/12 13:21
     */
    public void addField(Element dataset, String dm) {
        dataset.addElement("field").addAttribute("name", dm);
    }

    public void addRow(Element root, String rowNumber, String bandValue) {
        Element row = root.addElement("row");
        row.addAttribute("row-number", rowNumber);
        row.addAttribute("height", ReportConstant.ROW_HIGHT);
        if (bandValue != null) {
            row.addAttribute("band", bandValue);
        }
    }

    public void addColumn(Element root, String colNumber) {
        Element column = root.addElement("column");
        column.addAttribute("col-number", colNumber);
        column.addAttribute("width", ReportConstant.COLUMN_WIDTH);
    }

    /**
     * @Description: TODO(计算列头坐标)
     * @Param: [length]
     * @return: java.lang.String
     * @Author: zcx
     * @Date: 2020/11/9 10:00
     */
    public String getName(int length) {
        StringBuilder sb = new StringBuilder(3);
        if (length > 25) {
            sb.append(getName((length - 26) / 26));
        }
        sb.append(letter[length % 26]);
        return sb.toString();
    }



    /**
     * @Description: TODO(根据xml获取Document对象)
     * @Param: [xml]
     * @return: org.dom4j.Document
     * @Author: zcx
     * @Date: 2020/11/16 10:59
     */
    public Document getDocumentByXml() {
        Document doc;
        try {
            doc = DocumentHelper.createDocument();
        } catch (Exception e) {
            doc = null;
        }
        return doc;
    }

    public List<String> getColList() {
        List<String> collist = new ArrayList();
        collist.add("姓名");
        collist.add("性别");
        collist.add("年龄");
        return collist;
    }
    public List<String> getZd(){
        List<String> zdlist = new ArrayList();
        zdlist.add("name");
        zdlist.add("sex");
        zdlist.add("age");
        return zdlist;
    }
}
