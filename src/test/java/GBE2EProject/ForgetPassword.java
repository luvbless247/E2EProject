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


public class ForgetPassword extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
	}
	@Test
	public void getForgetPasword() throws InterruptedException {
		String expected="We couldn't find an account with that email address";
		HomePageQA home= new HomePageQA(driver);
		home.getLogin().click();
		home.getForgetPassword().click();
		//Thread.sleep(3000);
		home.getEmailAddr().sendKeys("java@gmail.com");
		home.getSendInstruction().click();
		Thread.sleep(1000);
		Assert.assertEquals(home.emailNotFound().getText(), expected);
		
		
		
}
	
@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
}
