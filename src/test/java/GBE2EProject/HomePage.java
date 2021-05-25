package GBE2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryy.base;


public class HomePage extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}
	@Test
	public void getTitled() {
		log.info("GET first TEXT:" + driver.getTitle());
		//log.info("GET first url:"+ driver.getCurrentUrl());
		//System.out.println("i am homepage");
		log.info("i have extracted title of the page successfully");
		
}
	
@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
