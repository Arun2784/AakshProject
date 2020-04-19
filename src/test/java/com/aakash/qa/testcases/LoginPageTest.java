package com.aakash.qa.testcases;

import org.testng.annotations.AfterMethod;
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

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	TestUtilAakash util;
	HomePage homePage;
	SearchedCoursePage searchedPage;
	CartPage cartpage;
	CustomerDetailsPage customerdtl;

	public LoginPageTest() throws InterruptedException {

		super();

	}

	@BeforeMethod
	public void setup() throws InterruptedException {

		initialaztion();

		loginpage = new LoginPage();
		homePage = new HomePage();
		util = new TestUtilAakash();
		loginpage.clickonIcons();
		util.swicthLoginPageFrame();
		loginpage.loginPageFrameClick();
		util.defaultframe();
		searchedPage = new SearchedCoursePage();
		cartpage = new CartPage();
		customerdtl = new CustomerDetailsPage();

	}

	@Test(priority = 1)

	public void validateLoginPage() throws InterruptedException {

		loginpage.login(prop.getProperty("user_name"), prop.getProperty("password"));

		System.out.println("successfully login");
		
		homePage.clickOnCourseLink();
		searchedPage.clickOnPayRegistration();
		cartpage.clickOnProceedToCheckOut();
		//customerdtl.fill_shipping_information();
		
	}

//	@AfterMethod
//
//	public void tearDown() {
//
//		driver.quit();
//
//	}

}