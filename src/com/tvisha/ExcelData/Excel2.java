package com.tvisha.ExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {

	public static Object[][]  hashtable(String file_path,String sheet_name) throws IOException{
		
		Excel1 ex=new Excel1(file_path, sheet_name);
		
		int ro=ex.rowcount();
		int col=ex.coloumncount();
		
		Object[][] obj=new Object[ro][col];
		Hashtable<String,String> has=null;
		
		for(int i=0;i<ro;i++){
			for(int j=0;j<col;j++){
				
				has.put(ex.getCelldata(j,0), ex.getCelldata(i, j));
				obj[i][j]=has;	
			}
			
		}
		
			
			return obj;
		
	}
	
	
	
	
	
	
}
