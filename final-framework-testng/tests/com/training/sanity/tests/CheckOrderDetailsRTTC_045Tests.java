package com.training.sanity.tests;

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
import com.training.pom.CheckOrderDetailsSalesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CheckOrderDetailsRTTC_045Tests {

	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM LoginPOM;

	private CheckOrderDetailsSalesPOM checkOrdersPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LoginPOM = new AdminLoginPOM(driver);
		checkOrdersPOM = new CheckOrderDetailsSalesPOM(driver);
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
		screenShot.captureScreenShot("Dashboard page validation success TC012");
	}
	@Test(priority = 2)
	public void ReportsCheck() throws InterruptedException {
		//Click on the Sales_orders to view the product and generate the invoice
		
		checkOrdersPOM.clickReports();
		checkOrdersPOM.viewOrders();
		String inv=checkOrdersPOM.GenerateInvoice();
		System.out.println("The invoice generated is : " + inv);
		
		  String expected ="2019";
		  
		  assertTrue(inv.contains(expected));
		 
		
	}
	

  @AfterClass public void tearDown() throws InterruptedException {
  driver.quit(); }
  
  
  }
 
