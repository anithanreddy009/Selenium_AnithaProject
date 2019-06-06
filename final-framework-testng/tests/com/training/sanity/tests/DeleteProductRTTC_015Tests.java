
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mysql.jdbc.log.Log;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class DeleteProductRTTC_015Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM DeleteProductPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		DeleteProductPOM = new Retail_productsPOM(driver); 
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
		screenShot.captureScreenShot("Dashboard page validation success TC015");
	}

	@Test(priority = 2)
	public void CatalogTest() {
		DeleteProductPOM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		DeleteProductPOM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected,title);

	}
	@Test(priority = 3)
	public void DeleteTest() {

		DeleteProductPOM.select();
		DeleteProductPOM.clickDel();
		driver.switchTo().alert().accept();
		String success = DeleteProductPOM.success_msg();
		
		 String expected ="Success";
		  assertTrue(success.contains(expected));
		 
		System.out.println("Success msg for the deletion of the Products is : " + success);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.close();
	}
}






