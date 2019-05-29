package com.training.sanity.tests;






import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Catalog_RTTC_012POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Catalog_RTTC_012Tests {

	private WebDriver driver;
	private String adminURL;
	private Catalog_RTTC_012POM Catalog_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority = 1)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Catalog_POM = new Catalog_RTTC_012POM(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}



	
	@Test(priority = 2)
	public void validLoginTest() {
		Catalog_POM.sendUserName("admin");
		Catalog_POM.sendPassword("admin@123");
		Catalog_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC012");
	}

	@Test(priority = 3)
	public void CatalogTest() {

		Catalog_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		Catalog_POM.categoryButton();
		screenShot.captureScreenShot("Categories contents are displayed");
		String expected = "Categories";
		String title = driver.getTitle();
		assertEquals(expected,title);
	}

	@AfterClass
	public void tearDown() throws InterruptedException  {
		Thread.sleep(1000);
		driver.quit();
	}
}




