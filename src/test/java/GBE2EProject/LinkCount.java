package GBE2EProject;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryy.base;
import pageObject.HomePageQA;

public class LinkCount extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void basePageNavigation() throws IOException 
	{
		driver= initializeDriver();
		//driver.get(prop.getProperty("url"));
		
	}
	@Test
	public void getLinkCount() 
	{
		
	//HomePageQA home=new HomePageQA(driver);
	int LinkSize= driver.findElements(By.tagName("a")).size();
	log.info("TOTAL OF LINKS:" +LinkSize);
	//System.out.println("TOTAL OF LINKS:" +LinkSize);
	List<WebElement> allLink=driver.findElements(By.tagName("a"));
	for(WebElement Link:allLink) {
	log.info("LINK TITLE IS:"+   Link.getText() + Link.getAttribute("href"));
	//System.out.println("LINK TITLE IS:"+   Link.getText() + Link.getAttribute("href"));
	}
	}
	
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
