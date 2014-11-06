package com.sfdc.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class SuperTestNG 
{
	public WebDriver driver;
	
	String xlPath ="D:/Selenium - ABBVIE/Projects/test data_Final.xlsx";
	
	@BeforeMethod
	public void preCondition()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("http://test.salesforce.com");
	}
//	@AfterMethod
//	public void postCondition()
//	{
//	   driver.quit();	
//	}
}
