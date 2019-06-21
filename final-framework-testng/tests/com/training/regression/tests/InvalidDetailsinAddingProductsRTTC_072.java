/*@author Anitha Reddy
 * 
 * The Following set of code is to add product details and if the invalid product details are Entered to check for error message 
 * 
 * To verify whether application displays error message upon entering invalid details while adding product with reward points
 */
package com.training.regression.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.InvalidDetailsDataProvidersRTTC_72;
import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import org.testng.annotations.AfterMethod;


public class InvalidDetailsinAddingProductsRTTC_072 {
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




	@Test(dataProvider = "Products", dataProviderClass = InvalidDetailsDataProvidersRTTC_72.class)
	public void loginDBTest(String userName, String password,String name,
			String metatag,String productmodel,String price,String quantity,
			String DiscountQuantity,String DiscountPrice,String rewards) {

		//Retrieve the valid login credentials for the successful login
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("login success page");

		// to select the catalog with Products menu
		productPOM.catalogButton();
		productPOM.categoryButton();
		screenShot.captureScreenShot("Dashboard success page");

		// to click on add button to add new products
		productPOM.AddButtonclick();
		screenShot.captureScreenShot("new product page is displayed to add details");

		//to add product details in General tab
		productPOM.productName(name);
		productPOM.metaTagTitle(metatag);
		screenShot.captureScreenShot("General tab Product details");

		//to add product details in Data tab
		productPOM.Data();
		productPOM.ProductModel(productmodel);
		productPOM.productPrice(price);
		productPOM.Quantity(quantity);
		screenShot.captureScreenShot("Data tab Product details");

		//to add product details in Links tab
		productPOM.Links();
		productPOM.categoryDropdownclick();
		screenShot.captureScreenShot("Links tab Product details");

		//to add product details in Discount tab
		productPOM.Discount();
		productPOM.addDiscount();
		productPOM.DiscountQuantity(DiscountQuantity);
		productPOM.DiscountPrice(DiscountPrice);

		String currentDate =null;
		String start=productPOM.StartDate(currentDate);
		System.out.println(start);

		String newDate = null;
		String end =productPOM.EndDate(newDate);
		System.out.println(end);

		screenShot.captureScreenShot("Discount tab Product details");
		productPOM.rewardPointsLink();
		productPOM.Rewards(rewards);

		// to click on save button
		productPOM.saveBtn();
		screenShot.captureScreenShot("Success screen after adding Product details");

		// check for the error msg after invalid modification and check for assertions

		
		String Error = productPOM.ErrorMSG();
		 String expected ="errors";
		assertTrue(Error.contains(expected));
		System.out.println(" Warning msg for Errors : " + Error);
		

		}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}


}


