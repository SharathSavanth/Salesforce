package com.sfdc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(id="username")
	private WebElement unTextBox;
	
	@FindBy(id="password")
	private WebElement pwTextBox;
	
	@FindBy(id="Login")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
		driver.manage().window().maximize();
		
	}
	
	public void login(String un,String pw)
	{
		unTextBox.sendKeys(un);
		pwTextBox.sendKeys(pw);
		loginButton.click();
	}
	
}
