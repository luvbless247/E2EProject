package libraryy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
public WebDriver driver;
public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	    prop=new Properties();
	//FileInputStream fis= new FileInputStream("C:\\Users\\GB\\eclipse-workspace\\GBProject\\src\\main\\java\\libraryy\\data.properties");
	   String filepath=System.getProperty("user.dir")+"\\src\\main\\java\\libraryy\\data.properties";
	  FileInputStream fis= new FileInputStream(filepath);
		prop.load(fis);
		
		//String browserName=System.getProperty("browser");
		
		String browserName=prop.getProperty("browser");
		
		/*if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\browsers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.addArguments("headless");
			driver =new ChromeDriver(options);
		}*/
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\browsers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver =new ChromeDriver(options);
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\browsers\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			/*FirefoxOptions options= new FirefoxOptions();
			options.addArguments("headless");
			driver =new FirefoxDriver(options);*/
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\browsers\\msedgedriver.exe");
			//WebDriverManager.edgedriver().setup();
		
			driver=new EdgeDriver();	
		}
		
		else 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\browsers\\ChromeDriver.exe");
			//WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
		}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.get(prop.getProperty("url"));
	return driver;
	}
	
	public  String getScreenShot(String failedTestCaseName, WebDriver driver) throws IOException {
	String timestamp = new SimpleDateFormat("yy_MM_dd__hh_mm").format(new Date());
	TakesScreenshot shot=(TakesScreenshot)driver;
	File source=shot.getScreenshotAs(OutputType.FILE);
	String destFile=System.getProperty("user.dir")+"\\screenshot\\"+timestamp+ failedTestCaseName+".png";
	FileUtils.copyFile(source, new File(destFile));
	return destFile;
	}
}
