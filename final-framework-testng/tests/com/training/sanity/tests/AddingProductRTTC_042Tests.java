package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddingProductRTTC_042Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM ProductADD_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		ProductADD_POM = new Retail_productsPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminURL);
	}

	@Test(priority = 1)
	public void validLoginTest() {
		//Enter the Valid login credentials
		LoginPOM.sendUserName("admin");
		LoginPOM.sendPassword("admin@123");
		LoginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC014");
	}

	@Test(priority = 2)
	public void CatalogTest() {

		//click on the catalog button

		ProductADD_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		
		//click on the Products button
		
		ProductADD_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected, title);

	}
	@Test(priority = 3)
	public void AddNewProduct() {
		
		//click on the Add button
		ProductADD_POM.AddButtonclick();
		
		//Enter the valid values in General Tab
		
		ProductADD_POM.productName("Finger Ring");
		ProductADD_POM.metaTagTitle("Finger Ring for ladies");
		screenShot.captureScreenShot("Products general tab contents are displayed");

		//Enter the valid values in Data Tab

		ProductADD_POM.Data();
		ProductADD_POM.productModel("SKU-012");
		ProductADD_POM.productPrice("500");
		ProductADD_POM.productquantity("50");
		screenShot.captureScreenShot("Products Data tab contents are displayed");

		//Enter the valid values in Links Tab

		ProductADD_POM.Links();
		ProductADD_POM.categoryDropdownclick();
		screenShot.captureScreenShot("Products Links tab contents are displayed");

		
		//Save the contents

		ProductADD_POM.save();
		
		
		 String success = ProductADD_POM.success();
		 String expected ="Success";
		assertTrue(success.contains(expected));
		System.out.println("Success msg for the addition of the Products is : " + success);

	}
	
	  @AfterClass
	  public void tearDown() throws InterruptedException {
	  driver.quit(); }
	 
	

}
