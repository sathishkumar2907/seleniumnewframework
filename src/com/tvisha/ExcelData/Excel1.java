package com.tvisha.ExcelData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel1 {
	public String filepath;
	public String filename;
	public FileInputStream filein=null;
	private XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
   
	public Excel1(String filepath,String sheetname) throws IOException{
		filein=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(filein);
		sheet=workbook.getSheet(sheetname);
	 }
	
	
	public int rowcount(){
		int row=sheet.getLastRowNum() + 1;
		return row;
	} 
	
	public int coloumncount(){
		return sheet.getRow(0).getLastCellNum();
	}
	
	
	public String getCelldata(int row1,int cell1){
		
		cell=sheet.getRow(row1).getCell(cell1);
		String data=cell.getStringCellValue();
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
   }
