package add_mem_group;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gargoylesoftware.htmlunit.javascript.host.Set;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import net.sourceforge.tess4j.TesseractException;

import three_mem_group.sendmsg_grp3;
import util_classes.Launch;
import util_classes.Login;
import util_classes.demo_class;
import util_classes.receivemsgin_recentchatlist;
import util_classes.sendmsg;


public class Emulator1 extends Thread {
	AndroidDriver<AndroidElement> driver;
	
	/*public	static ExtentHtmlReporter htmlReporter;
	public	static ExtentReports extent;
	public	static ExtentTest logger;
	*/
	   String udid;
	   String port;
	    String user;
	    String pswrd;
	    String mess;
	    //
	   
	    
	    @AndroidFindBy(id="com.tvisha.troopmessenger:id/userId")
		public WebElement emailid;
		@AndroidFindBy(id="com.tvisha.troopmessenger:id/password")
		public WebElement password;
		@AndroidFindBy(id="com.tvisha.troopmessenger:id/login")
		public WebElement submit;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		/*public Emulator1(Common com1,AndroidDriver<AndroidElement> drivers , String user, String pswrd, String mess) {
	        this.com1=com1;
	        this.user = user;
	        this.pswrd = pswrd;
	        this.mess = mess;
	    } */
	   public Emulator1()
	   {
			
	   }
	   public Emulator1(String port, String udid, String user, String pswrd){
		this.udid=udid;
		this.port=port;
		this.user=user;
		this.pswrd=pswrd;
		}
		
	  public void launch1(){
		
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
		//cap.setCapability("appActivity","com.tvisha.troopmessenger.activity.login.login.LoginActivity");
		cap.setCapability("appActivity", "com.tvisha.troopmessenger.activity.SplashScreenActivity");
		
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("newCommandTimeout",1000);
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
		  
		
	}
	
	
		
	
	public void login1() throws InterruptedException{

			  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
				
			  try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				emailid.sendKeys(user);
				password.sendKeys(pswrd);
			//	driver.pressKeyCode(AndroidKeyCode.BACK);
				submit.click();
				System.out.println("emulatot1");
				Reporter.log("Sucessfully logged in emulator 1");
		        Thread.sleep(50000);

		}
	
	public void run(){
		System.out.println("======================");
		Reporter.log("============================");
	
	    launch1();
		try {
		
//		demo_class.logger = demo_class.extent.createTest("sender login");

		login1();
		sendmsg_grp3 sm=new sendmsg_grp3(driver);
		sendmsg ss=new sendmsg(driver);
		sm.scroll("Addmem3 ");
		ss.send_msg(mess);
		Add_mem3 add= new Add_mem3(driver);
		add.add_mem();
		
		System.out.println("removed member from group");
		demo_class.logger.log(Status.PASS, MarkupHelper.createLabel("After adding member to the group", ExtentColor.BLACK));
		
		
		sm.send_msg(mess);
	//	removed=1;
		System.out.println("r value: "+receivemsgin_recentchatlist.r);
//		sm.status2();
//		sm.send_image();
//		sm.send_cont();
		
		Thread.sleep(10000);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	
		System.out.println("=======@@@@@@@===");
		Reporter.log("============@@@@@@==");
	}
		
		
		
		
	}
	
	
	
	
	
	


