
package com.aakash.qa.utill;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportListner implements IReporter {

	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	public void setExtent() {

		htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/ExtentReport_screenshot.html");// +
																								// "/test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "Arun-Windows10");
		extent.setSystemInfo("username", "Arun Kumar Pandey");
		extent.setSystemInfo("Environment", "QA-Aakash education Website");

		// avent.getConfigurationStore().s
	}

	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		// String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/FailedScreenshot/" + System.currentTimeMillis()
				+ ".png";

		File finaldestination = new File(destination);

		FileUtils.copyFile(src, finaldestination);

		return destination;

	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium Training\\chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void verifyTitle() {
		logger = extent.createTest("verifyTitle");
		Assert.assertEquals(driver.getTitle(), "Google12");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			logger.log(Status.FAIL, "TestCase Failed" + result.getName());// To Add name in extent report
			logger.log(Status.FAIL, "TestCase Failed" + result.getThrowable());// To Add error/exception in
																				// extent report
			String screnshotPath = ExtentReportListner.getScreenShot(driver, result.getName());

			logger.log(Status.FAIL, result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screnshotPath).build());

		}

		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Testcase Skipped" + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.PASS, "Testcase Skipped" + result.getName());

		}
		driver.quit();
	}

	@AfterTest

	public void endreport() {

		extent.flush();

	}
}
