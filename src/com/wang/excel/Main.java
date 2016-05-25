package com.wang.excel;

public class Main {
	public static void main(String[] args) throws Exception {
		// name和apicode存放文件
		String oldA = "sheet1";
		String oldB = "sheet1";
		String newA = "sheet1";
		String newB = "sheet1";
		// 待读取读取文件位置
		String urlR = "C:/Users/bairong12/Desktop/work/王林.xlsx";
		// 待写入文件位置
		String urlW = "C:/Users/bairong12/Desktop/测试/王林1.xlsx";
		// 待写入表位置
		int location = 6;

		XLSWriterImp.XLSWriterImp(urlR, urlW, location);
		// XLSReader.readExcelData(urlR);
	}
}
