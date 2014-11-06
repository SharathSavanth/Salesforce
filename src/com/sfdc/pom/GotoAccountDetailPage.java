package com.sfdc.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GotoAccountDetailPage extends BasePage {
	private WebDriver driver;
	

	@FindBy(id = "vwid")
	private WebElement View;

	@FindBy(xpath = "//img[@id='rpp_selectorArrow']")
	private WebElement RightArrow;

	@FindBy(xpath = "//*[@id='rpp_menu']/tbody/tr[5]/td[2]")
	private WebElement Select200;

	@FindBy(xpath = ".//*[@id='rppForm']//..//a[1]")
	private WebElement next;

	public GotoAccountDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}

	public void gotoAccountDetail() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		driver.switchTo().frame("itarget");
		new Select(View).selectByVisibleText("My Accounts");
		WebElement element = driver.findElement(By
				.xpath(".//*[@id='rpp_selectorArrow']"));

		actions.moveToElement(element);
		actions.click();
		actions.perform();

		driver.findElement(By.xpath("//td[text()='200']")).click();

	}

	public void clickNext() throws InterruptedException {
		
		driver.switchTo().frame("itarget");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(next);
		actions.click();
		actions.perform();

	}

}
