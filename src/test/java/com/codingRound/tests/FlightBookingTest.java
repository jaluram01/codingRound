package com.codingRound.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codingRound.base.TestBase;
import com.codingRound.pages.FlightBookingPage;
import com.codingRound.pages.SearchSummaryPage;
import com.codingRound.util.Util;

public class FlightBookingTest extends TestBase {
	FlightBookingPage flightBookingPgae;
	SearchSummaryPage searchSummaryPage;
	
	public FlightBookingTest() {
		super();
	}
	@BeforeTest
	public void doIHaveToSkip() {
		
		System.err.println(Util.checkTestCaseRunmode(this.getClass().getSimpleName()));
		if (!(Util.checkTestCaseRunmode(this.getClass().getSimpleName()))) {
			throw new SkipException("Runmode set to No");
		}
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		flightBookingPgae=new FlightBookingPage();
		searchSummaryPage = new SearchSummaryPage();
		
	}
	
	@Test(priority=1)
	//This method is written to verify the one way radio button presence 
	public void validateOneWayRadio() {
		Assert.assertTrue(flightBookingPgae.checkIfOneWayRadioButtonPresent(), "One Way Radio Button is not displayed");
	}
	
	@Test(priority = 2)
	//This method is written to verify the presence of origin text field
	public void validateOriginTextField() {
		Assert.assertTrue(flightBookingPgae.checkIfOriginTextFieldPresent(), "Origin text field isn't present");
	}
	
	@Test(priority = 3)
	//This method is written to verify the presence of destination text field
	public void validateDestinationTextField() {
		Assert.assertTrue(flightBookingPgae.checkIfDestinationTextFieldPresent(), "Destination text field isn't present");
	}
	
	@Test(priority = 4)
	//This method is written to verify the presence of departOn date text field
		public void validateDepartDateTextField() {
			Assert.assertTrue(flightBookingPgae.checkIfDepartDateTextFieldPresent(), "DepartOn date text field isn't present");
		}
	
	@Test(priority = 5)
	//This method is written to verify the presence of departOn date text field
			public void validateSearchButton() {
				Assert.assertTrue(flightBookingPgae.checkIfSearchButtonPresent(), "Search button isn't present");
			}
		
	
	
	@Test(dataProvider = "testData", priority = 6)
	//This method is written to verify the functionality of flight booking
	public void flightBookingSearchTest(String departOn, String origin, String destination) {
		
		//Click on 'One Way' radio button
		Assert.assertTrue(flightBookingPgae.clickOnOneWayRadioButton(), "One Way Radio Button isn't clickable");
		
		//Clear the data from Origin Text Field
		Assert.assertTrue(flightBookingPgae.clearOriginTextFiled(), "Unable to clear the origin text field");
		
		//Enter the values into origin text field
		Assert.assertTrue(flightBookingPgae.enterValueIntoOriginTextfiled(origin), "Unable to enter the value into origin textfield");
		
		//Select the values from origin dropdown result
		Assert.assertTrue(flightBookingPgae.selectValueFromOriginDropdown(), "Unable to select value from origin dropdown");
		
		//Clear the data of destination text field
		Assert.assertTrue(flightBookingPgae.clearDestinationTextField(), "Unable to clear the destination text filed");
		
		//Enter the values into destination text field
		Assert.assertTrue(flightBookingPgae.enterValueIntoDestinationTextField(destination), "Unable to enter the value into destination field");
		
		//Select the values from destination dropdown result
		Assert.assertTrue(flightBookingPgae.selectValueFromDestinationDropdown(), "Unable to select the value from destination dropdown");
		
		//Click on departOn date field
		Assert.assertTrue(flightBookingPgae.clickOnDepartOnDateField(), "DepartOn date field is not clickable");
		
		//Select the values from departOn date-picker
		Assert.assertTrue(flightBookingPgae.selectValueFromDepartOnDatePicker(departOn), "Unable to select the value from departOn date picker");
		
		//All the fields filled with data, now click on search button
		Assert.assertTrue(flightBookingPgae.clickOnSearchButton(), "Search button isn't clickable");
		
		//Verify whether its navigated to next page
		Assert.assertTrue(searchSummaryPage.checkIfSearchSummaryLinkPresent(), "Flight Booking Search test failed");
		}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] testData(){
		return Util.getData("FlightBookingPage");
	}

}
