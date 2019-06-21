/*@author Anitha Reddy
 * 
 * The Following set of code is to add the  product details in database and retrieve the same  
 * 
 * To Verify whether added product details get stored in database and able to retrieve the same 
 */
package com.training.regression.tests;

import com.training.pom.AdminLoginPOM;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class RetrievalProductDetailsFromDBRTTC_073 {
	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Retail_productsPOM productPOM;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new AdminLoginPOM(driver);
		productPOM =new Retail_productsPOM(driver);
		adminURL = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminURL);
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void DBRetrieval(String userName, String password ,String name,
			String metatag,String productmodel,String price,String quantity) {

		//Retrive the valid login credentials for the successful login

		loginPOM.sendUserName("admin");
		String dbusername=loginPOM.getUserName();

		loginPOM.sendPassword("admin@123");
		String dbpassword=loginPOM.getPassword();

		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("login success page");

		// to select the catalog with Products menu
		productPOM.catalogButton();
		productPOM.categoryButton();
		screenShot.captureScreenShot("Dashboard success page");

		//click on the Add button
		productPOM.AddButtonclick();

		//Enter the valid values in General Tab

		productPOM.productName("Finger Ring");
		String dbproductname=productPOM.getproductName();


		productPOM.metaTagTitle("Finger Ring for ladies");
		String dbmetaTagTitle=productPOM.getmetaTagTitle();

		screenShot.captureScreenShot("Products general tab contents are displayed");

		//Enter the valid values in Data Tab

		productPOM.Data();
		productPOM.productModel("SKU-012");
		String dbproductmodel=productPOM.getproductModel();

		productPOM.productPrice("500");
		String dbproductprice=productPOM.getproductPrice();


		productPOM.Quantity("50");
		String dbproductquantity=productPOM.getproductquantity();

		
		  screenShot.captureScreenShot("Products Data tab contents are displayed");
		  
		  //Enter the valid values in Links Tab
		  
		  productPOM.Links(); productPOM.categoryDropdownclick();
		  screenShot.captureScreenShot("Products Links tab contents are displayed");
		  
		  
		  //Save the contents
		  
		  productPOM.save();
		  
		  // check for the success msg after modification and check for assertions
		  
		  Assert.assertEquals(userName,dbusername);
		  //Assert.assertEquals("admin",dbusername);
		  Assert.assertEquals(password,dbpassword);
		  Assert.assertEquals(name,dbproductname);
		  Assert.assertEquals(dbmetaTagTitle,metatag);
		  Assert.assertEquals(dbproductmodel,productmodel);
		  Assert.assertEquals(dbproductprice,price);
		  Assert.assertEquals(quantity,dbproductquantity);
		  
		  String success = productPOM.success();
		  String expected ="Success";
		  assertTrue(success.contains(expected));
		  System.out.println("Success msg for the addition of the Products is : " +
		  success);
		 

	}


	/*
	 * @AfterMethod public void tearDown() throws Exception { driver.close(); }
	 */


}

