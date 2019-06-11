

package com.tvisha.Utility;
import java.awt.Desktop.Action;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


public class Utility{
//	public TestNg_test_case_1(WebDriver driver) {
//		super(driver);
		// TODO Auto-generated constructor stub
//	}
	public WebDriver driver=null; 
	
	public Utility(WebDriver driver) {
	this.driver=driver;
	}

   public  WebDriverWait wait;
	
	/*@Parameters("browser")
	@BeforeSuite
	public static void setup(String browser){
	
	switch (browser) {
      
	case "firefox":
		//System.getProperty("webdriver.gecko.driver","‪D:\\geckodriver.exe");
		driver=new FirefoxDriver();
		//firefox_launch();
		//driver.manage().window().maximize();
		max_window_size();
		webDriverWait_for_secs();
		break;
		
	case "chrome":
		System.getProperty("webdriver.chrome.driver", "");
		System.getProperty("webdriver.chrome.driver","‪D:\\sathish_softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		max_window_size();
		webDriverWait_for_secs();
		break;
	
	case "IE":
		
		System.getProperty("webdriver.ie.driver","");
		driver=new InternetExplorerDriver();
		max_window_size();
		webDriverWait_for_secs();
		
		break;
		
   default:
		
	   driver=new FirefoxDriver();
		max_window_size();
		webDriverWait_for_secs();
		break;
	   }
		
	   }*/
	
/*	public void get_Url(String url){
		try{
			
	        driver.get(url);	
		 
		}catch(Exception e){
			System.err.println("No element is found to get the URL " +e);
		}
	    }
	
	public String get_title(){
		return driver.getTitle();
	}*/
	
	
	public String get_text(String locator_type,String value){
		
		By locator;
		try{
		   
			locator=all_locators(locator_type, value);
		    WebElement element=driver.findElement(locator);
		    String get_text_message=element.getText();
		    return get_text_message;
		}catch(Exception e){
			System.err.println("Not getting Text " + e);
		}
		return value;
		
		
	}
	
	
	public void forword_navigation() throws Exception{
		try{
			
			driver.navigate().forward();
			
		}catch(Exception e){
			throw new Exception("no element found for forward navigation " +e);
		}
		
		
	}
	
	
	
	public void back_naviagtion(){
		
		try{
			
			driver.navigate().back();
			
		}catch(Exception e){
			System.err.println("No element is found to perform back navigation  " +e);
		}
	    }
	
	
	public void click_action(String locator_type,String value){
	
		By locator;
		try{
		   
			locator=all_locators(locator_type, value);
		    WebElement element=driver.findElement(locator);
		    element.click();
		
		}catch(Exception e){
			System.err.println("No element is found to perform clicking action " + e);
		}
	    }
	
	public void send_keys(String locator_type,String value,String text){
		
		By locator;
		try{
			locator=all_locators(locator_type, value);
			WebElement element_send_data=driver.findElement(locator);
			element_send_data.sendKeys(text);
			
		}catch(Exception e){
			System.err.println("No element found to send data" +e);
		}
	    }
	
   	public void mouse_action(WebElement action_element){
		try{
			
		Actions action=new Actions(driver);
		action.moveToElement(action_element).build().perform();
	   
		}catch(Exception e){
		System.err.println("No mouse action is perform "  +e);
		}
		}
	
	public void select_dropdown_index(WebElement select_element,int i){
	try{
	
		Select select=new Select(select_element);
		select.selectByIndex(i);	

	}catch(Exception e){
			e.printStackTrace();
		}
	    }
	

	public void select_dropdown_visiblity_text(String locator_type,String value,String text){
		By locator;
		try{
			
		   locator=all_locators(locator_type, value);
		   WebElement element_send_data=driver.findElement(locator);
	       Select select=new Select(element_send_data);
	       select.selectByVisibleText(text);
   
    }catch(Exception e){
	   e.printStackTrace();
	 }
	 }
    
/*public void select_dropdown_visiblity_text(WebElement select_element,String visibility_text){
	try{
	
		Select select=new Select(select_element);
	    select.selectByVisibleText(visibility_text);
	
	}catch(Exception e){
		e.printStackTrace();
	}
    }*/

   public void max_window_size(){
	 try{
	   
		   driver.manage().window().maximize();
	   
	 }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   public void webDriverWait_for_secs(){
      
	 try{
	      wait=new WebDriverWait(driver,20);
     }catch(Exception e){
	e.printStackTrace();
      }		   
   }
   
   
   public static By all_locators(String locator,String value){
	
	   By by;
	   
	switch(locator) {
	
	case "id":
    	by=By.id(value);
	    break;

	case "name":
		by=By.name(value);
		break;
		
	case "xpath":                             
		by=By.xpath(value);
		break;
		
	case "className":
		by=By.className(value);
		break;
	
	case "cssSelector":
		by=By.cssSelector(value);
		break;
	
	case "linkText":
		by=By.linkText(value);
		break;	
		
	case "partialLinkText":
		by=By.partialLinkText(value);
		break;	
	
	default:
		by=null;
		break;

	 }
    return by;
    }
     
   public void driver_find_element(String locator_type,String value){
	
	  By locator;
	  try{
	  locator=all_locators(locator_type,value);
	WebElement s= driver.findElement(locator);
    
	  
	  }catch(Exception e){
		  System.err.println("No element is found to findelement "+e);
	    }
	
	  }
   
    public void driver_find_element_s(String locator_type,String value){
	   By locator;
	   try{
		 
		   locator=all_locators(locator_type, value);
		   driver.findElements(locator);
		   
	   }catch(Exception e){
		   System.err.println("No element is found to find elements " +e);
	     }
	   }
   
   public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	   try{
      
	   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       File DestFile=new File(fileWithPath);
       FileUtils.copyFile(SrcFile, DestFile);

	   }catch(Exception e){
		   System.out.println("No element found for TakesnapShot " +e );
	   }
   }
   
   @AfterSuite
   public void quite_browser(){
	   try{
		   
		//  driver.quit();
		   
	   }catch(Exception e){
		  e.printStackTrace();
	   }
	}




 
 }
