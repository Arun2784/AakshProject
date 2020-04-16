package com.aakash.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.CartPage;
import com.aakash.qa.pages.CoursesPage;
import com.aakash.qa.pages.CustomerDetailsPage;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.pages.LoginPage;
import com.aakash.qa.pages.SearchedCoursePage;
import com.aakash.qa.utill.DataProviderClass;
import com.aakash.qa.utill.TestUtilAakash;

public class CustomerDetailsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	CoursesPage coursesPage;
	TestUtilAakash aakashutil;
	static String sheetName1 = "Eng";
	//static String sheetName2 = "test";
	SearchedCoursePage searchedPage;
	CartPage cartpage;
	CustomerDetailsPage customerdtl;
	String dateVal = "18-Nov-2000";

	public CustomerDetailsPageTest() {

		super();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialaztion();
		homePage = new HomePage();
		aakashutil = new TestUtilAakash();
		// aakashutil.switchframe();
		// homePage.clickOnCrossIcon();
		// aakashutil.defaultframe();
		homePage.clickOnCourseLink();
		coursesPage = new CoursesPage();
		coursesPage.clickonEngineering();
		searchedPage = new SearchedCoursePage();
		cartpage = new CartPage();
		loginpage = new LoginPage();
		customerdtl = new CustomerDetailsPage();

	}

	@Test(priority = 1, dataProvider = "getEngineeringData", dataProviderClass = DataProviderClass.class)

	public void validateCheckOut(String chooseClass, String chooseState, String chooseCenters,String stu_name,String stu_last)
			throws InterruptedException {
		coursesPage.selectEngineeringcourses(chooseClass, chooseState, chooseCenters);
		coursesPage.clickOnSearchedCourses();
		searchedPage.clickOnPayRegistration();
		cartpage.clickOnProceedToCheckOut();
		loginpage.login_purchase(prop.getProperty("user_name"), prop.getProperty("password"));
		System.out.println("Successfully reach on Login page");
		cartpage.clickOnProceedToCheckOut();
		customerdtl.fill_shipping_information(stu_name,stu_last);
	}
	
	
	
	

//	@AfterMethod
//
//	public void tearDown() {
//
//		driver.quit();
//
//	}

}