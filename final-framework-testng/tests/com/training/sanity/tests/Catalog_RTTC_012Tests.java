package com.training.sanity.tests;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_CategoriesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Catalog_RTTC_012Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_CategoriesPOM Catalog_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver); 
		Catalog_POM = new Retail_CategoriesPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}

	@Test(priority = 1)
	public void validLoginTest() {
		LoginPOM.sendUserName("admin");
		LoginPOM.sendPassword("admin@123");
		LoginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC012");
	}

	@Test(priority = 2)
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
	public void tearDown() throws InterruptedException {
		driver.quit(); }

}

