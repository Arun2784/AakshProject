package com.aakash.qa.utill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.xpath.XPath;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aakash.qa.base.TestBase;

public class TestUtilAakash extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long Implicit_wait = 10;
	public static String TESTDATA_SHEET_PATH = "D:\\Core Java\\AakashWebsiteProject\\src\\main\\java\\com\\aakash\\qa\\testdata\\AakashProjectData.xlsx";
	static Workbook book;
	static Sheet sheet;;

	public void switchframe() {

		driver.switchTo().frame(1);
	}

	public void defaultframe() {

		driver.switchTo().defaultContent();
	}

	public void swicthLoginPageFrame() throws InterruptedException {

		// driver.switchTo().frame("//iframe[contains(@id,'container-notification-frame-5e8423aa8436de1ef2631200')]");
		Thread.sleep(5000);

		WebElement fram = driver.findElement(By.id("container-notification-frame-5e8423aa8436de1ef2631200"));
		driver.switchTo().frame(fram);
		System.out.println("Successfuly reach on frame");
	}
	
	
	public void chatwindowFrame() throws InterruptedException {

		
		Thread.sleep(3000);
		System.out.println("Starting for chat frame");
//		WebElement chatfram = driver.findElement(By.id("//div[@class='jx_ui_Widget chat_log_wrapper']"));
//		System.out.println("Successfully reach on chat windwo frame1");
//		driver.switchTo().frame(chatfram);
		
		driver.switchTo().frame(1);
		System.out.println("Successfully reach on chat windwo frame2");
	}
	
	

	public static Object[][] getAakashTestData(String sheetName1) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName1);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
}
