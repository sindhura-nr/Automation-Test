package com.sarkarijobs.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class PopularSearches_TC {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\AUTOMATION\\chromedriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		driver.get("https://naukri.sarkari.jobs/");
		driver.manage().window().maximize();
	}
	@Test
	
	public void testPopularSearches() {
		List<WebElement> links = driver.findElements(By.xpath(".//a[starts-with(@id, 'canned-')]"));
		int linksCount = links.size();
		System.out.println("Popular Search Count is:" +linksCount);
		for(int i=0; i< linksCount; i++) {
			System.out.println("i :"+i);
			WebElement popsrch = driver.findElements(By.xpath(".//a[starts-with(@id, 'canned-')]")).get(i);
			System.out.println("Popular search :"+popsrch.getText());
			popsrch.click();
			WebElement count1 = driver.findElement(By.xpath(".//*[@id='searchResults']//span[@class='count']"));
			System.out.println("count is :" +count1.getText());
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
	}
	
} 
		
	


