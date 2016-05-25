package com.wang.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @author Snow 简单的写入 excel HSSF实现 excel 2003(以 .xls 结尾的文件) XSSF实现 excel 2007(以
 *         .xlsx 结尾的文件)
 */
public class XLSWriter {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> list = XLSReader
				.readExcelData("C:/Users/bairong12/Desktop/test.xlsx");
		// 创建工作薄
		System.out.println(list.toString() + "" + list.size());
		FileInputStream fis = new FileInputStream(
				"C:/Users/bairong12/Desktop/test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(1);
			cell.setCellValue(list.get(i-1));
		}
		FileOutputStream fio = new FileOutputStream("C:/Users/bairong12/Desktop/test1.xlsx");
		wb.write(fio);
		fio.flush();
		fio.close();
		System.out.println("success");
	}
}