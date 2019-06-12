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

public class EditProductRTTC_043Tests {
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM EditProduct_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		EditProduct_POM = new Retail_productsPOM(driver);
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
		EditProduct_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		
		//click on the Products button

		EditProduct_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected, title);

	}
	@Test(priority = 3)
	public void EditProducts() {
		//Click on the Edit button
		EditProduct_POM.editButton();
		
		//Click on the DataLink Tab

		EditProduct_POM.DataLink();
		//Change the quantity and save
		
		EditProduct_POM.Quantity("90");
		EditProduct_POM.saveBtn();
		 String success = EditProduct_POM.success();
		 String expected ="Success";
		assertTrue(success.contains(expected));
		System.out.println("Success msg for the addition of the Products is : " + success);
	}
	@AfterClass
	public void tearDown() throws InterruptedException  {
		driver.quit();
	}
}
