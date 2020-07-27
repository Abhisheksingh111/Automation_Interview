package com.selenium.interview.com.selenium.interview;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileAppTestingUsingAppium {
	@Test
	public void loginApp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, 9.0);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C://Users//A_R_COMPUTERS//Desktop//DummyApp.apk");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver androidDriver = new AndroidDriver(url, desiredCapabilities);
		androidDriver.get("https://ess-staging.ttconline.com/");
		androidDriver.findElement(By.xpath("//*[@id='username']")).sendKeys(RandomStringUtils.randomAlphanumeric(10));
		androidDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(RandomStringUtils.randomAlphanumeric(10));
		androidDriver.findElement(By.xpath("//*[@id='button']")).click();
		androidDriver.close();
	}
}
