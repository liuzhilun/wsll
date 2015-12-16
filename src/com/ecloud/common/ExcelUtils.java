
package com.ecloud.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelUtils {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    int writeLine = 1;

    /**
     * 字号
     */
    private static final int FONT_SIZE = 8;

    /**
     * 导出到excel文件，默认的sheet名称
     */
    private static final String DEFAULT_SHEET_NAME = "Sheet1";

    /**
     * 列宽
     */
    private static final int WIDTH_COL = 16;
    
    public static void main(String[] args) {
    	String[] title = { "第1列", "第2列", "第3列" };
    	List<String[]> contents = new ArrayList<String[]>();
    	for (int i = 0; i < 10; i ++) {
    		contents.add(new String[] {"第" + i + "行第1列", "第" + i + "行第2列", "第" + i + "行第3列"});
    	}
		new ExcelUtils().exportToExcel(title, contents);
	}
    
    /**
     * 
     * @description 将数据导出为excel文件
     *
     * @author chj
     * @date 2013-2-19
     * @time 上午11:38:38
     * 
     * @param titles 表头
     * @param contents 表内容
     * @return 导出的excel文件
     */
    public File exportToExcel(String[] titles, List<String[]> contents) {
    	WritableWorkbook workbook = null;
    	File tempDir = new File("download");
    	if (!tempDir.exists()){
    		tempDir.mkdirs();
    	}
    	// 防止文件重名
    	File file = new File(tempDir, "temp" + Calendar.getInstance().getTime().getTime() + ".xls");
        try {
            workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME, 0);
            initGridSize(sheet, titles.length, WIDTH_COL);
            initTitle(sheet, titles);
            if (contents != null && contents.size() > 0) {
            	for (int i = 0; i < contents.size(); i++) {
            		writeLineContent(sheet, contents.get(i));
            	}
            }
			workbook.write();
        } catch (Exception e) {
            System.out.println("类："+Thread.currentThread().getStackTrace()[1].getClassName()+"的"+Thread.currentThread().getStackTrace()[1].getMethodName()+"方法发生异常，相关信息为:"+e.getStackTrace().getClass().getName()+e.getMessage()+",在"+Thread.currentThread().getStackTrace()[1].getLineNumber()+"行；");
        } finally {
            closeWritableWorkbook(workbook);
        }
        return file;
    }
    
    /**
     * 
     * @description 将数据导出为excel文件
     *
     * @author chj
     * @date 2013-2-19
     * @time 下午01:31:20
     * 
     * @param titles 表头
     * @param contents 表内容
     * @return 导出的excel文件
     */
    public File exportToExcel(List<String> titles, List<List<String>> contents) {
    	WritableWorkbook workbook = null;
    	File tempDir = new File("download");
    	if (!tempDir.exists()){
    		tempDir.mkdirs();
    	}
    	// 防止文件重名
    	File file = new File(tempDir, "temp" + Calendar.getInstance().getTime().getTime() + ".xls");
    	try {
    		workbook = Workbook.createWorkbook(file);
    		WritableSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME, 0);
    		initGridSize(sheet, titles.size(), WIDTH_COL);
    		String[] titleTemp = (String[]) titles.toArray();
    		initTitle(sheet, titleTemp);
    		if (contents != null && contents.size() > 0) {
    			for (int i = 0; i < contents.size(); i++) {
    				writeLineContent(sheet, contents.get(i));
    			}
    		}
    		workbook.write();
    	} catch (Exception e) {
    		System.out.println("类："+Thread.currentThread().getStackTrace()[1].getClassName()+"的"+Thread.currentThread().getStackTrace()[1].getMethodName()+"方法发生异常，相关信息为:"+e.getStackTrace().getClass().getName()+e.getMessage()+",在"+Thread.currentThread().getStackTrace()[1].getLineNumber()+"行；");
    	} finally {
    		closeWritableWorkbook(workbook);
    	}
    	return file;
    }

    /**
     * 把告警信息写入excel表
     * 
     * @param excel
     * @param trapList
     * @return
     */
    public boolean exportToExcel(String userName, File excel) {
        WritableWorkbook workbook = null;
        try {
            workbook = Workbook.createWorkbook(excel);
            WritableSheet sheet = workbook.createSheet(DEFAULT_SHEET_NAME, 0);
            initGridSize(sheet);
            initTitle(sheet, new String[] { userName, "", ""});
            initTitle(sheet, new String[] { "第1列", "第2列", "第3列", "第4列", "第5列", "第6列", "第7列" });
            String[] values = new String[] { "1", "2", "3", "4", "5", "6", "7", };
            writeLineContent(sheet, values);
            workbook.write();
        } catch (Exception e) {
            return false;
        } finally {
            closeWritableWorkbook(workbook);
        }
        return true;
    }

    private void closeWritableWorkbook(WritableWorkbook rwb) {
        if (null != rwb) {
            try {
                rwb.close();
            } catch (WriteException e) {
                logger.warn("can not close the excel workbook", e);
            } catch (IOException e) {
                logger.warn("can not close the excel workbook", e);
            }
        }
    }
    
    

    /**
     * 初始化表格尺寸
     * 
     * @param sheet
     * @throws RowsExceededException
     */
    private static void initGridSize(WritableSheet sheet) throws RowsExceededException {

        sheet.setColumnView(0, WIDTH_COL);
        sheet.setColumnView(1, WIDTH_COL);
        sheet.setColumnView(2, WIDTH_COL);
        sheet.setColumnView(3, WIDTH_COL);
        sheet.setColumnView(4, WIDTH_COL);
        sheet.setColumnView(5, WIDTH_COL);
        sheet.setColumnView(6, WIDTH_COL);
        sheet.setColumnView(7, WIDTH_COL);
        sheet.setColumnView(8, WIDTH_COL);
        sheet.setColumnView(9, WIDTH_COL);
        sheet.setColumnView(10, WIDTH_COL);
    }
    
    /**
     * 
     * @description
     *
     * @author chj
     * @date 2013-2-19
     * @time 上午11:06:42
     * 
     * @param sheet excel表
     * @param colSize 列数
     * @param width 列宽
     * @throws RowsExceededException
     */
    private static void initGridSize(WritableSheet sheet, int colSize, int width) throws RowsExceededException {
    	for (int i = 0; i < colSize; i++) {
			sheet.setColumnView(i, width);
		}
    }

    /**
     * 初始化标题栏
     * 
     * @param sheet
     * @throws WriteException
     * @throws RowsExceededException
     */
    private void initTitle(WritableSheet sheet, String[] titles) throws WriteException {
        WritableCellFormat wcf = getCellTitleFormat();
        int i = 0;
        for (String title : titles) {
            sheet.addCell(new Label(i, writeLine, title, wcf));
            i++;
        }
        writeLine += 2;

    }

    /**
     * 获得标题栏格式
     * 
     * @return
     * @throws WriteException
     */
    private WritableCellFormat getCellTitleFormat() throws WriteException {
        WritableCellFormat wcf = getBasicCellFormat();
        wcf.setBackground(Colour.GREY_25_PERCENT);
        return wcf;
    }

    /**
     * 初始化单元格基本格式
     * 
     * @param wcf_center
     * @throws WriteException
     */
    private WritableCellFormat getBasicCellFormat() throws WriteException {
        WritableCellFormat wcf = new WritableCellFormat();
        WritableFont font = new WritableFont(WritableFont.ARIAL, FONT_SIZE);
        wcf.setFont(font);
        wcf.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条
        wcf.setVerticalAlignment(VerticalAlignment.CENTRE); // 垂直对齐
        wcf.setAlignment(Alignment.CENTRE);
        wcf.setWrap(true); // 是否换行
        return wcf;
    }

    /**
     * 向excel表格中写入一行内容
     * 
     * @param userList
     * @param sheet
     * @throws WriteException
     * @throws RowsExceededException
     */
    private void writeLineContent(WritableSheet sheet, String[] values) throws WriteException {
        WritableCellFormat wcf = getBasicCellFormat();
        int i = 0;
        for (String value : values) {
            sheet.addCell(new Label(i, writeLine, value, wcf));
            i++;
        }
        if (values.length<=1) {
    		sheet.mergeCells(0, writeLine, sheet.getColumns()-1, writeLine); // 合并单元格  
		}
        writeLine = writeLine + 1;
    }
    
    /**
     * 
     * @description 向excel表格中写入一行内容
     *
     * @author chj
     * @date 2013-2-19
     * @time 下午01:29:45
     * 
     * @param sheet
     * @param values
     * @throws WriteException
     */
    private void writeLineContent(WritableSheet sheet, List<String> values) throws WriteException {
    	WritableCellFormat wcf = getBasicCellFormat();
    	int i = 0;
    	for (String value : values) {
    		sheet.addCell(new Label(i, writeLine, value, wcf));
    		i++;
    	}
    	writeLine = writeLine + 1;
    }
}
