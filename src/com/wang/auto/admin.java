package com.wang.auto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class admin {
	public static void main(String[] args) {
		try { 
			
			String pathname = "D:\\table\\tableName.txt"; 
			File filename = new File(pathname); 
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
			BufferedReader br = new BufferedReader(reader);
			
			String line = br.readLine();
			while (line != null) {
				String str =line.replaceFirst(line.substring(0, 1), line.substring(0, 1).toUpperCase()) ;
				System.out.println(str);
				File writename = new File("D:\\table\\table\\br_" + line +".txt");
				
				writename.createNewFile(); 
				
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}