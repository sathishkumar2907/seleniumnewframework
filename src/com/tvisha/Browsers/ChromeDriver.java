package com.tvisha.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriver  {
	
   public static void chromeDriver(){
	   try{
			
		   ChromeOptions o = new ChromeOptions();
		   o.addArguments("disable-extensions");
		   o.addArguments("--start-maximized");
		   
		   System.setProperty("webdriver.chrome.driver","D:\\sathish_softwares\\chromedriver.exe");
		   ChromeDriver driver=new ChromeDriver();
		  // driver.manage().window().maximize();
	  
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
	
}
