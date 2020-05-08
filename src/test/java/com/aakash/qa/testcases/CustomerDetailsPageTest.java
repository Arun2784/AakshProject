package com.aakash.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.CartPage;
import com.aakash.qa.pages.CoursesPage;
import com.aakash.qa.pages.CustomerDetailsPage;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.pages.LoginPage;
import com.aakash.qa.pages.SearchedCoursePage;
import com.aakash.qa.utill.DataProviderClass;
import com.aakash.qa.utill.ExtentReportListner;
import com.aakash.qa.utill.TestUtilAakash;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CustomerDetailsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	CoursesPage coursesPage;
	TestUtilAakash aakashutil;
	static String sheetName1 = "Eng";
	// static String sheetName2 = "test";
	SearchedCoursePage searchedPage;
	CartPage cartpage;
	CustomerDetailsPage customerdtl;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public static ExtentTest logger;
	// ExtentReportListner extentReport;

	public CustomerDetailsPageTest() {

		super();

	}

	@BeforeTest
	public void setExtent() {

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ArunTesting.html");// +

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

	public void setup() throws InterruptedException {

		initialaztion();
		homePage = new HomePage();
		aakashutil = new TestUtilAakash();
		//aakashutil.switchframe();
//		homePage.clickOnCrossIcon();
//		aakashutil.defaultframe();
		homePage.clickOnCourseLink();
		coursesPage = new CoursesPage();
		coursesPage.clickonEngineering();
		searchedPage = new SearchedCoursePage();
		cartpage = new CartPage();
		loginpage = new LoginPage();
		customerdtl = new CustomerDetailsPage();
		// extentReport = new ExtentReportListner();

	}

	@Test(priority = 1, dataProvider = "getEngineeringData", dataProviderClass = DataProviderClass.class)

	public void validateCheckOut(String chooseClass, String chooseState, String chooseCenters, String stu_name,
			String stu_last, String Parent_name, String Parent_Mobile, String Parent_email, String street_address,
			String city, String pincode, String state) throws InterruptedException {

		logger = extent.createTest("Aakash Website Course Purchase Journey");
		coursesPage.selectEngineeringcourses(chooseClass, chooseState, chooseCenters);
		coursesPage.clickOnSearchedCourses();
		searchedPage.clickOnPayRegistration();
		cartpage.clickOnProceedToCheckOut();
		loginpage.login_purchase(prop.getProperty("user_name"), prop.getProperty("password"));
		System.out.println("Successfully reach on Login page");
		((JavascriptExecutor) driver).executeScript("scroll(0,300)");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//input[@type='submit' and @id='edit-checkout']")));
//		
		cartpage.clickOnProceedToCheckOut();
		Assert.assertEquals(driver.getTitle(), "Checkout | AESL");
		customerdtl.fill_shipping_information(stu_name, stu_last, Parent_name, Parent_Mobile, Parent_email,
				street_address, city, pincode, state);

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

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Testcase Passed" + result.getName());

		}

		driver.quit();
	}

	@AfterTest

	public void endreport() {

		extent.flush();

	}

}
