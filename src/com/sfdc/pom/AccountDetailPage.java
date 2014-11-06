package com.sfdc.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetailPage extends BasePage {
	private WebDriver driver;
	
	
	static Row rownum1;
	static Row row_account;
	static String Field_Name;
	static String Account_Name;
	static int record_found = 0;
	
	
	
	int exit_loop = 0;
	int exec_end = 0;

	@FindBy(id = "vwid")
	private WebElement View;

	@FindBy(xpath = "//img[@id='rpp_selectorArrow']")
	private WebElement RightArrow;

	@FindBy(xpath = ".//td[text()='Account Record Type']/../td[4]")
	private WebElement AccountRecordType;

	@FindBy(xpath = ".//h2[text()='Account Detail']")
	private WebElement AccountDetail;

	public AccountDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void AccountDetailVerification(String AccountName,String xlPath,int j) throws InterruptedException, IOException, InvalidFormatException {
		Actions actions = new Actions(driver);
		
			
		
		FileInputStream fis=new FileInputStream(xlPath);
		
		
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s1 = wb.getSheet("Fields Repository");
		
		
		
		
		
	
			
			
			
			
			
			
			exit_loop =0;
			exec_end=0;
			int i=0;
			
			
			row_account = s1.getRow(i);
			/*
			if(counter>0)
			{
			
			driver.findElement(By.xpath("//a[contains(text(), 'My Accounts')]")).click();
			
			driver.switchTo().frame("itarget");
			
				}*/
		
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		j++;
		
		//try {
		// Account_Name =row_account.getCell(j).getStringCellValue();}catch(NullPointerException fsf){exec_end=5;}
		
		//if(exec_end!=5)
		//{
		
		
		
		driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='yellow';",AccountDetail);

		AccountRecordType.click();

		String Account_record_type = AccountRecordType.getText();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String filepath = "C:\\Users\\sharath\\Desktop\\"+ AccountName + ".png";

		FileUtils.copyFile(scrFile, new File(filepath));

		
		Iterator<Row> iterator1 = s1.iterator();

		do {

			Row row_record = iterator1.next();

			Cell record_type1 = row_record.getCell(0);

			if (record_type1 == null) {

			} else {

				int rowcount = record_type1.getRowIndex();

				String record_type = record_type1.toString();// row_record.getCell(0,Row.CREATE_NULL_AS_BLANK).getStringCellValue();

				if (Account_record_type.equals(record_type)) {
					i = rowcount;
					record_found = 3;
					
				}
			}
		} while (iterator1.hasNext());

		System.out.println("AccountName" + AccountName);

		do {

			rownum1 = (Row) s1.getRow(i);
			try {
				Field_Name = rownum1.getCell(1).getStringCellValue();
				System.out.println("1st Field" + Field_Name);
			} catch (NullPointerException ds) {

				System.out.println("Exitingloop");
				exit_loop = 5;
			}

			if (exit_loop < 1) {

				driver.manage().timeouts()
						.implicitlyWait(2, TimeUnit.SECONDS);
				try {
					String ab = driver.findElement(
							By.xpath("//td[(text()='" + Field_Name
									+ "')]")).getText();
					System.out.println("The field " + ab
							+ "is present in the page");
					rownum1.createCell(j).setCellValue("PASS");

				} catch (NoSuchElementException fd)

				{

					try {

						String ab = driver.findElement(
								By.xpath("//span[(text()='"
										+ Field_Name + "')]"))
								.getText();
						System.out.println("The field " + ab
								+ "is present in the page");
						rownum1.createCell(j).setCellValue("PASS");
					} catch (NoSuchElementException sd)

					{
						System.out.println("The field " + Field_Name+ "is not present in the page");
						rownum1.createCell(j).setCellValue("FAIL");
					}
				}
			}
			i++;
		}while (exit_loop != 5);
		
	
		//}
	//}while (exec_end != 5);
 
System.out.println("Execution ended no more fields");


FileOutputStream file1 = new FileOutputStream(xlPath);

wb.write(file1);
file1.close();

	
}}
