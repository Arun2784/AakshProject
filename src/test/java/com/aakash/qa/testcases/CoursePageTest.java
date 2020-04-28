package com.aakash.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aakash.qa.base.TestBase;
import com.aakash.qa.pages.CoursesPage;
import com.aakash.qa.pages.HomePage;
import com.aakash.qa.utill.DataProviderClass;
import com.aakash.qa.utill.TestUtilAakash;

public class CoursePageTest extends TestBase {

	HomePage homePage;
	CoursesPage coursesPage;
	TestUtilAakash aakashutil;
	String sheetName1 = "Eng";

	public CoursePageTest() {

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

	}
	
//	@DataProvider
//
//	public Object[][] getEngineeringData() throws InvalidFormatException {
//
//		Object data[][] = TestUtilAakash.getAakashTestData(sheetName1);
//
//		return data;
//	}
		

		
		
	

	@Test(priority = 1, dataProvider = "getEngineeringData", dataProviderClass = DataProviderClass.class)

	public void engineering(String chooseClass, String chooseState, String chooseCenters, String stu_name,
			String stu_last, String Parent_name, String Parent_Mobile, String Parent_email, String street_address,
			String city, String pincode, String state) throws InterruptedException {

		coursesPage.selectEngineeringcourses(chooseClass, chooseState, chooseCenters);

		coursesPage.clickOnSearchedCourses();

		System.out.println("Successfully Click on search courses");
	}

//	@Test(priority = 1)
//
//	public void engineering() throws InterruptedException {
//
//		coursesPage.selectEngineeringcourses(prop.getProperty("classes"), prop.getProperty("state"),
//				prop.getProperty("centers"));
//
//		coursesPage.clicnOnApplyButton();
//
//		coursesPage.clickOnSearchedCourses();
//		
//		System.out.println("Successfully Click on search courses");
//
//	}

	@AfterMethod

	public void tearDown() {

		driver.quit();

	}

}
