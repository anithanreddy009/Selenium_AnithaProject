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
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductsFilterRTTC_041Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM ProductFilter_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		ProductFilter_POM = new Retail_productsPOM(driver);
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
		screenShot.captureScreenShot("Dashboard page validation success TC041");
	}

	@Test(priority = 3)
	public void CatalogTest() {
		//click on the catalog button

		ProductFilter_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");

		//click on the Products button

		ProductFilter_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");

		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected, title);

	}

	@Test(priority = 4)
	public void validProductCredentialsTest() throws InterruptedException {

		//Enter the valid values and filter accordingly

		ProductFilter_POM.sendproductName("Integer vitae iaculis massa");
		ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with ProductName");

		ProductFilter_POM.sendproductPrice("829.0000");
		ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with ProductNameAndPrice");

		ProductFilter_POM.statusButtonclick(); ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with status as Enabled");

		ProductFilter_POM.ProductModel("SKU-003");
		ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with Product Model");

		ProductFilter_POM.ProductQuantity("8");
		ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with Product Quantity");

		ProductFilter_POM.Imagedropdownclick();
		ProductFilter_POM.clickfilter();
		screenShot.captureScreenShot("ProductDetails with image as Enabled");

	}


	@AfterClass public void tearDown() throws Exception {

		driver.close(); }

}
