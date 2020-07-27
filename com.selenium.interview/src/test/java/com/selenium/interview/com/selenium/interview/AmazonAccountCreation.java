package com.selenium.interview.com.selenium.interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonAccountCreation {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//A_R_COMPUTERS//Desktop//chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser is launching");
		}
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://Users//A_R_COMPUTERS//Desktop//geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("firefox Browser is launching");
		}
		if (browser.equalsIgnoreCase("iexplore")) {
			System.setProperty("webdriver.ie.driver", "C://Users//A_R_COMPUTERS//Desktop//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Internet Explorer Browser is launching");
		}
	}

	@Test
	public void amazonAccountCreation() throws IOException, InterruptedException {
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("nav-flyout-ya-signin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(RandomStringUtils.randomAlphanumeric(8));
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		System.out.println("EmailID is not Registered");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='createAccountSubmit']"))).click();
		FileInputStream fis = new FileInputStream("C://Users//A_R_COMPUTERS//Desktop//Interview.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		String customerName = sheet.getRow(0).getCell(0).getStringCellValue();
		String customerMobileNumber = sheet.getRow(1).getCell(0).getStringCellValue();
		String customerEmailId = sheet.getRow(2).getCell(0).getStringCellValue();
		String customerPassword = sheet.getRow(3).getCell(0).getStringCellValue();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_customer_name"))).sendKeys(customerName);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_phone_number"))).sendKeys(customerMobileNumber);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email"))).sendKeys(customerEmailId);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_password"))).sendKeys(customerPassword);
		driver.findElement(By.id("continue")).click();
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Browser is getting closed");
		driver.quit();
	}
}
