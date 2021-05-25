package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageQA {

	public WebDriver driver;
	
	//By signIn= By.xpath("//span[normalize-space()='Login']");
	//validate login credentials
	private By signIn= By.cssSelector("a[href*='sign_in']");
	private By userName=By.name("user[email]");
	private By passWord=By.id("user_password");
	private By login=By.xpath("//input[@type='submit']");
	//Title page
	private By title= By.cssSelector("div[class='pull-left'] h2");
	//navigation bar showing or present
	private By navigate= By.cssSelector("div[class='nav-outer clearfix'] ul[class='navigation clearfix']");
	
	//forget passord
	private  By forgetP= By.className("link-below-button");
	private  By emailAddres=By.cssSelector("input[placeholder='name@example.com']");
	private  By sendEmail=By.name("commit");
	private By emailNotFd=By.cssSelector("div[class *='control-input'] span");
	
	//validate mentorship session
	private	By mentor=By.linkText("Mentorship");
	
	
	
	public HomePageQA(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	//validate login credentials
	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}	
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}	
	
	public WebElement getPassword()
	{
		return driver.findElement(passWord);
	}
	public WebElement getEnter()
	{
		return driver.findElement(login);
	}
	//mentorship page
	public WebElement getmentor()
	{
		return driver.findElement(mentor);
	}	
	
	//title page
	public WebElement getTitlePage()
	{
		return driver.findElement(title);
	}	
	//navigation bar
		public WebElement getNavigate()
		{
			return driver.findElement(navigate);
		}	
		//forget password
		public WebElement getForgetPassword()
		{
			return driver.findElement(forgetP);
		}
		public WebElement getEmailAddr()
		{
			return driver.findElement(emailAddres);
		}
		public WebElement getSendInstruction()
		{
			return driver.findElement(sendEmail);
		}
		//forgetpassword-email not found
		public WebElement emailNotFound()
		{
			return driver.findElement(emailNotFd);
		}	
}
