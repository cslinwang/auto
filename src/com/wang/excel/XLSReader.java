package com.wang.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel读取
 * 
 * @author Snow HSSF用于2003版即以 .xls结尾 XSSF用于2007版 以 .xlsx结尾
 */
public class XLSReader {
	public static ArrayList<Integer> readExcelData(String url) throws Exception {
		System.out.println("开始读取...");
		// 从XLSX/ xls文件创建的输入流
		FileInputStream fis = new FileInputStream(url);
		List<Object[][]>[][] list = new ArrayList[4][4];
		List oldA = new ArrayList();
		// 创建工作薄Workbook
		Workbook workBook = null;
		// 读取2007版，以 .xlsx 结尾
		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int numberOfSheets = workBook.getNumberOfSheets();
		Sheet sheet = workBook.getSheetAt(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(1);
			oldA.add((int) cell.getNumericCellValue());
		}
		System.out.println("读取结束。");
		return (ArrayList<Integer>) oldA;
	}
}