/*@author Anitha Reddy
 * 
 * The Following set of code is to return the ordered product with the valid reason 
 * 
 * To Verify whether application allows the user to return multiple ordered product
 */
package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.CheckOrderDetailsSalesPOM;
import com.training.pom.RetailUserLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturningProductTestRTTC_075 {
  
	private WebDriver driver;
	private static Properties properties;
	private ScreenShot screenShot;
	private RetailUserLoginPOM RetailUserLoginPOM;
	private String baseURL;
	JavascriptExecutor js = (JavascriptExecutor)driver; 


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod

		public void setUpUser() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			RetailUserLoginPOM= new RetailUserLoginPOM(driver);
			baseURL = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver);
			// open the browser
			driver.get(baseURL);
	}

		@Test(priority = 1)
		public void ReturningProduct() {
			
			
			RetailUserLoginPOM.UserIcon();
			RetailUserLoginPOM.AccountLogin();
			//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			
			//credentials using javascript
		/*
		 * js.executeScript(
		 * "document.getElementById('input-email').value=('anithanreddy1804@gmail.com')"
		 * ); js.executeScript(
		 * "document.getElementById('input-password').value=('vgy7bhu8nji9')");
		 */
					
			//login with user credentials
			RetailUserLoginPOM.UserEmail("anithanreddy1804@gmail.com");
			RetailUserLoginPOM.UserPassword("vgy7bhu8nji9");
			RetailUserLoginPOM.LoginButton();
			
			// to check for the ordered products using order history 
			RetailUserLoginPOM.OrderHistory();
			RetailUserLoginPOM.viewOrderHistory();
			
			// returning the product with the reason
			RetailUserLoginPOM.Return();
			RetailUserLoginPOM.ReturnReason();
			RetailUserLoginPOM.ReturnComment("Wrong Product sent");
			RetailUserLoginPOM.ReturnSubmit();
			
			driver.close();
		}
	 
	}
	
	


