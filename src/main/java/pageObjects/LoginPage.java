package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By userName = By.id("email");
	By pass = By.id("password");
	By login = By.xpath("//input[@type='submit']");
	
	public WebElement getuserName()
	{
		return driver.findElement(userName);
	}
	public WebElement getPass()
	{
		return driver.findElement(pass);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	
}
