package com.sarkarijobs.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CannedSearch_TC {
	
	WebDriver driver;
	int i;
	
	@BeforeTest
	public void beforeTest(){
		
		driver = new FirefoxDriver();
		// driver.get("https://naukri.sarkari.jobs/jobs-by-post");
		// driver.get("https://naukri.sarkari.jobs/jobs-by-locations");
		driver.get("https://naukri.sarkari.jobs");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void testPopularJobsByState() {
		driver.findElement(By.xpath(".//a[@id='all-jobs-post' and contains(text(), 'View all States')]")).click();
		List<WebElement> states = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'state-')]"));
		int statesCount = states.size();
		System.out.println("State locations are :" + statesCount);
		
		for (int i = 0; i < statesCount; i++) {
			System.out.println("i: "+ i);
			WebElement state = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'state-')]")).get(i);
			System.out.println("Statewise Sarkari Naukri :"+state.getText());
			String stateText = state.getText();
			int startIndex= stateText.lastIndexOf('(')+1;
			int endIndex=state.getText().lastIndexOf(')');
			String jobCount= stateText.substring(startIndex, endIndex);
			state.click();
			
			By byCount = By.xpath("//div[contains(@class,'search-rgt-stat')]//span[@class='count']");
			String jobCount2 = null;
			By byNoResults = By.xpath("//div[contains(@class,'search-rgt-stat')]//p[contains(text(), 'No results found')]");
			if(isElementPresent(byCount)) {
				WebElement jobCountEl = driver.findElement(byCount);
				jobCount2 = jobCountEl.getText();
				
			} else {
				WebElement noResults = driver.findElement(byNoResults);
				String noResultsText = noResults.getText();
				if(noResultsText.equalsIgnoreCase("No Results Found")) {
					jobCount2 = "0";
				}
			}
			// Assert.assertEquals(jobCount2, jobCount);
			System.out.println("Job Count displayed in Link:" + jobCount);
			System.out.println("Job Count displayed in Detail page:" + jobCount2);
			if(Integer.parseInt(jobCount2) == Integer.parseInt(jobCount)) {
				System.out.println("Jobs count MATCH for "+ stateText.substring(0, stateText.lastIndexOf("(")));
			} else {
				System.out.println("JOBS COUNT DO NOT MATCH FOR "+ stateText.substring(0, stateText.lastIndexOf("(")));
			}
			// TODO: Verify if the location for each job belongs to the State selected.
			// driver.navigate().to("https://naukri.sarkari.jobs/jobs-by-locations");
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
		}
	}

	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e) {
			System.out.println("***Exception Caught******");
			return false;
		}
	}
	
	
	@Test
	public void testPopularJobsByProfession() {
		
		// driver.findElement(By.xpath("//a[contains(text(),'See Government Jobs by Preferred Profession')]")).click();
		driver.findElement(By.xpath(".//a[@id='all-jobs-post' and contains(text(), 'View all Professions')]")).click();
		List<WebElement> professions = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'posttype-')]"));
		int professionsCount =professions.size();
		System.out.println("Professions Sarkari Naukri Count:" +professionsCount);
		for (int j = 0; j < professionsCount; j++) {
			System.out.println("j: "+ j);
			WebElement profession = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'posttype-')]")).get(j);
			System.out.println("Professions Sarkari Naukri :" +profession.getText());
			String professionText = profession.getText();
			int startIndex = professionText.lastIndexOf('(')+1;
			int endIndex = profession.getText().lastIndexOf(')');
			String professionCount = professionText.substring(startIndex, endIndex);
			profession.click();
			
			By byCount = By.xpath("//div[contains(@class,'search-rgt-stat')]//span[@class='count']");
			String professionCount2 = null;
			By byNoResults = By.xpath("//div[contains(@class,'search-rgt-stat')]//p[contains(text(), 'No results found')]");
			if (isElementPresent1(byCount)) {
				WebElement professionCountE1 = driver.findElement(byCount);
				professionCount2= professionCountE1.getText();
			} else {
				WebElement noResults = driver.findElement(byNoResults);
				String noResultsText = noResults.getText();
				if (noResultsText.equalsIgnoreCase("No Results Found")) {
					professionCount2= "0";
				}
			}
		
			System.out.println("Job Count displayed in Link:" +professionCount);
			System.out.println("Job Count displayed in Detail page:" + professionCount2);
			if (Integer.parseInt(professionCount2) == Integer.parseInt(professionCount)) {
				System.out.println("JOBS COUNT MATCH FOR " +professionText.substring(0,professionText.lastIndexOf("(")));
			} else {
				System.out.println("JOBS COUNT DO NOT MATCH FOR "+ professionText.substring(0, professionText.lastIndexOf("(")));
			}
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
		}
	}
		
		
	private boolean isElementPresent1(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("$$$$$ NOSUCHELEMENTEXCEPTION  $$$$$");
			return false;
		}
	}

	
	@Test
	public void testPopularCategory() {
		////ul[@class='td-pb-padding-side']//a[starts-with(@href,'https://naukri.sarkari.jobs/articles/category/')]
		
		//driver.findElement(By.xpath("//ul[@class='td-pb-padding-side']//a")).click();
		List<WebElement> popularCats =driver.findElements(By.xpath("//ul[@class='td-pb-padding-side']//a"));
		int popularCatsCount = popularCats.size();
		System.out.println("Popular Category Count is :" +popularCatsCount);
		for (int k = 0; k < popularCatsCount; k++) {
			System.out.println("k :" +k);
			WebElement popularCat = driver.findElements(By.xpath("//ul[@class='td-pb-padding-side']//a")).get(k);
			System.out.println("Popular Category :" +popularCat.getText());
			popularCat.click();
			String Title=driver.getTitle();
			System.out.println("Title is :"+Title);
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
	}
	
	
}
	