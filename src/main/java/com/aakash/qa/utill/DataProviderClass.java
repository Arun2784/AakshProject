package com.aakash.qa.utill;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.aakash.qa.base.TestBase;

public class DataProviderClass extends TestBase {

	TestUtilAakash aakashutil;
	static String sheetName1 = "Eng";
	static String sheetName2 = "test";

	@DataProvider(name = "getEngineeringData")

	public static Object[][] getEngineeringData() throws InvalidFormatException {

		Object data[][] = TestUtilAakash.getAakashTestData(sheetName1);

		return data;
	}
}

//	@DataProvider(name = "shippingInformation")
//
//	public static Object[][] Get_Shipping_Information() throws InvalidFormatException {
//
//		Object data1[][] = TestUtilAakash.fill_final_shipping(sheetName2);
//		return data1;
//	}

//	@DataProvider(name = "mergeDataProvider")
//
//	public static Object[][] mergerDataProvider() throws InvalidFormatException {
//		return combine(getEngineeringData(), fill_shipping_information());
//
//	}
//
//	public static Object[][] combine(Object[][] a1, Object[][] a2) {
//		List<Object[]> objectCodesList = new LinkedList<Object[]>();
//		for (Object[] o : a1) {
//			for (Object[] o2 : a2) {
//				objectCodesList.add(concatAll(o, o2));
//			}
//		}
//		return objectCodesList.toArray(new Object[0][0]);
//	}
//
//	@SafeVarargs
//	public static <T> T[] concatAll(T[] first, T[]... rest) {
//		// calculate the total length of the final object array after the concat
//		int totalLength = first.length;
//		for (T[] array : rest) {
//			totalLength += array.length;
//		}
//		// copy the first array to result array and then copy each array completely to
//		// result
//		T[] result = Arrays.copyOf(first, totalLength);
//		int offset = first.length;
//		for (T[] array : rest) {
//			System.arraycopy(array, 0, result, offset, array.length);
//			offset += array.length;
//		}
//
//		return result;
//	}

