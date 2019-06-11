package com.tvisha.Browsers;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriver{
  //static FirefoxDriver driver;
	 
	public static void firefox_launch(){
		try{
		 System.setProperty("webdriver.gecko.driver","‪D:\\geckodriver.exe");	
		 FirefoxDriver driver=  new FirefoxDriver();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
