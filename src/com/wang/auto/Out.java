package com.wang.auto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Out {
	public void out(String[] tableNameArray, String[] keywordNameArray) {
		BufferedWriter out = null;
		try {
			File writename = new File("D:\\adminnew.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			writename.createNewFile(); // 创建新文件
			out = new BufferedWriter(new FileWriter(writename));
			for (String t : tableNameArray ) {
				out.write("create table " + t + "(\r\n" + "a int(10), "
						+ "\r\n" + "b varchar(500), " + "\r\n" + ")\r\n\r\n");
				for (String k : keywordNameArray){
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close(); // 最后记得关闭文件
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
