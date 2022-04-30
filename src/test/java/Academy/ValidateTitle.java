package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver initialized");
		log.error("Driver initialized");
		log.fatal("Driver initialized");
		log.debug("Driver initialized");
		log.info("Browser invoking ");
		driver.get(prop.getProperty("url"));
		
		log.info("Landing page Displayed");
	}

	@Test
	public void validateAppTitle() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		LandingPage lp = new LandingPage(driver);
		log.info("Validating the Title of Landinhg Page");
		Assert.assertEquals("Featured Courses1", lp.getTitle().getText());
		log.info("Title displayed Successfully");
			
	}
	@AfterTest
	public void teardown()
	{		log.error("Driver closing");
		log.info("Driver closing");
		driver.close();
		log.info("Driver closed");
		
	}
	
}
