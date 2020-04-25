package com.aakash.qa.utill;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ScreenshotPractice {

	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;

	public ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	public void setExtent() {
	 
		

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");// +

		// avent = new ExtentAventReporter(System.getProperty("user.dir") +
		// "/test-output/ExtentReport.html");

		extent = new ExtentReports();

		extent.attachReporter(htmlreporter);

		extent.setSystemInfo("Hostname", "Arun-Windows10");
		extent.setSystemInfo("username", "Arun Kumar Pandey");
		extent.setSystemInfo("Environment", "QA-Aakash education Website");

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
		logger = extent.createTest("To verify Google Title");
		Assert.assertEquals(driver.getTitle(), "Google12");
	}

	@AfterMethod(alwaysRun = true)

	public void teardown() {

		driver.quit();

	}

	@AfterTest

	public void endreport() {

		extent.flush();

	}

}
