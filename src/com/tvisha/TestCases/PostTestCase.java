package com.tvisha.TestCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tvisha.ExcelData.ExcelData;
import com.tvisha.Pages.LoginPage;
import com.tvisha.Pages.PostPage;

public class PostTestCase extends LoginTestCase{

	
	@DataProvider
	public Object[][] getPostData(){
		
		ExcelData excel=new ExcelData("C:\\Users\\SatishTvisha\\Desktop\\Book1.xlsx");
		return ExcelData.hashtableGetData("Sheet7",null,"YES");
	}
	
	@Test(dataProvider="getPostData")
	public void posting(Hashtable<String,String> hash_data) throws InterruptedException{
		PostPage postPage=new PostPage(driver);
		try{
			Thread.sleep(4000);
			System.out.println("posting..........");
		    postPage.publishing_post_paths(hash_data.get("PostType"),hash_data.get("Title"),hash_data.get("Category"),
				                       hash_data.get("SubCategory"),hash_data.get("Description"),
				                       hash_data.get("Location"),hash_data.get("PriceTag"),hash_data.get("Tag"),hash_data.get("PublishType"));
		Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
