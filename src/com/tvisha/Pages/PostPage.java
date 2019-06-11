package com.tvisha.Pages;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tvisha.Utility.Utility;


public class PostPage {
	
	WebDriver driver;
	Utility util;
	//==========================================
	List<String> monthList = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
	 // Expected Date, Month and Year
	 int expMonth;
	 int expYear;
	 String expDate = null;
	 // Calendar Month and Year
	 String calMonth = null;
	 String calYear = null;
	 boolean dateNotFound;
	
	//==========================================
	
	public PostPage(WebDriver driver){
		this.driver=driver;
	}
	
	@SuppressWarnings("unused")
	public void publishing_post_paths(String post_type, String post_title, String post_catagory, String post_sub_catagory,
			                          String post_description, String post_location, String post_price_tag,
			                          String post_tag, String post_publishType) throws InterruptedException{
		
		 //Set your expected date, month and year.  
		  expDate = "18";
		  expMonth= 0;
		  expYear = 2018;
		  
		
		
		By post_tab_path=By.id("post_tab");
		
		By post_title_path=By.id("postTitle");
		
		By post_category_path=By.xpath("//*[@id='postCategory']");
		
		By post_sub_category_path=By.xpath("//*[@id='postSubCategory']");
		
		By post_desc_path=By.id("postDescription");
		
		By post_location_path=By.id("postLocation");
		
		By post_price_tag_path=By.xpath("//*[@id='postPriceTagPlus']");
		
		By post_price_tag_input_field_path=By.id("postPriceTagInput");
		
		By post_tag_path=By.id("postTagPlus");
		
		By post_tag_input_field_path=By.id("postTagInput");
		
		By post_publish_type_field_path=By.id("postPublishType");
		
		By post_PRODUCT_submit_btn_path=By.id("postProductSubmit");
		
		By post_SERVICE_submit_btn_path=By.id("postServiceSubmit");
		
		By post_EVENTS_submit_btn_path=By.id("postEventSubmit");
		
		By post_ISHARE_submit_btn_path=By.id("postIshareSubmit");
		
		By post_VIDEOS_submit_btn_path=By.id("postVideoSubmit");
		
		By post_image_path=By.id("postAttachments");
		
		
		Thread.sleep(8000);
		/*WebElement post_tab_link=driver.findElement(post_tab_path);
		post_tab_link.click();*/
		
		util=new Utility(driver);
		util.click_action("id","post_tab");
		
		Thread.sleep(1000);
		
		
		//=========Post Type
		WebElement select_link=driver.findElement(By.xpath("//*[@id='addPostTabContent']/div[1]/div[1]/select"));
		try{
		
			if(post_type!=null && !post_type.isEmpty()){
	    
				util.select_dropdown_visiblity_text("xpath","//*[@id='addPostTabContent']/div[1]/div[1]/select", post_type);
				//Select_command(select_link, post_type);
	     	    System.out.println("post_type==>"+post_type);
			
			}else{
				System.out.println("Post Type is empty");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//=========Post Image
				//WebElement post_image_link=driver.findElement(post_image_path);
				try{
					//post_image_link.click();
					//post_image_link.sendKeys("C:\\Users\\SatishTvisha\\Pictures\\S1I1596grizzlysittingattideline547-10MB.jpg");
					
					util.send_keys("id", "postAttachments", "C:\\Users\\SatishTvisha\\Pictures\\S1I1596grizzlysittingattideline547-10MB.jpg");
					
					
					Thread.sleep(3000);
				}catch(Exception e){
					e.printStackTrace();
				}
		
		
		//=========Post Title
		//WebElement post_title_link=driver.findElement(post_title_path);
		if(post_title!=null && !post_title.isEmpty()){
			//post_title_link.sendKeys(post_title);
			util.send_keys("id", "postTitle",post_title);
		}else{
			System.out.println("Post Title is empty");
		}
		
		//======cat
		WebElement post_category_link=driver.findElement(post_category_path);
		if(post_catagory!=null && !post_catagory.isEmpty()){
			try{
			    Thread.sleep(1000);
				Select_command(post_category_link, post_catagory);
			
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("POst Category is empty");
		}
		
		//======Sub cat
				WebElement post_sub_category_link=driver.findElement(post_sub_category_path);
				if(post_sub_catagory!=null && !post_sub_catagory.isEmpty()){
					try{
					    Thread.sleep(1000);
						Select_command(post_sub_category_link, post_sub_catagory);
					
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					System.out.println("POst Sub Category is empty");
				}
		
	
		//=========Post Description
				WebElement post_desc_link=driver.findElement(post_desc_path);
				if(post_description!=null && !post_description.isEmpty()){
					post_desc_link.sendKeys(post_description);
				}else{
					System.out.println("POst Description is empty");
				}
				
				//===========================Events Date picker
				if(post_type.equalsIgnoreCase("EVENTS")){
					System.out.println("events");
					WebElement start_date=driver.findElement(By.xpath("//*[@id='postStartPublishDate']"));
					start_date.click();
					//month();
					posting_date(driver,"February 2018","20");
				}
				
		//=========Post Location
				WebElement post_location_link=driver.findElement(post_location_path);
				if(post_location!=null && !post_location.isEmpty()){
					post_location_link.sendKeys(post_location);
					Thread.sleep(1000);
					post_location_link.sendKeys(Keys.ARROW_DOWN);
					Thread.sleep(1000);
					post_location_link.sendKeys(Keys.ENTER);
					Thread.sleep(1000);
				}else{
					System.out.println("POst Location is empty");
				}
				
				
		//=========PostPrice Tag
				if(post_type.equalsIgnoreCase("PRODUCT") || post_type.equalsIgnoreCase("SERVICE")){
				
				      WebElement post_price_tag_link=driver.findElement(post_price_tag_path);
				     // post_price_tag_link.click();
			util.click_action("xpath", "//*[@id='postPriceTagPlus']");
			
			
		//=========Post Tag input price
				WebElement post_price_tag_input_field_link=driver.findElement(post_price_tag_input_field_path);
				if(post_price_tag!=null && !post_price_tag.isEmpty()){
					
					//post_price_tag_input_field_link.sendKeys(post_price_tag);
					util.send_keys("id", "postPriceTagInput", post_price_tag);
				}else{
					System.out.println("POst Location is empty");
				}
				
				}else{
					
					System.out.println("Selcted one is not in Product or Service Type...........");
				
				}
				
				
				
		//======Publish-->Pubic/Friends
				WebElement post_publish_type_field_link=driver.findElement(post_publish_type_field_path);
				if(post_publishType!=null && !post_publishType.isEmpty()){
					try{
					    Thread.sleep(1000);
						Select_command(post_publish_type_field_link, post_publishType);
					
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					System.out.println("POst Publish type is empty");
				}	
		
				
				if(post_type.equalsIgnoreCase("PRODUCT")){
					try{
						
						//WebElement post_PRODUCT_submit_btn_link=driver.findElement(post_PRODUCT_submit_btn_path);
						//post_PRODUCT_submit_btn_link.click();
						util.click_action("id","postProductSubmit");
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}else if(post_type.equalsIgnoreCase("SERVICE")){
                    try{
						
                    	//WebElement post_SERVICE_submit_btn_link=driver.findElement(post_SERVICE_submit_btn_path);
                    	//post_SERVICE_submit_btn_link.click();
                    	util.click_action("id","postServiceSubmit");
                    	
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}else if(post_type.equalsIgnoreCase("EVENTS")){
					
                   try{
						
                	  // WebElement post_EVENTS_submit_btn_link=driver.findElement(post_EVENTS_submit_btn_path);
                	   //post_EVENTS_submit_btn_link.click();
                	   util.click_action("id","postEventSubmit");
                	   
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}else if(post_type.equalsIgnoreCase("ISHARE")){
					
                   try{
						
                	   //WebElement post_ISHARE_submit_btn_link=driver.findElement(post_ISHARE_submit_btn_path);
                	   //post_ISHARE_submit_btn_link.click();
                	   util.click_action("id","postIshareSubmit");
                	   
					}catch(Exception e){
						e.printStackTrace();
					}
					
				}else if(post_type.equalsIgnoreCase("VIDEOS")){
                    try{
						
                    	//WebElement post_VIDEOS_submit_btn_link=driver.findElement(post_VIDEOS_submit_btn_path);
                    	//post_VIDEOS_submit_btn_link.click();
                    	util.click_action("id","postVideoSubmit");
                    	
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					
					System.out.println("No post buttons are clicked");
				}
				
				
				//driver.findElement(By.id("feedbackSection")).getText();
			    Thread.sleep(4000);
				String success_message=util.get_text("id","feedbackSection");
				System.out.println("After posting the post it is a success message======> " + util.get_text("id","feedbackSection"));
				Thread.sleep(1000);
				
				//=======hoopshe Logo click
				Thread.sleep(3000);
				Link_Text_anchor_tag("/webdemo/hoopshe/public");
				
			  }
	
	
	
	public void Select_command(WebElement element,String data){
		System.out.println("inside select command");
		Select select=new Select(element);
		select.selectByVisibleText(data);
		List <WebElement> elementCount = select.getOptions();
		System.out.println(elementCount.size());
	}
	
	
	public void Link_Text_anchor_tag(String href){
		 List<WebElement> anchors = driver.findElements(By.tagName("a"));
	        Iterator<WebElement> i = anchors.iterator();
	 
	        while(i.hasNext()) {
	            WebElement anchor = i.next();
	            if(anchor.getAttribute("href").contains(href)) {
	                anchor.click();
	                break;
	            }
	        }
	    }
	
	public void select_date(String date){
		
		WebElement table = driver.findElement(By.className("datepicker-days")); 
		
		List<WebElement> tableRows = table.findElements(By.xpath("tr"));
				for (WebElement row : tableRows) {
		List<WebElement> cells = row.findElements(By.xpath("td"));
		        for (WebElement cell : cells) {
				if (cell.getText().equals(date)) {
					driver.findElement(By.linkText(date)).click();
				}
			}
		}
	}
	
	
	public void month(){
		dateNotFound = true;
		 while(dateNotFound)
		  { 
		   //Retrieve current selected month name from date picker popup.
		   calMonth = driver.findElement(By.xpath("//*[@className='datepicker-months']/table/tbody/tr/td/span")).getText();
		   System.out.println("calMonth===>"+calMonth);
		   //Retrieve current selected year name from date picker popup.
		   calYear = driver.findElement(By.className("datepicker-years")).getText();
		   System.out.println("calYear===>"+calYear);
		   
		   //If current selected month and year are same as expected month and year then go Inside this condition.
		   if(monthList.indexOf(calMonth)+1 == expMonth && (expYear == Integer.parseInt(calYear)))
		   {
		    //Call selectDate function with date to select and set dateNotFound flag to false.
			select_date("20");
		    dateNotFound = false;
		   }
		   //If current selected month and year are less than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonth)+1 < expMonth && (expYear == Integer.parseInt(calYear)) || expYear > Integer.parseInt(calYear))
		   {
		    //Click on next button of date picker.
		    driver.findElement(By.xpath("//*[@id='addPostTabContent']/div[1]/div[5]/span[1]/div/ul/li[1]/div/div[2]/table/thead/tr/th[3]/span")).click();
		   }
		   //If current selected month and year are greater than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonth)+1 > expMonth && (expYear == Integer.parseInt(calYear)) || expYear < Integer.parseInt(calYear))
		   {
		    //Click on previous button of date picker.
		    driver.findElement(By.xpath("//*[@id='addPostTabContent']/div[1]/div[5]/span[1]/div/ul/li[1]/div/div[2]/table/thead/tr/th[1]/span")).click();
		   }}
	}
	
	
	public void year(String year){
		
		
		
	}
	
	
	
	
	
	   public void posting_date(WebDriver driver,String start_month, String start_date) throws InterruptedException {
		      
	        WebElement YEAR = driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr[1]/th[2]"));
	        System.out.println(YEAR.getText());
	        System.out.println(start_month);
			   while(!YEAR.getText().equalsIgnoreCase(start_month)) {  
			   driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr[1]/th[3]")).click(); 
				   Thread.sleep(1000);
			   }

			 WebElement table = driver.findElement(By.xpath("//table[@class='table-condensed']/tbody"));
				  
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("rows size"+rows.size());
			 
			for(WebElement row: rows) 
			{
			  try
			  {
				  List<WebElement> cols = row.findElements(By.tagName("td"));
				 System.out.println("col size"+cols.size());
				 for(WebElement col: cols)
		            { 
					
					  if(col.getText().equals(start_date)) 
					   {  
						 System.out.println(col.getText());
						 if(col.isEnabled()) {
							 col.click();
							 break; 
						 }
						
						 }
					}
				 } 
			  catch (StaleElementReferenceException e)
			      {
				  System.err.println(e);
			      } 
			}
	}
	

}
