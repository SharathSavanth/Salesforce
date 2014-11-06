package com.sfdc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage 
{
	String xlPath ="D:/Selenium/Workspace/Udanka/test data_Final.xlsx";
	
	@FindBy(xpath="//a[contains(text(),'My Accounts')]")
	private WebElement myAccounts;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']/a[1]")
	private WebElement mySettings;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(id="userNavLabel")
	private WebElement userNavLabel;
	
	public BasePage(WebDriver driver)
	{
		super();
		PageFactory.initElements(driver,this);
	}
	
	public void mySettings()
	{
		mySettings.click();
	}
	
	public void goToMyAccounts()
	{
		myAccounts.click();
	}
	
	public void logout()
	{
		userNavLabel.click();
		logoutLink.click();
	}
}
