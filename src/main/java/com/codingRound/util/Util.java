package com.codingRound.util;

import java.io.File;
import java.text.DateFormatSymbols;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.codingRound.base.TestBase;


public class Util extends TestBase {

	public static Select element;
	
	//To Convert the Date Format
	public static String getMonthForInt(int m) {
		String month = "invalid";
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		if (m >= 1 && m <= 12) {
			month = months[m - 1];
		}
		return month;
	}
	
	//To wait for an element
	public static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
    }
	
	//To check the run mode of a class
	public static boolean checkTestCaseRunmode(String testCase) {
			for (int i = 2; i <= datatable.getRowCount("Tests"); ++i) {
			if (datatable.getCellData("Tests", "Test Case ID", i).equalsIgnoreCase(testCase)) {
				return (datatable.getCellData("Tests", "Runmode", i).equalsIgnoreCase("Y"));
			}
		}

		datatable = null;
		return false;
	}
	
	//To get the data from excel
	public static Object[][] getData(String sheetName) {
		if (!(datatable.isSheetExist(sheetName))) {
			datatable = null;
			return new Object[1][0];
		}

		int rows = datatable.getRowCount(sheetName) - 1;
		if (rows <= 0) {
			Object[][] testData = new Object[1][0];
			return testData;
		}

		rows = datatable.getRowCount(sheetName);
		int cols = datatable.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; ++rowNum) {
			for (int colNum = 0; colNum < cols; ++colNum) {
				data[(rowNum - 2)][colNum] = datatable.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;
	}
	
	//To capture a screenshot
	public static void screenshot(WebDriver driver, String SCNAME)

	{
		try {
			TakesScreenshot TS = (TakesScreenshot) driver;
			File source = TS.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshots/" + SCNAME));
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());

		}
	}
	public static boolean selectValueFromDropdown(WebElement locatorKey, String visibleText) {
		try {
			element = new Select(locatorKey);
			element.selectByVisibleText(visibleText);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	}
