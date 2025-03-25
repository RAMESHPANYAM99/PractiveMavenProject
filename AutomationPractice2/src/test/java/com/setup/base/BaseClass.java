package com.setup.base;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.page.objects.DomesticPageObjects;

public class BaseClass {
	
	public static WebDriver driver = null;
	
	@BeforeMethod
	public void baseSetup() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		
		DomesticPageObjects pageObject = new DomesticPageObjects(driver);
		driver.manage().window().maximize();
		driver.get("https://nichethyself.com/tourism/home.html");
		pageObject.clickoncustomiseTourButton();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window: allWindows) {
			if(!window.contentEquals(parentWindow)) {
				driver.switchTo().window(window);
				
			}
		}
		
		
	}
	
	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}
