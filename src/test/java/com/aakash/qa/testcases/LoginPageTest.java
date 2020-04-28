package com.aakash.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.CoursesPage;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.pages.LoginPage;
import com.aakash.qa.utill.TestUtilAakash;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	// CoursesPage coursesPage;
	TestUtilAakash aakashutil;

	public LoginPageTest() {

		super();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialaztion();
		homePage = new HomePage();
		aakashutil = new TestUtilAakash();
		loginpage = new LoginPage();
		 aakashutil.switchframe();
		 homePage.clickOnCrossIcon();
		 aakashutil.defaultframe();

	}

	@Test(priority = 1)

	public void loginTest() throws InterruptedException {

		loginpage.clickonIcons();
		aakashutil.swicthLoginPageFrame();

		loginpage.loginPageFrameClick();

		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
