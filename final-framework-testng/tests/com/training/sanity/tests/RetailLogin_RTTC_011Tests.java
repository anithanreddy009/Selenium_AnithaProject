
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RetailLoginPOM_RTTC_011;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RetailLogin_RTTC_011Tests {

	private WebDriver driver;
	private String adminURL;
	private RetailLoginPOM_RTTC_011 RetailLoginPOM;
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
		RetailLoginPOM = new RetailLoginPOM_RTTC_011(driver); 
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminURL);
	}



	
	@Test(priority = 2)
	public void validLoginTest() {
		RetailLoginPOM.sendUserName("admin");
		RetailLoginPOM.sendPassword("admin@123");
		RetailLoginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("Dashboard page validation success TC011");
	}
	@AfterClass
	public void tearDown() throws Exception {
	
		driver.close();
	}
}


