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

public class MultipleDeleteRTTC_044Tests {
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;
	private Retail_productsPOM multipledelete_POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		multipledelete_POM = new Retail_productsPOM(driver);
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
		multipledelete_POM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		//click on the Products button
		
		multipledelete_POM.categoryButton();
		screenShot.captureScreenShot("Products contents are displayed");
		String expected = "Products";
		String title = driver.getTitle();
		assertEquals(expected, title);

	}
	@Test(priority = 4)
	public void MultipleDelete() {
		//Select multiple checkboxes to delete 
		multipledelete_POM.Checkbox1();
		multipledelete_POM.Checkbox2();
		screenShot.captureScreenShot("Multiple checkbox selected");

		multipledelete_POM.clickDel();
		//to click ok in the pop up for Delete confirmation
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Success You have modified categories");
		String success = multipledelete_POM.success_msg();
		System.out.println("Success msg for the deletion of the Categories is : " + success);

		String expected ="Success";


		assertTrue(success.contains(expected));

	}
	@AfterClass
	public void tearDown() throws InterruptedException  {
		driver.quit();


	}}
