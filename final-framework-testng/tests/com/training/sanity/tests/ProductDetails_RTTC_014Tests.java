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
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class ProductDetails_RTTC_014Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM ProductDetails_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver); 
		ProductDetails_POM = new Retail_productsPOM(driver); 
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
		screenShot.captureScreenShot("Dashboard page validation success TC014");
	}
	
	@Test(priority = 2)
	public void CatalogTest() {

		ProductDetails_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		ProductDetails_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected,title);

	}
	
	@Test(priority = 3)
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




