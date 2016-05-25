package com.wang.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSReaderImp {
	public static ArrayList<Integer> readExcel(String url) throws Exception {

		FileInputStream fis = new FileInputStream(url);
		ArrayList<Integer> apiCode = new ArrayList<Integer>();
		Workbook workBook = null;
		try {
			workBook = new XSSFWorkbook(fis);
			int numberOfSheets = workBook.getNumberOfSheets();
			//第几张表
			Sheet sheet = workBook.getSheetAt(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				//第几行
				Row row = sheet.getRow(i);
				//第几列
				Cell cell = row.getCell(4);
				apiCode.add((int) cell.getNumericCellValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiCode;
	}

	public static ArrayList<String> readExcel1(String url) throws Exception {

		FileInputStream fis = new FileInputStream(url);
		ArrayList<String> name = new ArrayList<String>();
		Workbook workBook = null;
		try {
			workBook = new XSSFWorkbook(fis);
			int numberOfSheets = workBook.getNumberOfSheets();
			Sheet sheet = workBook.getSheetAt(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);
				//第几列
				Cell cell = row.getCell(0);
				name.add(cell.getStringCellValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}
}
