package com.wang.auto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Read {
	public String[] read() {
		String[] tableNameArray = null;
		try {
			String pathname = "D:\\admin.txt";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			String line = br.readLine();
			String tableName = "";
			while (line != null) {
				tableName += line;
				line = br.readLine();
				tableNameArray = tableName.split(",");
				// System.out.println(tableName + "----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableNameArray;
	}
}
