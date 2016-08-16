package com.sarkarijobs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Images_TC {
	
	WebDriver driver; 
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs");
		driver.manage().window().maximize();
	}
	
	/*
	@Test
	public void verifyImage() {
		WebElement image = driver.findElement(By.xpath(".//*[@id='index-banner']"));
		Boolean isImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				image);
		if (!isImagePresent) {
			System.out.println("Image is not displayed.");
		} else {
			System.out.println("Image is displayed.");
		}
	}
	*/
}
