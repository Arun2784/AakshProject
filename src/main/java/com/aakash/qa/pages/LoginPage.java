package com.aakash.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//div[contains(@class,'icon close')]")

	WebElement clickOnCrossIcon;

	@FindBy(xpath = "//nav[@id='block-useraccountmenu-3']")

	WebElement clickonLoginIcon;

	@FindBy(xpath = "//a[contains(text(),'Log In')]")

	WebElement clickonLogintext;

	@FindBy(xpath = "//div[contains(@class,'icon close')]")

	WebElement crossIcon;

	@FindBy(xpath = "//input[@id='edit-name' and @name='name']")

	WebElement loginField;

	@FindBy(xpath = "//input[@id='edit-pass' and @name='pass']")

	WebElement passwordfield;

	@FindBy(xpath = "//input[@id='edit-submit' and @value='Sign In']")

	WebElement signIN;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public void clickonIcons() throws InterruptedException {

		Thread.sleep(2000);
		// clickOnCrossIcon.click();
		clickonLoginIcon.click();

		Thread.sleep(3000);
		clickonLogintext.click();

	}

	public void loginPageFrameClick() throws InterruptedException {

//		int size = driver.findElements(By.tagName("iframe")).size();
//
//	    for(int i=0; i<=size; i++){
//		driver.switchTo().frame(i);
//		int total=driver.findElements(By.xpath("//img[@class='notimage clickable-element']")).size();
//		System.out.println(total);
		Thread.sleep(5000);
		crossIcon.click();

		System.out.println("Successfuly click on cross icon");

		// driver.switchTo().defaultContent();
	}

	public void login(String username, String password) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginField.sendKeys(username);
		passwordfield.sendKeys(password);

		signIN.click();

		// return new StudentDashBoard();

	}

}
