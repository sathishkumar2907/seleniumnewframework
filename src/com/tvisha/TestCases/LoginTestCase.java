package com.tvisha.TestCases;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tvisha.ExcelData.Ex;
import com.tvisha.ExcelData.ExcelData;
import com.tvisha.ExcelData.TestUtil;
import com.tvisha.Pages.LoginPage;

public class LoginTestCase extends BaseTest {

	
	/*@Test
	public void login_test() throws InterruptedException{
		//Log_information.setUpBrowser("chrome");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_In_page("8331848243", "123465");
	}*/
	

	@DataProvider
	public Object[][] getLoginData(){
		/*Ex ex=new Ex();
		return Ex.getData("C:\\Users\\SatishTvisha\\Desktop\\Book1.xlsx", "Sheet6", null, "YES");*/
		ExcelData excel=new ExcelData("C:\\Users\\SatishTvisha\\Desktop\\Book1.xlsx");
		return ExcelData.hashtableGetData("Sheet6", "TC1", "YES");
	
		//return TestUtil.getData("C:\\Users\\SatishTvisha\\Desktop\\Book1.xlsx","Sheet6","TC1",null);
	}
	
	@Test(dataProvider="getLoginData")
	public void login(Hashtable<String,String> hash_data) throws InterruptedException{
		
		LoginPage loginPage=new LoginPage(driver);
		
		//try{
			
		//if(hash_data.get("RunMode").equalsIgnoreCase("YES")){	
		loginPage.login_In_page(hash_data.get("Username"),hash_data.get("Password"));
		
		//}
		/*else{
			System.out.println("No run mode");
		}
		*/
		/*}catch(Exception e){
			e.printStackTrace();
			e.getLocalizedMessage();
			
		}*/
		
	}
	
}
