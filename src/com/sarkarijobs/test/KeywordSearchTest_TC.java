package com.sarkarijobs.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeywordSearchTest_TC {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\AUTOMATION\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.ie.driver","C:\\Users\\user\\Desktop\\AUTOMATION\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testSearchByKeyword() {
		
		driver.findElement(By.xpath(".//*[@id='search-jobs']")).sendKeys("Doctors");
		driver.findElement(By.xpath(".//*[@id='btn-search']")).click();
		
	}
	
	@Test
	public void browsersTest() {
		
	}
	
}
