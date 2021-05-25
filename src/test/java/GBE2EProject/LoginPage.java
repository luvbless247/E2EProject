package GBE2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import libraryy.base;
import pageObject.HomePageQA;


public class LoginPage extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	/*@BeforeTest
	public void login() throws IOException 
	{
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
	}*/

	@Test(dataProvider="getData")
	public void getLogin(String username, String password) throws IOException
	{
		
		driver= initializeDriver();
		//log.info("Driver is initiated successfully");
		//driver.get(prop.getProperty("url"));
		//log.info("Homepage opened successfully");
		//driver.get("https://rahulshettyacademy.com/");
		HomePageQA home=new HomePageQA(driver);
		home.getLogin().click();
		log.info("i have clicked on login successfully");
		home.getUserName().sendKeys(username);
		log.info("i have entered username successfully");
		home.getPassword().sendKeys(password);
		log.info("i have entered password successfully");
		home.getEnter().click();	
		//driver.close();
	}
	/*@Test
	public void printu() {
		log.info("i am login page");
	}*/
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="non-restricted-user@gmail.com";
		data[0][1]="password1";
		
		
		data[1][0]="restricted-user@gmail.com";
		data[1][1]="password2";
		return data;
		
		
	}

}
