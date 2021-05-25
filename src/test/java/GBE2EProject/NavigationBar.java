package GBE2EProject;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryy.base;
import pageObject.HomePageQA;

public class NavigationBar extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void NavigationBarr()
	{
	//log.info("NAVIGATION BAR");
	HomePageQA home=new HomePageQA(driver);
	Assert.assertTrue(home.getNavigate().isDisplayed());
	log.info("NAVIGATION BAR IS DISPLAYED");
	//System.out.println("i am navigation page");
	
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
