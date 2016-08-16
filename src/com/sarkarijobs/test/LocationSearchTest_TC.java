package com.sarkarijobs.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocationSearchTest_TC {
	
	WebDriver driver;
	
	@Test
	public void testSearchByCity() {
		// Enter city
		driver.findElement(By.xpath(".//*[@id='search-location']")).sendKeys("Bangalore");
		// Click Search button
		driver.findElement(By.xpath(".//*[@id='btn-search']")).click();
		// Verify title of Search Results page
		String resultsPageTitle = driver.getTitle();
		System.out.println("Search Results page title:" + resultsPageTitle);
		// Verify Search results
		List<WebElement> locations = driver.findElements(By.xpath(".//*[starts-with(@id, 'jobcard-')]/a/div/div[1]/div/div[2]/h3[2]/span"));
		for(WebElement loc: locations) {
			if(!loc.getText().equalsIgnoreCase("Bangalore")) {
				Assert.fail();
			}
		}
		System.out.println("No. of Locations:"+locations.size());
		
		driver.navigate().back();
	}
	
/*	@Test
	public void testSearchByCityAutoComplete() {
		driver.findElement(By.xpath(".//*[@id='search-location']")).sendKeys("hyderabad");
		driver.findElement(By.xpath(".//*[contains(@class, 'ui-autocomplete')]/li[0]")).click();
		driver.findElement(By.xpath(".//*[@id='btn-search']")).click();
	}*/
	
	
	@Test
	public void testSearchByState() {
		
		driver.findElement(By.id("search-location")).sendKeys("ANDHRAPRADESH");
		driver.findElement(By.id("btn-search")).click();
	}

	@Test
	public void testSearchBySpecialEntry() {
		
	}
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\AUTOMATION\\chromedriver.exe");
		driver = new ChromeDriver();*/
		driver.get("https://naukri.sarkari.jobs/");
		driver.manage().window().maximize();
		// WebElement dialog = driver.findElement(By.xpath(""));
		// Check if modal dialog is present. 
		// If present, click Close icon. 
	}

	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
