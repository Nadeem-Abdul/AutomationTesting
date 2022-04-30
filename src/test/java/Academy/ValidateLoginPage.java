package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateLoginPage extends base{
	public WebDriver driver;
	static Logger log = LogManager.getLogger(ValidateLoginPage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver initialized");
		log.error("Driver initialized");
		log.info("Browser invoking ");
		driver.get(prop.getProperty("url"));
		log.info("Landing page Displayed");
		LandingPage lp = new LandingPage(driver);
		lp.signIn().click();
		
	}
	
	@Test(dataProvider="getData")
	public void validateLoginPage(String username,String password) throws IOException
	{	

		LoginPage loginpage = new LoginPage(driver);
		loginpage.getuserName().sendKeys(username);
		log.info("username Entered");
		log.info("username Entered");
		log.info("username Entered");
		log.info("username Entered");
		loginpage.getPass().sendKeys(password);
		log.info("Password Entered");
		loginpage.getLogin().click();
		log.info("Button clicked");
		//System.out.println(text);
	}
	
	 @DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Nonrestriucted@gmail.com";
		data[0][1] = "1646524";
		//data[0][0] = "Nonrestriucted user";
		
		data[1][0] = "Restriucted@gmail.com";
		data[1][1] = "1646524";
		//data[0][0] = "Restriucted user";
		return data;
	}
	 
	
	  @AfterTest public void teardown() 
	  { driver.close(); 
	  log.error("Driver Closed");
	  log.info("Driver Closed");
	  
	  }
	 
}
