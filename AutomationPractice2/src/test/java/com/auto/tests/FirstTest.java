package com.auto.tests;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page.objects.DomesticPageObjects;
import com.setup.base.BaseClass;
import com.test.util.ElementsWrapper;
import com.test.util.ExcelUtils;

@Listeners(com.test.listeners.MyListeners.class)
public class FirstTest extends BaseClass{
	
	@Test
	public void TC001_submitForm() throws Exception {
		
		DomesticPageObjects pageObject = new DomesticPageObjects(driver);
		ExcelUtils excel = new ExcelUtils();
		XSSFRow row = excel.getRowData(1);
		pageObject.enterValueOnFullName(row);
		pageObject.enterEmailAddress(row);
		pageObject.enterAdress(row);
		pageObject.enternumberOfMembers(row);
		pageObject.enternumberOfDays(row);
		pageObject.clickOnsnacksOption();
		pageObject.clickprefferedStay();
		pageObject.selectFiveStarOption();
		pageObject.selectUSACountry();
		pageObject.clickonsubmitButton();
		String alertMessage = pageObject.getAlertMessage();
		assertEquals(alertMessage, "Form is submitted successfully");
		
	}

	@Test
	public void TC002_submitForm() throws Exception {
		
		DomesticPageObjects pageObject = new DomesticPageObjects(driver);
		ExcelUtils excel = new ExcelUtils();
		XSSFRow row = excel.getRowData(2);
		pageObject.enterValueOnFullName(row);
		pageObject.enterEmailAddress(row);
		pageObject.enterAdress(row);
		pageObject.enternumberOfMembers(row);
		pageObject.enternumberOfDays(row);
		pageObject.clickOnsnacksOption();
		pageObject.clickprefferedStay();
		pageObject.selectFiveStarOption();
		pageObject.selectUSACountry();
		pageObject.clickonsubmitButton();
		String alertMessage = pageObject.getAlertMessage();
		assertEquals(alertMessage, "Form is submitted successfully...");
		
	}
	@Test(dependsOnMethods = {"TC002_submitForm"})
	public void TC003_submitForm() throws Exception {
		
		DomesticPageObjects pageObject = new DomesticPageObjects(driver);
		ExcelUtils excel = new ExcelUtils();
		XSSFRow row = excel.getRowData(3);
		pageObject.enterValueOnFullName(row);
		pageObject.enterEmailAddress(row);
		pageObject.enterAdress(row);
		pageObject.enternumberOfMembers(row);
		pageObject.enternumberOfDays(row);
		pageObject.clickOnsnacksOption();
		pageObject.clickprefferedStay();
		pageObject.selectFiveStarOption();
		pageObject.selectUSACountry();
		pageObject.clickonsubmitButton();
		String alertMessage = pageObject.getAlertMessage();
		assertEquals(alertMessage, "Form is submitted successfully");
		
	}
}
