package com.aakash.qa.utill;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.aakash.qa.base.TestBase;

public class DataProviderClass extends TestBase {

	TestUtilAakash aakashutil;
 static String sheetName1 = "Eng";
	
	@DataProvider(name = "getEngineeringData")

	public static Object[][] getEngineeringData() throws InvalidFormatException {

		Object data[][] = TestUtilAakash.getAakashTestData(sheetName1);

		return data;
	}
	
}
