package com.sfdc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount extends BasePage {

	@FindBy(id = "reqreqi-value:string:Account:FirstName")
	private WebElement FirstName;

	@FindBy(id = "reqreqi-value:string:Account:LastName")
	private WebElement LastName;

	@FindBy(id = "reqreqi-value:picklist:Account:Person_Type_ABT__c")
	private WebElement Type;

	@FindBy(id = "reqreqi-value:picklist:Account:Credentials_vod__c")
	private WebElement Degree;

	@FindBy(id = "reqreqi-value:string:Account:Name")
	private WebElement AccountName;

	@FindBy(id = "reqreqi-value:picklist:Account:Type")
	private WebElement AccountType;

	@FindBy(id = "reqreqi-value:picklist:Account:Sub_Type_ABT__c")
	private WebElement AccountSubtype;

	@FindBy(id = "reqreqi-value:string:Address_vod__c:Name")
	private WebElement AddressLine1;

	@FindBy(id = "reqreqi-value:string:Address_vod__c:City_vod__c")
	private WebElement City;

	@FindBy(id = "reqreqi-value:picklist:Address_vod__c:State_vod__c")
	private WebElement State;

	@FindBy(id = "reqreqi-value:string:Address_vod__c:Zip_vod__c")
	private WebElement Zip;

	@FindBy(xpath = "//*[@id='trButtons']/td[2]/input[1]")
	private WebElement SaveButton;

	@FindBy(xpath = "//*[@id='trButtons']/td[2]/input[2]")
	private WebElement SecondSaveButton;

	public CreateNewAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void CreatePersonAccount(String firstName, String lastName,
			String type, String degree, String addLine1, String city,
			String state, String zip) throws InterruptedException {
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		new Select(Type).selectByVisibleText(type);
		new Select(Degree).selectByVisibleText(degree);

		AddressLine1.sendKeys(addLine1);
		City.sendKeys(city);
		new Select(State).selectByVisibleText(state);
		Zip.sendKeys(zip);
		SaveButton.click();
		if (SecondSaveButton.isEnabled()) {
			SecondSaveButton.click();
		} else {

		}
		Thread.sleep(10000);
	}

	public void CreateBuniessAccount(String name, String accountType,
			String accountSubType, String addLine1, String city, String state,
			String zip) throws InterruptedException {
		AccountName.sendKeys(name);
		new Select(AccountType).selectByVisibleText(accountType);
		new Select(AccountSubtype).selectByVisibleText(accountSubType);

		AddressLine1.sendKeys(addLine1);
		City.sendKeys(city);
		new Select(State).selectByVisibleText(state);
		Zip.sendKeys(zip);
		SaveButton.click();
		if (SecondSaveButton.isEnabled()) {
			SecondSaveButton.click();
		} else {

		}
		Thread.sleep(10000);

	}
}
