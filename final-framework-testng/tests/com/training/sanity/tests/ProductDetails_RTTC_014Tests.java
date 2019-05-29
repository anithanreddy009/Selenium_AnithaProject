package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ProductDetails_RTTC_014POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class ProductDetails_RTTC_014Tests {

	private WebDriver driver;
	private String adminURL;
	private ProductDetails_RTTC_014POM ProductDetails_POM;
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
		ProductDetails_POM = new ProductDetails_RTTC_014POM(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}



	
	@Test(priority = 2)
	public void validLoginTest() {
		ProductDetails_POM.sendUserName("admin");
		ProductDetails_POM.sendPassword("admin@123");
		ProductDetails_POM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC014");
	}
	
	@Test(priority = 3)
	public void CatalogTest() {

		ProductDetails_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		ProductDetails_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected,title);

	}
	
	@Test(priority = 4)
	public void validProductCredentialsTest() {
		ProductDetails_POM.sendproductName("Integer vitae iaculis massa");
		ProductDetails_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with ProductName");
		ProductDetails_POM.sendproductPrice("515");
		ProductDetails_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with ProductNameAndPrice");

	}
	
	@AfterClass
	public void tearDown() throws Exception {
		
		driver.close();
	}
}




