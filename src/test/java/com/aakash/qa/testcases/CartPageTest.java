package com.aakash.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.CartPage;
import com.aakash.qa.pages.CoursesPage;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.pages.LoginPage;
import com.aakash.qa.pages.SearchedCoursePage;
import com.aakash.qa.utill.DataProviderClass;
import com.aakash.qa.utill.TestUtilAakash;

public class CartPageTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homePage;
	CoursesPage coursesPage;
	TestUtilAakash aakashutil;
	static String sheetName1 = "Eng";
	SearchedCoursePage searchedPage;
	CartPage cartpage;

	public CartPageTest() {

		super();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialaztion();
		homePage = new HomePage();
		aakashutil = new TestUtilAakash();
		aakashutil.switchframe();
		homePage.clickOnCrossIcon();
		aakashutil.defaultframe();
		homePage.clickOnCourseLink();
		coursesPage = new CoursesPage();
		coursesPage.clickonEngineering();
		searchedPage = new SearchedCoursePage();
		cartpage = new CartPage();
		loginpage = new LoginPage();


	}

	@Test(priority = 1, dataProvider = "getEngineeringData", dataProviderClass = DataProviderClass.class)

	public void validateCheckOut(String chooseClass, String chooseState, String chooseCenters)
			throws InterruptedException {
		coursesPage.selectEngineeringcourses(chooseClass, chooseState, chooseCenters);
		coursesPage.clickOnSearchedCourses();
		searchedPage.clickOnPayRegistration();
		cartpage.clickOnProceedToCheckOut();
		loginpage.login(prop.getProperty("user_name"), prop.getProperty("password"));

		System.out.println("Successfully reach on Login page");

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}
	
}
