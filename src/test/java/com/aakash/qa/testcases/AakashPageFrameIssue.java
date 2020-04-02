package com.aakash.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.HomePage;

public class AakashPageFrameIssue extends TestBase {

	//HomePage homePage;
	//Testutill util;

	public AakashPageFrameIssue() {

		super();

	}

	@BeforeMethod

	public void setup() throws InterruptedException {

		initialaztion();

		//homePage = new HomePage();
		//util = new Testutill();
		//util.switchframe();
		//homePage.clickOnCrossIcon();
	}

	@Test(enabled = true)
	public void testAakash() throws InterruptedException {

		System.out.println(" *** Test Method One  *** ");
// Putting wait to close frame popup manually
		Thread.sleep(50);

		driver.findElement(By.xpath("//a[text()='COURSES']")).click();
		System.out.println(" *** Clicked at Course link successfully  *** ");

	}

	@AfterTest
	public void tearDown() {

//driver.quit();
		System.out.println(" *** Closing browser, Execution finished *** ");

	}

}