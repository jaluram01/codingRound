package com.codingRound.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codingRound.base.TestBase;
import com.codingRound.util.Util;

public class FlightBookingPage extends TestBase {

	public FlightBookingPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(id = "OneWay")
	private WebElement oneWayRadioBtn;

	@FindBy(id = "FromTag")
	private WebElement fromTextField;

	@FindBy(xpath = "//*[@id='ui-id-1']/li")
	private List<WebElement> originDropdown;

	@FindBy(id = "ToTag")
	private WebElement toTextField;

	@FindBy(xpath = "//*[@id='ui-id-2']/li")
	private List<WebElement> destinationDropdown;

	@FindBy(id = "DepartDate")
	private WebElement departDateTextbox;

	@FindBy(id = "SearchBtn")
	private WebElement searchButton;

	// Actions
	// Generating the dynamic xpath for DatePicker, hence we can pick any date
	public String generateXpathForDatePicker(String departOn) {
		String splitDate[] = departOn.split("/");
		String date = splitDate[1];
		String month = Util.getMonthForInt(Integer.parseInt(splitDate[0]));
		String departOnXpath = "//span[@class='ui-datepicker-month' and contains(text(), '" + month
				+ "')]/../../..//a[contains(text(),'" + date + "')]";
		return departOnXpath;

	}
	
	//This method will return true if 'one way' radio button present otherwise it will return false
	public boolean checkIfOneWayRadioButtonPresent() {
		return oneWayRadioBtn.isDisplayed();
	}
	
	//This method will return true if origin text field present otherwise it will return false
	public boolean checkIfOriginTextFieldPresent() {
		return fromTextField.isDisplayed();
	}
	
	//This method will return true if destination text field present otherwise it will return false
	public boolean checkIfDestinationTextFieldPresent() {
		return toTextField.isDisplayed();
	}
	
	//This method will return true if departOn text field present otherwise it will return false
	public boolean checkIfDepartDateTextFieldPresent() {
		return departDateTextbox.isDisplayed();
	}
	
	//This method will return true if search button present otherwise it will return false
	public boolean checkIfSearchButtonPresent() {
		return searchButton.isDisplayed();
	}
	
	//This method will return true if one way radio button gets clicked otherwise it will return false
	public boolean clickOnOneWayRadioButton() {
		try {
			oneWayRadioBtn.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//This method will return true if From text field gets cleared otherwise it will return false
	public boolean clearOriginTextFiled() {
		try {
			fromTextField.clear();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//This method will return true if values gets entered in origin text field otherwise it will return false
	public boolean enterValueIntoOriginTextfiled(String origin) {
		try {
		fromTextField.sendKeys(origin);
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	//This method will return true if values gets selected from result dropdown otherwise it will return false
	public boolean selectValueFromOriginDropdown() {
		try {
			Util.waitFor(2000);
			originDropdown.get(0).click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	//This method will return true if destination field gets cleared otherwise it will return false
	public boolean clearDestinationTextField() {
		try {
		toTextField.clear();
		return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	//This method will return true if values gets entered in destination field otherwise it will return false
	public boolean enterValueIntoDestinationTextField(String destination) {
		try {
			toTextField.sendKeys(destination);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//This method will return true if values gets selected from result dropdown otherwise it will return false
	public boolean selectValueFromDestinationDropdown() {
		try {
			Util.waitFor(2000);
			destinationDropdown.get(0).click();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	//This method will return true if departOn text field gets clicked otherwise it will return false
	public boolean clickOnDepartOnDateField() {
		try {
			departDateTextbox.click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	//This method will return true if values gets selected from date picker otherwise it will return false
	public boolean selectValueFromDepartOnDatePicker(String departOn) {
		try {
			driver.findElement(By.xpath(generateXpathForDatePicker(departOn))).click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	//This method will return true if search button gets clicked otherwise it will return false
	public boolean clickOnSearchButton() {
		try {
			searchButton.click();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	}
