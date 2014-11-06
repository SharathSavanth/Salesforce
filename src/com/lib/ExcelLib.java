package com.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib
{
	public static int getRowCount(String xlPath,String sheetName)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			int rc=s1.getLastRowNum();
			return rc;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
	
	public static String getCellValue(String xlPath,String sheetName,int rowNum,int cellNum)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			String v=s1.getRow(rowNum).getCell(cellNum).getStringCellValue();
			return v;
		}
		catch(Exception e)
		{
		System.out.println(e);
			return "";
		}
	}
	public static int getColCount(String xlPath,String sheetName, int row)
	{
		try
		{
			FileInputStream fis=new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			int rc=s1.getRow(row).getPhysicalNumberOfCells();
			return rc;
		}
		catch(Exception e)
		{
			return -1;
		}
	}
}
