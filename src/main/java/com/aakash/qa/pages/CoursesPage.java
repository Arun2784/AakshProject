package com.aakash.qa.pages;

import java.util.concurrent.TimeUnit;

import javax.rmi.CORBA.Util;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aakash.qa.base.TestBase;

public class CoursesPage extends TestBase {

	@FindBy(xpath = "//label[contains(text(),'Medical')]")
	WebElement selectMedical;

	@FindBy(xpath = "//label[contains(text(),'Engineering')]")

	WebElement selectEngineering;

	@FindBy(xpath = "//label[contains(text(),'Foundation')]")

	WebElement selectFoundation;

	@FindBy(xpath = "//select[@class='form-select' and @name='field_product_classes']")

	WebElement AakashClasses;

	@FindBy(xpath = "//select[@class='form-select' and @name='field_notification_select_stream']")

	WebElement AakashState;

	@FindBy(xpath = "//select[@class='form-select' and @name='center_list_dropdown']")

	WebElement AakashCenter;

	@FindBy(xpath = "//input[@id='edit-submit-digital-product-search']")

	WebElement clickOnApply;

	@FindBy(xpath = " //div[@class='result-listing-wrapper']//div[1]//div[1]//div[1]//h3[1]//a[1]")

	WebElement selectSeacrhedCourses;

	public CoursesPage() {

		PageFactory.initElements(driver, this);

	}

//	public void selectMedicalcourses(int selectClasses, String selectState, String selectCenters) {
//
//		selectMedical.click();
//		Select classes = new Select(AakashClasses);
//
//		classes.selectByIndex(selectClasses);
//
//		Select state = new Select(AakashState);
//
//		state.selectByVisibleText(selectState);
//
//		Select centers = new Select(AakashCenter);
//
//		centers.selectByVisibleText(selectCenters);
//
//	}

	public void clickonEngineering() {

		selectEngineering.click();

	}

	public void selectEngineeringcourses(String selectClasses, String selectState, String selectCenters)
			throws InterruptedException {

		Thread.sleep(3000);

		Select classes1 = new Select(AakashClasses);

		classes1.selectByVisibleText(selectClasses);
		// classes.selectByIndex;

		Select state1 = new Select(AakashState);

		state1.selectByVisibleText(selectState);

		Thread.sleep(5000);
		// This will scroll the page till the element is found

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickOnApply);
		Thread.sleep(5000);

		Select centers1 = new Select(AakashCenter);

		centers1.selectByVisibleText(selectCenters);

		System.out.println("**********Before Click on Apply");

//		WebDriverWait wait = new WebDriverWait(driver, 5000);
//		wait.until(ExpectedConditions.visibilityOf(clickOnApply));
//		wait.until(ExpectedConditions.elementToBeClickable(clickOnApply));

		clickOnApply.click();

		System.out.println("**********After Click on Apply");

		// return new SearchedCoursePage();
	}

//	public void clicnOnApplyButton() throws InterruptedException {
//
//		System.out.println("**********Before Click on Apply");
//
//		
//		
//		//driver.manage().timeouts().implicitlyWait(Testutill.Implicit_wait, TimeUnit.SECONDS);
//
//		//Thread.sleep(5000);
//		
////		WebDriverWait wait = new WebDriverWait(driver, 5000);
////		wait.until(ExpectedConditions.visibilityOf(clickOnApply)); 
////		wait.until(ExpectedConditions.elementToBeClickable(clickOnApply));
//		clickOnApply.click();
//		
//		
//		//clickOnApply.click();

	// System.out.println("After click on Apply ***************");

//	}

	public void selectFoundatingcourses(int selectClasses, String selectState, String selectCenters) {

		selectFoundation.click();
		Select classes = new Select(AakashClasses);

		classes.selectByIndex(selectClasses);

		Select state = new Select(AakashState);

		state.selectByVisibleText(selectState);

		Select centers = new Select(AakashCenter);

		centers.selectByVisibleText(selectCenters);

	}

	public SearchedCoursePage clickOnSearchedCourses() throws InterruptedException {

		Thread.sleep(5000);

		System.out.println("clicking on Searched courses");

		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOf(selectSeacrhedCourses));
		wait.until(ExpectedConditions.elementToBeClickable(selectSeacrhedCourses));
		selectSeacrhedCourses.click();
		System.out.println("successfully clicked on Searched courses");

		return new SearchedCoursePage();

	}

}
