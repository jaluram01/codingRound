package com.codingRound.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codingRound.base.TestBase;
import com.codingRound.util.Util;

public class SignInPage extends TestBase {
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//WebElement
	@FindBy(linkText="Your trips")
	private WebElement yourTripsLink;
	
	@FindBy(id="SignIn")
	private WebElement signIn;
	
	@FindBy(id="email")
	private WebElement userNameTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(id="signInButton")
	private WebElement signInButton;
	
	@FindBy(id="errors1")
	private WebElement errorMessage;
	
	
	//Actions
	public boolean checkIfYourTripsLinkPresent() {
		return yourTripsLink.isDisplayed();
	}
	
	public boolean checkIfSignInLinkPresent() {
		yourTripsLink.click();
		return signIn.isDisplayed();
	}
	
	public boolean checkIfUsernameTextFiledPresent() {
		yourTripsLink.click();
		signIn.click();
		Util.waitFor(5000);
		driver.switchTo().frame("modal_window");
		return userNameTextField.isDisplayed();
	}
	
	public boolean checkIfPasswordTextFieldPresent() {
		yourTripsLink.click();
		signIn.click();
		driver.switchTo().frame("modal_window");
		return passwordTextField.isDisplayed();
	}
	
	public boolean checkIfSignInButtonPresent() {
		yourTripsLink.click();
		signIn.click();
		driver.switchTo().frame("modal_window");
		return signInButton.isDisplayed();
	}
	public boolean clickOnYourTripsLink() {
		try {
		 yourTripsLink.click();
		 return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean clickOnSignInLink() {
		try {
		 
		 signIn.click();
		 return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean enterValuesIntoUsernameTextField(String username) {
		try {
		 userNameTextField.sendKeys(username);
		 return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean enterValuesIntoPasswordTextField(String password) {
		try {
		 passwordTextField.sendKeys(password);
		 return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean clickOnSignInButton() {
		try {
		
		signInButton.click();
		 return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
			
	}
	
}
