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
import resources.base;

public class ValidateNavigationBar extends base{
	public WebDriver driver;
	static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
			@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver initialized");
		log.error("Driver initialized");
		log.info("Browser invoking ");
		driver.get(prop.getProperty("url"));
		log.info("Landing page Displayed");
	}

	@Test
	public void validateNavigationBar() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		LandingPage lp = new LandingPage(driver);
		log.info("Checking if Navigation Bar displayed");
		//Validating Nav Bar
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar displayed successfully");
		
			
	}
	@AfterTest
	public void teardown()
	{
		log.error("Driver closing");
		log.info("Closing driver");
		driver.close();
		log.info("Driver closed successfully");
	}
}
