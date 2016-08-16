
//Is next and previous page working\\
package com.sarkarijobs.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pagination_TC {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		
		driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs/");
		//driver.get("https://naukri.sarkari.jobs/government-jobs-andhra-pradesh");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testPagination() {
		
		// Click on Browse All, or Location Search or any other search
		
		// Search results page will be displayed
		driver.findElement(By.xpath(".//*[@id='browse-all-jobs']/span")).click();
		WebElement element = driver.findElement(By.xpath(".//*[@id='searchResults']/div[1]/div[2]/div[4]/div/div[1]/div/p"));
		String elementText = element.getText();
		System.out.println("Element Text: "+ elementText);
		String pageBoundaries = elementText.substring(0, elementText.indexOf("o")-1);
		System.out.println("pageBoundaries:"+ pageBoundaries);
		
		Assert.assertEquals(pageBoundaries, "1 - 15");
		
		driver.findElement(By.xpath(".//*[@id='load-more']/span[contains(text(), 'Next Page')]")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='searchResults']/div[1]/div[2]/div[4]/div/div[1]/div/p"));
		String elementText2 = element2.getText();
		System.out.println("Element Text 2: "+ elementText2);
		String pageBoundaries2 = elementText2.substring(0, elementText2.indexOf("o")-1);
		System.out.println("pageBoundaries2:"+ pageBoundaries2);
		
		Assert.assertEquals(pageBoundaries2, "16 - 30");
		driver.findElement(By.xpath(".//*[@id='load-more']/span")).click();
		System.out.println("PREV PAGE and NEXT PAGE Buttons are working fine");
		
		
	}
	
	@AfterTest
	
	public void afterTest(){
		
		//driver.close();
	}
	

}
