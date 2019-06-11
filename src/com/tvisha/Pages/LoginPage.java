package com.tvisha.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tvisha.TestCases.Log_information;

public class LoginPage{
	
	WebDriver driver;
	
   public LoginPage(WebDriver driver){
		 this.driver=driver;
	 }
	 
	public void login_In_page(String username, String password) throws InterruptedException{
		/*By username_path=By.id("dXNlcm5hbWU");
		By password_path=By.id("cGFzc3dvcmQ");
		By Login_btn_path=By.id("bG9naW5CdG4");*/
		Thread.sleep(1000);
		WebElement username_web_ele=driver.findElement(By.id("dXNlcm5hbWU"));
	    username_web_ele.sendKeys(username);	
		
		WebElement password_web_ele=driver.findElement(By.id("cGFzc3dvcmQ"));
		password_web_ele.sendKeys(password);
		
		WebElement login_btn_web_ele=driver.findElement(By.id("bG9naW5CdG4"));
		login_btn_web_ele.click();
		
 	 }
   }
