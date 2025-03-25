package com.page.objects;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.util.ElementsWrapper;

public class DomesticPageObjects {
	public final int MAX_TRY = 4;
	public static WebDriver driver = null;
	public WebDriverWait wait = null;

	public DomesticPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ElementsWrapper wrapper = new ElementsWrapper(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@FindBy(xpath = "//form[@name='internationalf']/input[@name='name']")
	public WebElement fullNameField;

	@FindBy(xpath = "//form[@name='internationalf']/input[@name='email']")
	public WebElement emailAddressField;

	@FindBy(xpath = "//form[@name='internationalf']/textarea[@id='comment']")
	public WebElement addressField;

	@FindBy(xpath = "//form[@name='internationalf']/input[@name='members']")
	public WebElement numberOfMembers;

	@FindBy(xpath = "//form[@name='internationalf']/input[@name='days']")
	public WebElement numberOfDays;

	@FindBy(xpath = "(//label[@class='radio-inline'])[1]")
	public WebElement snacksOption;

	@FindBy(xpath = "//select[@class='form-control' and @id='days']")
	public WebElement prefferedStay;

	@FindBy(xpath = "//select[@class='form-control' and @id='days']//option[text()='5-star Hotel']")
	public WebElement fiveStarHotelOption;

	@FindBy(xpath = "//label[contains(text(), 'USA')]")
	public WebElement usaCountry;

	@FindBy(xpath = "//form[@name='internationalf']//button[text()='Submit']")
	public WebElement submitButton;

	@FindBy(xpath = "//a[text()='Customized tours']")
	public WebElement customiseTour;

	public void enterValueOnFullName(XSSFRow row) {
		fullNameField.sendKeys(row.getCell(0).toString());
	}

	public void enterEmailAddress(XSSFRow row) {
		emailAddressField.sendKeys(row.getCell(1).toString());
	}

	public void enterAdress(XSSFRow row) {
		addressField.sendKeys(row.getCell(2).toString());
	}

	public void enternumberOfMembers(XSSFRow row) {
		numberOfMembers.sendKeys(row.getCell(3).toString());
	}

	public void enternumberOfDays(XSSFRow row) {
		numberOfDays.sendKeys(row.getCell(4).toString());
	}

	public void clickOnsnacksOption() {
		snacksOption.click();
	}

	public void clickprefferedStay() {
		prefferedStay.click();
	}

	public void selectFiveStarOption() {
		fiveStarHotelOption.click();
	}

	public void selectUSACountry() {
		usaCountry.click();
	}

	public void clickonsubmitButton() {
		submitButton.click();
	}

	public void clickoncustomiseTourButton() {
		waitForElementVisible(customiseTour);
		customiseTour.click();
	}

	public void waitForElementVisible(WebElement webElement) {
		int retry_count = 0;
		while (retry_count < MAX_TRY) {
			try {
				wait.until(ExpectedConditions.visibilityOf(webElement));
				return;

			} catch (Exception e) {
				e.printStackTrace();
				retry_count++;
				continue;
			}
		}

	}

	public String getAlertMessage() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}

}
