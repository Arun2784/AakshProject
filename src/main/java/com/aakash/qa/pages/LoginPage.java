package com.aakash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	@FindBy(xpath = "//div[contains(@class,'icon close')]")

	WebElement clickOnCrossIcon;
	
	@FindBy(xpath="//nav[@id='block-useraccountmenu-3']")
	
	WebElement clickonLoginIcon;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	
	WebElement clickonLogintext;
	
	@FindBy(xpath="//input[@id='edit-name' and @name='name']")
	
	WebElement loginField;
	
	
	@FindBy(xpath="//input[@id='edit-pass' and @name='pass']")
	
	WebElement passwordfield;
	
	
	
	@FindBy(xpath="//input[@id='edit-submit' and @value='Sign In']")
	
	WebElement signIN;
	
	
	public LoginPage() {
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void login(String username, String password) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickOnCrossIcon.click();
		clickonLoginIcon.click();
		loginField.sendKeys(username);
		passwordfield.sendKeys(password);
		
		signIN.click();
		
		
		//return new StudentDashBoard();
		
	}
	
}
