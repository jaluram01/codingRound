package com.codingRound.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codingRound.base.TestBase;
import com.codingRound.pages.HotelBookingPage;
import com.codingRound.pages.SearchSummaryPage;
import com.codingRound.util.Util;

public class HotelBookingTest extends TestBase{
	HotelBookingPage hotelBookingPage;
	SearchSummaryPage searchSummaryPage;
	public HotelBookingTest() {
		super();
	}
	
	@BeforeTest
	//Checking the runmode of the class
	public void doIHaveToSkip() {
		
		System.err.println(Util.checkTestCaseRunmode(this.getClass().getSimpleName()));
		if (!(Util.checkTestCaseRunmode(this.getClass().getSimpleName()))) {
			throw new SkipException("Runmode set to No");
		}
		
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		hotelBookingPage=new HotelBookingPage();
		searchSummaryPage=new SearchSummaryPage();
	}
	
	@Test(priority = 1)
	//Validating the Presence of Hotel Link
	public void validateHotelLink() {
		Assert.assertTrue(hotelBookingPage.checkIfHotelLinkPresent());
	}
	
	@Test(priority = 2)
	public void validateLocalityTextField() {
		Assert.assertTrue(hotelBookingPage.checkIfLocalityTextFieldPresent());
	}
	
	@Test(priority = 3)
	public void validateTravelerTextField() {
		Assert.assertTrue(hotelBookingPage.checkIfTravellersTextFieldPresent());
	}
	
	@Test(priority = 4)
	public void validateSearchButton() {
		Assert.assertTrue(hotelBookingPage.checkIfSearchButtonPresent());
	}
	
	@Test(dataProvider = "testData", priority = 5)
	//This method is created to validate the hotel search functionality
	public void hotelSearchTest(String locality, String travelerDetails ) {
		
		//Click on hotel Link from left panel
		Assert.assertTrue(hotelBookingPage.clickOnHotelLink(), "Unable to click on hotel link");
		
		//Waiting for the Page to Load
		Util.waitFor(3000);
		
		//Entering the data into Locality Text Field
		Assert.assertTrue(hotelBookingPage.enterValuesIntoLocalityTextField(locality), "Unable to Enter data into locality text field");
		
		//Waiting for the Page to Load
		Util.waitFor(5000);
		
		//Selecting the values from select dropdown
		Assert.assertTrue(hotelBookingPage.selectValuesFromTravelersDropdown(travelerDetails), "Unable to select value from traveler dropdown");
		
		//Click on Search Button
		Assert.assertTrue(hotelBookingPage.clickOnSearchButton(), "Unable to click on Search Button");
		
		////Waiting for the Page to load
		Util.waitFor(5000);
		
		//Verifying whether its navigated to desired page or not
		Assert.assertTrue(searchSummaryPage.checkIfSearchSummaryLinkPresent(), "Hotel Search Test Failed");
	}
	@DataProvider
	public Object[][] testData(){
		return Util.getData("HotelBookingPage");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
