package com.codingRound.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codingRound.base.TestBase;

public class SearchSummaryPage extends TestBase {

	public SearchSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(className="searchSummary")
	private WebElement searchSummaryLink;


	//Actions
	//This is the method to check the presence of search summary link
	public boolean checkIfSearchSummaryLinkPresent() {
		return searchSummaryLink.isDisplayed();
	}
}