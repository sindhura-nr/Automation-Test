package com.sarkarijobs.test;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Carousels_TC {
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs/");
		driver.manage().window().maximize();
		
		
	}
	
	@Test 
	public void testRecentCarousel() { 
	
		List<WebElement> RecentLists = driver.findElements(By.xpath(".//*[@id='jobSlider']/div/div[1]"));
	    int	RecentListsCount=RecentLists.size();
	    System.out.println("CAROUSEL IS :" +RecentListsCount);
	    
	    ////div[@class='result-list ng-scope']
		
	}

}
