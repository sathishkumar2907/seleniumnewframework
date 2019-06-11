package com.tvisha.ExcelData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static String filename;
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private static Workbook workbook = null;
	private static Sheet sheet = null;
	private static Row row = null;
	private static Cell cell = null;
	static Hashtable<String, String> hastable;
	
	public ExcelData(String path) {
        this.path = path;
		try {
			
			fis = new FileInputStream(path);
			String fileExtensionName = path.substring(path.indexOf("."));
			
			if(fileExtensionName.equalsIgnoreCase(".xlsx")){
			
			  workbook = new XSSFWorkbook(fis);
			 //sheet = workbook.getSheet(sheetName);
			  fis.close();
			
			}else if(fileExtensionName.equalsIgnoreCase(".xls")){
				
				//fis = new FileInputStream(path);
				workbook = new HSSFWorkbook(fis);
				fis.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
	
		public static int getRowCount(String sheetName) {
           // To verify that Sheet is present or Not
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return 0;
			else {
				sheet = workbook.getSheetAt(index);
            	// To store Last Row Number
				int number = sheet.getLastRowNum()+1;
				//int number = sheet.getLastRowNum()+1 -sheet.getFirstRowNum();
				return number;
			}
        }
		
		
		// returns number of columns in a sheet
		public static int getColumnCount(String sheetName) {
			// check if sheet exists
			
        	sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);

			if (row == null)
				return -1;

			return row.getLastCellNum();

		}
		
		
		//==========All cell and coloumn data
		@SuppressWarnings("deprecation")
		public static String getCellData(String SheetName, int colnum, int rownum){
			try{
			if(rownum<0)  {
				return "";
			}
			// To verify that Sheet is present or Not
			int index = workbook.getSheetIndex(SheetName);
			if(index==-1){
				return "";
			}
			
			sheet=workbook.getSheetAt(index);
			
			row=sheet.getRow(rownum);
			
			if (row == null)
				return "";
			
			cell=row.getCell(colnum);
			
			if (cell == null)
				return "";
			
		
			if(cell.getCellTypeEnum()==CellType.STRING){
				
				return cell.getStringCellValue();
			
			}else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.STRING.FORMULA){
				
				String cellText = String.valueOf(cell.getNumericCellValue());
			
				if(HSSFDateUtil.isCellDateFormatted(cell)){
					double d=cell.getNumericCellValue();
					Calendar cal=Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
			     	}
					return cellText;
			
			}else if(cell.getCellTypeEnum()==  CellType.BLANK){
				return "";
			}else{
				return String.valueOf(cell.getBooleanCellValue());
			}
			
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return "row " + rownum + " or column " + colnum+ " does not exist in xls";
	  	}
		
		
		@SuppressWarnings("deprecation")
		public static String getCellData_col_Name(String sheetName, String celName, int rowNum){
			try{
				
				if(rowNum<0){
					return "";
				}
				
				int index=workbook.getSheetIndex(sheetName);
				if(index==-1){
					return "";
				}
				
				int col_num=0;
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					if(row.getCell(i).getStringCellValue().trim().equals(celName.trim())){
						 col_num = i;
					}
				}
				
				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum);
				if(row==null){
					return "";
				}
				
				cell=row.getCell(col_num);
				if(cell==null){
					return "";
				}
				
				
				
				if(cell.getCellTypeEnum()==CellType.STRING){
				
					return cell.getStringCellValue();
				
				}else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.STRING.FORMULA){
					
					String cellText = String.valueOf(cell.getNumericCellValue());
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						double d=cell.getNumericCellValue();
						Calendar cal=Calendar.getInstance();
						cal.setTime(HSSFDateUtil.getJavaDate(d));
						cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
						
						cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
								
					}
					
					
					return cellText;
				
				}else if(cell.getCellTypeEnum()==  CellType.BLANK){
					
					return "";
					
				}else{
					return String.valueOf(cell.getBooleanCellValue());
				}
				
				
				
			}catch(Exception e){
				e.printStackTrace();
				return "row" + rowNum + " cell Name " + celName +" not exist in xls file "; 
			}
		}
		
	
		
		public static Object[][] getData(String sheetName){
			
			int rows_count=getRowCount(sheetName);
			//int rows_count= sheet.getPhysicalNumberOfRows();
	    	System.out.println("rows_count "+rows_count);
	    	int cell_count = sheet.getRow(0).getPhysicalNumberOfCells();
	    	System.out.println("cell_count "+cell_count);
	    	
	    	int runmode_run=0;
	    	for(int i=1;i<rows_count;i++){
	    		String runmode1= sheet.getRow(i).getCell(0).getStringCellValue();
	    		if(runmode1.equalsIgnoreCase("y")){
	    			runmode_run++;
	    		}
	    	}
	    
	    	Object[][] object1=new Object[runmode_run][cell_count-1];
	    	for(int i=1;i<rows_count;i++){
	    		for(int j=0;j<cell_count;j++){
	    			
	    			object1[i][0]=getCellData(sheetName,0,i);
	    			
	    			//object1[i][j]=_sheet.getRow(i).getCell(0).getStringCellValue();
	    			System.out.println(" object1["+i+"][0]===>" +   object1[i][0]);
	    		 }
	    	}
			return object1;
		}
		
		
		//====================major part
	public static Object[][] hashtableGetData1(String hash_Sheet,String testMode){
		Object data[][]=null;
		int dataIndex =0;	
		// int hash_col=sheet.getRow(0).getLastCellNum();
		  // System.out.println("hash_col "+hash_col);   
		
		int testStartRow=0;
		
		// To find the Row Number from where our Test is being start
		for (int rNum = 1; rNum<= getRowCount(hash_Sheet); rNum++)
		{
			 if (getCellData_col_Name(hash_Sheet, "Runmode", rNum).equalsIgnoreCase(testMode)) 
			 {
				testStartRow ++;
			 }
		}
		// intiailse the object array for only based on runmode
		data = new Object [testStartRow][1];
	  // to start fecth the data
		for (int rNum = 1; rNum<=getRowCount(hash_Sheet); rNum++)
		{
			 if (getCellData_col_Name(hash_Sheet, "Runmode", rNum).equalsIgnoreCase(testMode)) 
			 {
				
				 hastable = new Hashtable<String, String>();
					hastable.put("SheetName", hash_Sheet);
					for(int col = 0; col < getColumnCount(hash_Sheet); col++) 
					{
						hastable.put(getCellData(hash_Sheet, col, 1), getCellData(hash_Sheet, col,rNum ));
					   System.out.print(getCellData(hash_Sheet, col,rNum ) +" ");
			        }
			      /* It will put the Data into the Table for Each row and then 
			       put the table inside the Two dimensional Array
				  APPLICATION_LOGS.debug("Test Case " + testMode+ " starts from Row Number " + testStartRow + "in sheet" + sheetName);*/
					System.out.println("");
					data[dataIndex][0]=hastable;
					dataIndex++;	
			 
	  /* int hash_row=getRowCount(hash_Sheet);	
	   System.out.println("hash_row "+hash_row);
	 
	   int hash_col=sheet.getRow(0).getLastCellNum();
	   System.out.println("hash_col "+hash_col);
	  
	 //  data=new Object[hash_row-1][1];
	               
	   for(int i=1;i<hash_row;i++){
		   if (hastable.get("RunMode").trim().equalsIgnoreCase("YES")) {
		    hastable=new Hashtable<>();
		   hastable.put("SheetName",hash_Sheet); 
		   
		   for(int j=0;j<hash_col;j++){
			   hastable.put(getCellData(hash_Sheet,j , 0), getCellData(hash_Sheet, j, i));
			   System.out.println("key==> "+getCellData(hash_Sheet, j, 0) + " Value===>"+ getCellData(hash_Sheet, j, i));
		   }
		   
		   //data[dataIndex][0]=hastable;
		 //  dataIndex++;
		  int r=i-1;
		   data[r][0]=hastable;
		   System.out.println("data["+r+"]["+0+"]===>"+data[r][0]);
		   }else{
			System.out.println("sdfgs");   
		   }
		   }
	 */
			 }}
		return data;
		 
	}	
	
	//==================MAJOR PART==========
	public static Object[][] hashtableGetData(String hash_Sheet,String testName,String testMode){
		Object data[][]=null;
	
		if(testName!=null && !testName.isEmpty()){
			
			System.out.println("testName");
			int hash_row=getRowCount(hash_Sheet);	
		    System.out.println("hash_row "+hash_row);
		   
		   int hash_col=sheet.getRow(0).getLastCellNum();
		   System.out.println("hash_col "+hash_col);
		 
		   data=new Object[hash_row-1][1];
		   int runmode_count=0;
		   
		   for(int i=1;i<hash_row;i++){
			  
			   if(getCellData_col_Name(hash_Sheet, "TCID", i).equalsIgnoreCase(testName)){
				  
				   hastable=new Hashtable<>();
				   hastable.put("SheetName",hash_Sheet); 
			   
			   for(int j=0;j<hash_col;j++){
				   
				   hastable.put(getCellData(hash_Sheet,j , 0), getCellData(hash_Sheet, j, i));
				   System.out.println("key==> "+getCellData(hash_Sheet, j, 0) + " Value===>"+ getCellData(hash_Sheet, j, i));
			   }
			   data[i-1][0]=hastable;
			 break;
		       }
		   }
		} 
		
		else if(testMode!=null){
			
			System.out.println("TestMode");
			
		int hash_row=getRowCount(hash_Sheet);	
	    System.out.println("hash_row "+hash_row);
	   
	   int hash_col=sheet.getRow(0).getLastCellNum();
	   System.out.println("hash_col "+hash_col);
	 
	   data=new Object[hash_row-1][1];
	   int runmode_count=0;
	   
	   for(int i=1;i<hash_row;i++){
		  
		   System.out.println("===========>"+getCellData_col_Name(hash_Sheet, "RunMode", i));
		  if(getCellData_col_Name(hash_Sheet, "RunMode", i).equalsIgnoreCase(testMode)){
			  
			   hastable=new Hashtable<>();
			   hastable.put("SheetName",hash_Sheet); 
		   
		   for(int j=0;j<hash_col;j++){
			   hastable.put(getCellData(hash_Sheet,j , 0), getCellData(hash_Sheet, j, i));
			   System.out.println("key==> "+getCellData(hash_Sheet, j, 0) + " Value===>"+ getCellData(hash_Sheet, j, i));
		   }
		   data[i-1][0]=hastable;
		 
	          }
	        }
		}else{
			System.out.println("Normal");
			
			int hash_row=getRowCount(hash_Sheet);	
			   System.out.println("hash_row "+hash_row);
			 
			   int hash_col=sheet.getRow(0).getLastCellNum();
			   System.out.println("hash_col "+hash_col);
			  
			   data=new Object[hash_row-1][1];
			   for(int i=1;i<hash_row;i++){
				    hastable=new Hashtable<>();
				   hastable.put("SheetName",hash_Sheet); 
				   
				   for(int j=0;j<hash_col;j++){
					   hastable.put(getCellData(hash_Sheet,j , 0), getCellData(hash_Sheet, j, i));
					   System.out.println("key==> "+getCellData(hash_Sheet, j, 0) + " Value===>"+ getCellData(hash_Sheet, j, i));
				   }
				   
				  int r=i-1;
				   data[r][0]=hastable;
				   System.out.println("data["+r+"]["+0+"]===>"+data[r][0]);
				   }
				}
		
		    return data;
	
	    }
	
     }
