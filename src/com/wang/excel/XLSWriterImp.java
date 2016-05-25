package com.wang.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSWriterImp {
	public static void XLSWriterImp(String urlR, String urlW, int location)
			throws Exception {
		// 获取备表的name和apicode
		ArrayList<Integer> apiCode = XLSReaderImp.readExcel(urlR);
		ArrayList<String> name = XLSReaderImp.readExcel1(urlR);
		// 打开待写入表
		FileInputStream fis = new FileInputStream(urlW);
		// 打开工作簿
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// 打开表
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			//第几列
			Cell cell = row.getCell(4);
			int apiCode1 = (int) cell.getNumericCellValue();
			int m = 0;
			System.out.println(apiCode1);
			// 判断name
			for (int j = 0; j < name.size(); j++) {
				if (apiCode1 == apiCode.get(j)) {
					System.out.println("匹配成功:" + m);
					break;
				}
				m++;
				//System.out.println(m);
			}
			System.out.println(m);
			System.out.println("apicode:" + apiCode1 + "    状态:" + name.get(m));
			cell = row.createCell(6);
			cell.setCellValue(name.get(m));
			System.out.println("a");
		}
		FileOutputStream fio = new FileOutputStream(urlW);
		wb.write(fio);
		fio.flush();
		fio.close();
	}
}
