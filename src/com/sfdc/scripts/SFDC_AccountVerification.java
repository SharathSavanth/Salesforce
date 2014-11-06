package com.sfdc.scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.lib.ExcelLib;
import com.sfdc.pom.BasePage;
import com.sfdc.pom.AccountDetailPage;
import com.sfdc.pom.GotoAccountDetailPage;
import com.sfdc.pom.LoginPage;

public class SFDC_AccountVerification extends SuperTestNG {
	@Test   
	public void testSFDC_CreateAccount() throws InterruptedException,
			NullPointerException, InvalidFormatException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		BasePage basePage = new BasePage(driver);
		String xlPath ="D:/Selenium - ABBVIE/Projects/test data_Final.xlsx";
		
		int rowCount = ExcelLib.getRowCount(xlPath, "Login and Expected Accounts");
			    
		
		for (int i = 1; i <= rowCount; i++) {
			
			String Uname = ExcelLib.getCellValue(xlPath, "Login and Expected Accounts", i, 0);
			String password = ExcelLib.getCellValue(xlPath, "Login and Expected Accounts", i,	1);
			loginPage.login(Uname, password);
			
			int j=2;
			int dummy=0;
			int colCount = 0;
			try {
			 colCount = ExcelLib.getColCount(xlPath, "Login and Expected Accounts",i);}catch(NullPointerException d){dummy++;}
			
			if (dummy<1)
			{
			for (j = 2; j <= colCount-2; j++){
				//int colCount = ExcelLib.getColCount(xlPath, "Login and Expected Accounts", j);
				String accountName = ExcelLib.getCellValue(xlPath, "Login and Expected Accounts", i, j);
				
			
			basePage.goToMyAccounts();

			GotoAccountDetailPage gotoPage = new GotoAccountDetailPage(driver);
			gotoPage.gotoAccountDetail();
			
			//String xp = "//a[contains(text(),'" + accountName + "')]";  
			Actions actions = new Actions(driver);
			
			WebDriverWait wait = new WebDriverWait(driver,15);
			
			
			int temp=0;
			do {
				temp=0;
				try{
					
			WebElement account = wait.until(ExpectedConditions.elementToBeClickable(((By.xpath("//a[text()='"+accountName+"']")))));
			
			actions.moveToElement(account);
			actions.click();
			actions.perform();
			
			AccountDetailPage temp1= new AccountDetailPage(driver);
			temp1.AccountDetailVerification(accountName,xlPath,j);
			
			
			
			}catch(TimeoutException e) 
				{
				temp =5;
				gotoPage.clickNext();
				} 
			}while (temp ==5);
			
			org.openqa.selenium.browserlaunchers.Sleeper.sleepTightInSeconds(10);
			
	
			}

			basePage.logout();
		}}
			
	
}}
