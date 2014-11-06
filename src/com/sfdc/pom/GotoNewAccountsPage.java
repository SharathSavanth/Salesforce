package com.sfdc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GotoNewAccountsPage extends BasePage {
	@FindBy(xpath = "//input[@name='newAcctButton']")
	private WebElement newButton;

	private WebDriver driver;

	@FindBy(xpath = "//input[@type='button' and @value='Continue']")
	private WebElement continueButton;

	@FindBy(id = "recordTypeSelect")
	private WebElement accountRecordType;

	public GotoNewAccountsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String gotoCreateAccount(String accountType) {
		try{
		driver.switchTo().frame("itarget");
		newButton.click();
		new Select(accountRecordType).selectByVisibleText(accountType);
		continueButton.click();
				}
		catch (Exception e)
		{
			System.out.println("Invalid Record Type");
			new BasePage(driver).logout();
		}
		return accountType;
	}

}
