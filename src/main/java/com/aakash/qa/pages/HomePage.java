package com.aakash.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aakash.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[contains(@class,'icon close')]")

	WebElement clickOnCrossIcon;

	@FindBy(xpath = "//a[contains(text(),'CENTRES')]")

	WebElement centersLink;

	//@FindBy(xpath = "//a[contains(@class,'class-crs')]")

	@FindBy(xpath="//a[contains(text(),'COURSES')]")

	WebElement coursesLink;

	@FindBy(xpath = "//a[contains(text(),'RESULTS']")

	WebElement resultsLink;

	@FindBy(xpath = "//a[contains(text(),'STUDENT'S CORNER')]")

	WebElement studentcorner;

	@FindBy(xpath = "//img[contains(@alt,'Home')]")

	WebElement aakashLogo;

	public HomePage() {

		PageFactory.initElements(driver, this);

	}

	public void clickOnCrossIcon() throws InterruptedException {
		clickOnCrossIcon.click();

	}

	public String verifyHomeTitle() {

		return driver.getTitle();

	}

	public boolean verifyAakashLogo() {

		return aakashLogo.isDisplayed();

	}

	public CoursesPage clickOnCourseLink() throws InterruptedException {

		Thread.sleep(50);
		coursesLink.click();
		return new CoursesPage();

	}

}
