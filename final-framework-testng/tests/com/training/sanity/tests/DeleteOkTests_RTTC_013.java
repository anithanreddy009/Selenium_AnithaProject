
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.record.ScenarioProtectRecord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteOkPOM_RTTC_013;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class DeleteOkTests_RTTC_013 {

	private WebDriver driver;
	private String adminURL;
	private DeleteOkPOM_RTTC_013 DeleteOkPOM;
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
		DeleteOkPOM = new DeleteOkPOM_RTTC_013(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}




	@Test(priority = 2)
	public void validLoginTest() {
		DeleteOkPOM.sendUserName("admin");
		DeleteOkPOM.sendPassword("admin@123");
		DeleteOkPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC013");
	}

	@Test(priority = 3)
	public void CatalogTest() {
		DeleteOkPOM.catalogButton();
		screenShot.captureScreenShot("Catalog links are displayed");
		DeleteOkPOM.categoryButton();
		screenShot.captureScreenShot("Categories contents are displayed");
		String expected = "Categories";
		String title = driver.getTitle();
		assertEquals(expected,title);
		

	}
	@Test(priority = 4)
	public void CatalogName() {
		DeleteOkPOM.jewellerycheckboxclick();

	}

	@Test(priority = 5)
	public void DeleteTest() {

		DeleteOkPOM.clickDel();
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Success You have modified categories");
		String success = DeleteOkPOM.success_msg();
		System.out.println("Success msg for the deletion of the Categories is : " + success);

		 String expected ="Success";
		 
		 
		 assertTrue(success.contains(expected));
		 		 
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}





