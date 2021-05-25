package GBE2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import libraryy.ReadFromExcel;
import libraryy.base;
import pageObject.HomePageQA;


public class LoginPageExcel extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	
	@Test(dataProvider="data")
	public void getLogin(String username, String password) throws IOException
	{
		
		driver= initializeDriver();
		
		HomePageQA home=new HomePageQA(driver);
		home.getLogin().click();
		//log.info("i have clicked on login successfully");
		home.getUserName().sendKeys(username);
		//log.info("i have entered username successfully");
		home.getPassword().sendKeys(password);
		//log.info("i have entered password successfully");
		home.getEnter().click();	
		Assert.assertEquals(driver.getTitle(), "Security Check");
		//driver.close();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="data")
	public Object[][] loginData() throws Exception{
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\libraryy\\logindetails.xlsx";
		ReadFromExcel eR= new ReadFromExcel(path);
		int read =eR.getSheet(0);
		
		Object[][] login= new Object[read][2];
		for(int i=0; i < read; i++) {
		{login[i][0]= eR.getData(0, i, 0);}	
		{login[i][1]= eR.getData(0, i, 1);}	
									}
		return login;
		
		
	}

}
