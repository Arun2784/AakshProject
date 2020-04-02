package com.aakash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class SearchedCoursePage extends TestBase {

	@FindBy(xpath = "//input[@id='edit-buysubmit']")

	WebElement payRegistrationFee;

	

	public SearchedCoursePage() {

		PageFactory.initElements(driver, this);

	}
	
	
	public CartPage clickOnPayRegistration() {
		
		payRegistrationFee.click();
		
		return new CartPage();
		
		
	}
	
}
