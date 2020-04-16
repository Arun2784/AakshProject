package com.aakash.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class CustomerDetailsPage extends TestBase {

	@FindBy(xpath = "//label[contains(text(),'Paytm')]")

	WebElement paymentMethod;

	@FindBy(xpath = "//input[@id='edit-payment-information-billing-information-field-product-student-fname-0-value']")

	WebElement firstName;

	@FindBy(xpath = "//input[@id='edit-payment-information-billing-information-field-product-student-lname-0-value']")

	WebElement lasttName;

	@FindBy(xpath = "//label[contains(text(),'Female')]")

	WebElement gender;

	@FindBy(xpath = "//input[@id='edit-payment-information-billing-information-field-admission1-student-dob-0-value-date']")

	WebElement dateofBirth;

	public CustomerDetailsPage() {

		PageFactory.initElements(driver, this);

	}

	public void fill_shipping_information(String stu_name,String stu_last) throws InterruptedException {

		//paymentMethod.click();
		//gender.click();
		
		Thread.sleep(5000);
		firstName.sendKeys(stu_name);
		lasttName.sendKeys(stu_last);

	}

//	public void select_PaymentMethod() {
//
//		paymentMethod.click();
//
//	}
//
//	public void select_Gender() {
//
//		gender.click();
//
//	}
//
//	public void selectDOB(WebDriver driver, WebElement dateofBirth, String dateVal) {
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("arguments[0].setAttributes('value','" + dateVal + "');", dateofBirth);
//
//	}

}
