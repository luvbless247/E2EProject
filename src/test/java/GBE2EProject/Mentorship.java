package GBE2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryy.base;
import pageObject.HomePageQA;


public class Mentorship extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
	}
	

	@Test
	public void MyMentorship() 
	{   
		//log.info("MENTORSHIP PAGE");
		HomePageQA home=new HomePageQA(driver);
		home.getmentor().click();
		log.info("MENTORSHIP PAGE IS ACCESSED");
		String mentor=driver.findElement(By.cssSelector("div[class='inner-box'] h1")).getText();
		Assert.assertEquals(mentor, "MENTORSHIP");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
