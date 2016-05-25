package com.wang.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class admin {
	public static void main(String[] args) {
		BufferedWriter out = null;
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
			String pathname1 = "D:\\table\\tableName.txt";
			File filename1 = new File(pathname1);
			InputStreamReader reader1 = new InputStreamReader(
					new FileInputStream(filename1));
			BufferedReader br1 = new BufferedReader(reader1);
			String line1 = br1.readLine();

			while (line1 != null) {
				/* ����tableName */
				// String line1 = "AccountChangeMonth";
				String pathname = "D:\\table\\table\\br_" + line1 + ".txt";
				File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename)); // ����һ������������reader
				BufferedReader br = new BufferedReader(reader); // ����һ����������ļ�����ת�ɼ�����ܶ���������
				String line = br.readLine();
				File writename = new File("D:\\table\\tableSql\\br_" + line1
						+ ".sql"); // ���·�������û����Ҫ����һ���µ�output��txt�ļ�
				writename.createNewFile(); // �������ļ�
				out = new BufferedWriter(new FileWriter(writename));

				out.write("create table br_" + line1 + " ( \r\n");
				while (line != null) {
					//String str = line.replaceFirst(line.substring(0, 1), line
					//		.substring(0, 1).toUpperCase());
					out.write(" " + line + "" + " varchar(50) default '' ,\r\n");
					// System.out.println(line);
					line = br.readLine();
				}
				out.write("  rowKey varchar(50) not Null default '' primary key )  row_format = dynamic CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'");

				out.flush();
				out.close(); // ���ǵùر��ļ�
				System.out.println("success");
				line1 = br1.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}