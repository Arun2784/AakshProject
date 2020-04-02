package com.aakash.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.utill.TestUtilAakash;

public class AakashHomePageTest extends TestBase {

	HomePage homePage;
	TestUtilAakash util;

	public AakashHomePageTest() {

		super();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialaztion();

		homePage = new HomePage();
		util = new TestUtilAakash();
		util.switchframe();
		homePage.clickOnCrossIcon();
		util.defaultframe();
	}
		/*
	

	@Test(priority = 1)

	public void verifyhomePageTitle() {

		String title = homePage.verifyHomeTitle();
		Assert.assertEquals(title, "Aakash Medical NEET/AIIMS UG Coaching-Engg IIT JEE Coaching | AESL");

	}

	/*
	 * @Test(priority = 2)
	 * 
	 * public void verifyAakashLogoTest() { boolean flag1 =
	 * homePage.verifyAakashLogo(); Assert.assertTrue(flag1);
	 * System.out.println("Ye code bhi mast hai");
	 * 
	 * 
	 * }
	 */
	
	
	
	@Test(priority = 2)

	public void clickOnCoursesLink() throws InterruptedException {
		
		homePage.clickOnCourseLink();

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
