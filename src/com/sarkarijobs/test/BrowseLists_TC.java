package com.sarkarijobs.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BrowseLists_TC {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://naukri.sarkari.jobs");
		driver.manage().window().maximize();
	}
	
	
	/*@Test
	public void testBrowseJobsByLocation() {

		driver.findElement(By.xpath(".//*[@id='all-jobs-location']")).click();
		List<WebElement> states = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'state-')]"));
		int statesCount = states.size();
		System.out.println("State locations are :" + statesCount);
		
		for (int i = 0; i < statesCount; i++) {
			System.out.println("i: "+ i);
			WebElement state = driver.findElements(By.xpath("//div[@class='browse-info']//a[starts-with(@id,'state-')]")).get(i);
			System.out.println("Statewise Sarkari Naukri :"+ state.getText());
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
	}*/
	
	
	/*@Test
	public void testBrowseJobsByProfession() {
		
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
			if (isElementPresent(byCount)) {
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
	}*/
	
	
	@Test
	public void testBrowseAllJobs() {
		driver.findElement(By.xpath(".//*[@id='browse-all-jobs']")).click();
		WebElement jobCount = driver.findElement(By.xpath(".//div[contains(@class, 'search-rgt-stat')]//span[@class='count']"));
		System.out.println("Job Count: "+ Integer.parseInt(jobCount.getText()));
		List<WebElement> employmentTypes = driver.findElements(By.xpath(".//*[@id='filterForm']//label[contains(@for, 'employmentType')]"));
		int sumOfJobs = 0;
		for(WebElement employmentType: employmentTypes) {
			String eTypeText = employmentType.getText();
			System.out.println("Employment Type: "+ eTypeText);
			int startIndex= eTypeText.lastIndexOf('(')+1;
			int endIndex = eTypeText.lastIndexOf(')');
			sumOfJobs = sumOfJobs + Integer.parseInt(eTypeText.substring(startIndex, endIndex));
		}
		System.out.println("Sum of job count of all Employment Types: "+ sumOfJobs);
		Assert.assertEquals(sumOfJobs, Integer.parseInt(jobCount.getText()));
	}
	
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("$$$$$ NOSUCHELEMENTEXCEPTION  $$$$$");
			return false;
		}
	}
	
}
