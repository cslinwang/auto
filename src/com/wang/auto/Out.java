package com.wang.auto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Out {
	public void out(String[] tableNameArray, String[] keywordNameArray) {
		BufferedWriter out = null;
		try {
			File writename = new File("D:\\adminnew.txt"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
			writename.createNewFile(); // �������ļ�
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
				out.close(); // ���ǵùر��ļ�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
