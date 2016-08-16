package com.sarkarijobs.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UI_TC {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs/free-job-alerts");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void testRadioButton(){
		
		////label[@class='ng-binding']
		
	List<WebElement> buttons = driver.findElements(By.xpath("//label[@class='ng-binding']"));
	 System.out.println(buttons.size());
	 for (int i = 0; i < buttons.size(); i++) {
		
	
	 WebElement button = driver.findElement(By.xpath("//label[@class='ng-binding']"));
	 button.click();
	 System.out.println(button);
	 
	 }
}
}
