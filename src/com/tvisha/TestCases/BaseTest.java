package com.tvisha.TestCases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.tvisha.Browsers.IEDriver;
import com.tvisha.Utility.Constant;
import com.tvisha.Utility.Utility;



public class BaseTest {
	public Properties props=null;
	static FileInputStream fileInputStream=null;
	public WebDriver driver = null;
	
   
	public void read_properties(){
		
		props=new Properties();
		
		try{
			fileInputStream = new FileInputStream(Constant.BROWSER_PROPERTY_FILE_PATH);
			props.load(fileInputStream);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void open_browser() throws InterruptedException{
	
		try{
    		
			switch (props.getProperty("browser")){
			
    		case "firefox":
    			FirefoxProfile customProfile = new FirefoxProfile();
    			customProfile.setPreference("dom.disable_beforeunload", true);
    			
    			System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"//src//geckodriver.exe");
    			driver=new FirefoxDriver(customProfile);
    			Thread.sleep(1000);
    			driver.manage().window().maximize();
				break;

			case "chrome":
				ChromeOptions o = new ChromeOptions();
				o.addArguments("disable-extensions");
				o.addArguments("--start-maximized");
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\SatishTvisha\\Desktop\\chromedriver.exe");
				driver = new ChromeDriver(o);
				driver.manage().window().maximize();
				//ChromeDriver.chromeDriver();
				break;
				
			case "IE":
				//IEDriver.ieDriver();
				break;
				
			default:
			//	FirefoxDriver.firefox_launch();
				break;
			}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
	 	
		Thread.sleep(1000);	
		
			}
	
	public void get_URL(){
		try{
			
			driver.get(props.getProperty("URL"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	@BeforeTest
	public void setUpBrowser() throws InterruptedException{
		read_properties();
		open_browser();
		get_URL();
          }	
 
	
	
	@AfterTest
	public void quite(){
	/*driver.close();*/
		//driver.quit();		
	}
	

}
