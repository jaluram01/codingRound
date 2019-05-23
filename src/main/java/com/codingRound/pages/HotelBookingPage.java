package com.codingRound.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codingRound.base.TestBase;
import com.codingRound.util.Util;

public class HotelBookingPage extends TestBase {
	 
	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	//WebElements
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    //Actions
    
    //Check the presence of Hotel link
    public boolean checkIfHotelLinkPresent() {
    	return hotelLink.isDisplayed();
    }
    
    //Check the presence of location text field
    public boolean checkIfLocalityTextFieldPresent() {
    	hotelLink.click();
    	return localityTextBox.isDisplayed();
    }
    
    //Check the presence of Travelers text field
    public boolean checkIfTravellersTextFieldPresent() {
    	hotelLink.click();
    	return travellerSelection.isDisplayed();
    }
    
    //Check the Presence of Search button
    public boolean checkIfSearchButtonPresent() {
    	hotelLink.click();
    	return searchButton.isDisplayed();
    }
    
    //Check if the Hotel link is clickable
    public boolean clickOnHotelLink() {
    	try {
    	 hotelLink.click();
    	 return true;
    	}catch(Exception e) {
    		return false;
    	}
    }
    
    //Enter values into Locality Text Field
    public boolean enterValuesIntoLocalityTextField(String locality) {
    	try {
    		localityTextBox.sendKeys(locality);
    		Util.waitFor(5000);
    		localityTextBox.sendKeys(Keys.ENTER);
    		
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
    }
    
    //Select values from Travelers dropdown
    public boolean selectValuesFromTravelersDropdown(String travelerDetails) {
    	try {
    		Util.selectValueFromDropdown(travellerSelection, travelerDetails);
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
    }
    
    //Click On Search Button
    public boolean clickOnSearchButton() {
    	try {
    		searchButton.click();
    		return true;
    	}catch(Exception e) {
    		return false;
    	}
    }
}
