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

public class validation extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
	}
	@Test
	public void titleOfPage() 
	{
		//log.info("VALIDATION PAGE");
	HomePageQA home=new HomePageQA(driver);
	Assert.assertEquals(home.getTitlePage().getText(), "Featured Courses");
	log.info("Title page validation");
	//System.out.println("i am validation");
	
	
	
	/*String actual = home.getTitlePage().getText();
	String expected="FEATURED1 COURSES";
	if (expected.equalsIgnoreCase(actual))
	{
		log.info("VALIDATION PASSED");
	}
	else
	{
		log.info("VALIDATION FAILED");
	}*/
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
