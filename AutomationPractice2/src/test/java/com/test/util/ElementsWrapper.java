package com.test.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsWrapper {
	public final int MAX_TRY = 4;
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	
	public ElementsWrapper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	
	public void waitForElementVisible(WebElement webElement) {
		int retry_count = 0;
		while(retry_count<MAX_TRY) {
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
			return;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			retry_count++;
			continue;
		}
		}
		
		
	}
	
	

}
