package com.codingRound.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.codingRound.base.TestBase;
import com.codingRound.pages.SignInPage;
import com.codingRound.util.Util;

public class SignInTest extends TestBase {
	SignInPage signInPage;
	
	public SignInTest() {
	super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		signInPage = new SignInPage();
	}
	
	@Test(priority = 1)
	//Validating the Presence of Your trips Link
	public void validateYourTripsLink() {
		Assert.assertTrue(signInPage.checkIfYourTripsLinkPresent(), "Your Trips link isn't present");
	}

	@Test(priority = 2)
	//Validating the Presence of SignIn Link
	public void validateSignInLink() {
		Assert.assertTrue(signInPage.checkIfSignInLinkPresent(), "SignIn link isn't present");
	}
	
	@Test(priority = 3)
	//Validating the Presence of Username text field
	public void validateUsernameTextField() {
		Assert.assertTrue(signInPage.checkIfUsernameTextFiledPresent(), "Username text field isn't present");
	}

	@Test(priority = 4)
	//Validating the Presence of password text field
	public void validatePasswordTextField() {
		Assert.assertTrue(signInPage.checkIfPasswordTextFieldPresent(), "Password text field isn't present");
	}

	@Test(priority = 5)
	//Validating the Presence of sign button
	public void validateSignInButton() {
		Assert.assertTrue(signInPage.checkIfSignInButtonPresent(), "SignIn button isn't present");
	}
	
	@Test(dataProvider = "testData", priority = 6)
	//Validating the SignIn functionality with different Test Data
	public void signInTest(String scenario, String username, String password, String expectedMessage) {
		Assert.assertTrue(signInPage.clickOnYourTripsLink(), "Your Trips link isn't clickable");
		Assert.assertTrue(signInPage.clickOnSignInLink(), "SignIn link isn't clickable");
		driver.switchTo().frame("modal_window");
		Assert.assertTrue(signInPage.enterValuesIntoUsernameTextField(username), "Unable to enter test data in username text field");
		Assert.assertTrue(signInPage.enterValuesIntoPasswordTextField(password), "Unable to enter test data in password text field");
		
		switch (scenario.toLowerCase()) {
		case "emptyfields":
		Assert.assertTrue(signInPage.clickOnSignInButton(), "SignIn button isn't clickable");
		assertEquals(signInPage.getErrorMessage(), expectedMessage, "Error Message is not matching hence SignIn Test failed");
		break;
		
		case "invalid":
			Assert.assertTrue(signInPage.clickOnSignInButton(), "SignIn button isn't clickable");
			assertEquals(signInPage.getErrorMessage(), expectedMessage, "Error Message is not matching hence SignIn Test failed");
			break;
			
		//Case "valid": I shall add the valid test cases when I have valid test data for signIn
		}
	}
	@DataProvider
	public Object[][] testData(){
		return Util.getData("SignInPage");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
