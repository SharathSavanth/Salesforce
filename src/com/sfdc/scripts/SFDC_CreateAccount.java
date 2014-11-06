package com.sfdc.scripts;

import org.testng.annotations.Test;

import com.lib.ExcelLib;
import com.sfdc.pom.BasePage;
import com.sfdc.pom.CreateNewAccount;
import com.sfdc.pom.GotoNewAccountsPage;
import com.sfdc.pom.LoginPage;

public class SFDC_CreateAccount extends SuperTestNG {
	@Test
	public void testSFDC_CreateAccount() throws InterruptedException,NullPointerException {
		LoginPage loginPage = new LoginPage(driver);

		int rowCount = ExcelLib.getRowCount("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1");

		for (int i = 1; i <=rowCount; i++) {
			String Uname = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 0);
			String password = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 1);
			String recordType = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 2);

			String firstName = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 3);
			String lastName = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 4);
			String type = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 5);
			String degree = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 6);

			String name = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 7);
			String accountType = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 8);
			String accountSubType = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx", "Sheet1", i, 9);

			String addLine1 = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx","Sheet1", i, 10);
			String city = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx","Sheet1", i, 11);
			String state = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx","Sheet1", i, 12);
			String zip = ExcelLib.getCellValue("D:/Selenium/Workspace/Udanka/test data.xlsx","Sheet1", i, 13);

			loginPage.login(Uname, password);

			BasePage basePage = new BasePage(driver);
			basePage.goToMyAccounts();

			GotoNewAccountsPage gotoPage = new GotoNewAccountsPage(driver);
			gotoPage.gotoCreateAccount(recordType);

			CreateNewAccount create = new CreateNewAccount(driver);
			if (recordType.equals("Health Care Professional")) {
				create.CreatePersonAccount(firstName, lastName, type, degree,addLine1, city, state, zip);
			} 
			else if	(recordType.equals("Business Not Verified")) {
				create.CreateBuniessAccount(name, accountType, accountSubType,addLine1, city, state, zip);
			} else {
				System.out.println("Invalid Record Type");
			}
			Thread.sleep(10000);

			basePage.logout();
		}
	}
}
