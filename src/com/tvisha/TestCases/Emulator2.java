package add_mem_group;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import three_mem_group.sendmsg_grp3;
import util_classes.demo_class;
import util_classes.receivemsgin_recentchatlist;

public class Emulator2 extends Thread {
	AndroidDriver<AndroidElement> driver;
	
	   String udid;
	   String port;
	    String user;
	    String pswrd;
	    
	    String mess;
	    
	    DesiredCapabilities cap = new DesiredCapabilities();
		
	    @AndroidFindBy(id="com.tvisha.troopmessenger:id/userId")
		public WebElement emailid;
		@AndroidFindBy(id="com.tvisha.troopmessenger:id/password")
		public WebElement password;
		@AndroidFindBy(id="com.tvisha.troopmessenger:id/login")
		public WebElement submit;
		
		
	    public Emulator2(String port, String udid, String user, String pswrd){
			this.udid=udid;
			this.port=port;
			this.user=user;
			this.pswrd=pswrd;
			}
			
		 
		public void launch2(){
		
			File f=new File("src");
			File fr=new File(f,"TM_local(3-08-18).apk");
			cap=new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Rishiemulator");
			cap.setCapability("udid", udid);
			
			cap.setCapability("platformName", "Android");
			cap.setCapability("autoGrantPermissions", "true");
			cap.setCapability("waitForAppScript", "true");
			cap.setCapability(MobileCapabilityType.APP, fr.getAbsolutePath());
			cap.setCapability("appPackage", "com.tvisha.troopmessenger");
		//	cap.setCapability("appActivity","com.tvisha.troopmessenger.activity.login.login.LoginActivity");
			cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
			cap.setCapability("unicodeKeyboard", true);
			cap.setCapability("resetKeyboard", true);
			cap.setCapability("newCommandTimeout",1000);
			cap.setCapability("--log-level", false);
			  try {
				  driver = new AndroidDriver<>(new URL("http://0.0.0.0:" + port + "/wd/hub"),cap);
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		          Thread.sleep(5000);
		      } catch (MalformedURLException e) {
		          e.printStackTrace();
		      } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	  cap.setCapability("newCommandTimeout",200);
			  
		}
		
		
		
		
			public void login2() throws InterruptedException{
//				demo_class demo=new demo_class();
//			    demo.executeBeforeMethod() ;
//			    try{
				  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
					
				  try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					emailid.sendKeys(user);
					password.sendKeys(pswrd);
			//		driver.pressKeyCode(AndroidKeyCode.BACK);
					submit.click();
					System.out.println("emulatot2");
					Reporter.log("successfully logged in emulator 2");
			        Thread.sleep(70000);
//			    }catch(Exception e){
//			    	demo.result("Fail", "login2");
//			    }
//			        demo.result("Pass", "login2");
			
				}
			
	   
			public void loginuser2() throws InterruptedException{
//				demo_class demo=new demo_class();
//			    demo.executeBeforeMethod() ;
//			    try{
				  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
					
				  try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					emailid.sendKeys("swapna.y@tvisha.in");
					password.sendKeys("123456");
			//		driver.pressKeyCode(AndroidKeyCode.BACK);
					submit.click();
					System.out.println("emulatot2");
					Reporter.log("successfully logged in emulator 2");
			        Thread.sleep(70000);
//			    }catch(Exception e){
//			    	demo.result("Fail", "login2");
//			    }
//			        demo.result("Pass", "login2");
			
				}
		public void run(){
			System.out.println("=========================================================");
			Reporter.log("=============================================================");
			
			launch2();
			try {
			
				login2();
				Thread.sleep(60000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
							receivemsgin_recentchatlist rm= new receivemsgin_recentchatlist(driver);
				
					try {
						rm.receive();
						System.err.println("receiver emulator");
						System.err.println("r value in emulator2 class:: "+receivemsgin_recentchatlist.r);
						while(true){
							Thread.sleep(5000);
							System.out.println("while3");
							if(sendmsg_grp3.added_mem==1){
								System.out.println("whileif3");
								rm.receive();
								break;
							}
							
						}
						
						
					
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
			
				
			System.out.println("==========================@@@=========================");
			
			Reporter.log("=============================@@@================================");
		
		}
			
	}
		
		
		
