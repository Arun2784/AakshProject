package com.aakash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//input[@type='submit' and @id='edit-checkout']")
	
	WebElement proceedToCheckOut;

	public CartPage() {

		PageFactory.initElements(driver, this);

	}

	public LoginPage clickOnProceedToCheckOut() throws InterruptedException {

		Thread.sleep(5000);
		proceedToCheckOut.click();

		System.out.println("Successfully click on Proceed to checkout Page");
		
		return new LoginPage();
	}

}
