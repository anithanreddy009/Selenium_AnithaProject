/*@author Anitha Reddy
 * 
 * The Following set of code is to order the product in user application and completion is done from admin side and 
 * viewing the order in user application 
 * To verify whether application allows user to place an order as guest user & admin to change order order status as complete
 * 
 *      the ordered product cannot be viewed with user credentials as the order was created as a guest but order created seperately 
 *      using login credentials and completed the testcase
 */
package com.training.regression.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.Retail_productsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.CheckOrderDetailsSalesPOM;
import com.training.pom.RetailUserLoginPOM;

public class ProductOrderingE2ERTTC_074 {


	private WebDriver driver;
	private String adminURL;
	private AdminLoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private Retail_productsPOM productPOM;
	private CheckOrderDetailsSalesPOM checkOrdersPOM;
	private String baseURL;
	private RetailUserLoginPOM RetailUserLoginPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority = 1)

	public void setUpUser() throws Exception { 
		driver = DriverFactory.getDriver(DriverNames.CHROME); 
		loginPOM = new AdminLoginPOM(driver);
		productPOM =new Retail_productsPOM(driver);
		checkOrdersPOM =new CheckOrderDetailsSalesPOM(driver); 
		RetailUserLoginPOM=new RetailUserLoginPOM(driver);
		baseURL = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseURL);

	}

	@Test(priority = 2)
	public void ProductOrdering() {

		// click on the product to be ordered 
		productPOM.RetailProduct();

		// select the product and add to the cart productPOM.AddtoCart();
		productPOM.cancel(); 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		productPOM.CartBag();

		// view the cart for the ordered product and checkout productPOM.viewCart();
		productPOM.Checkout();

		// login as guest , give the Valid personal details to deliver the Product
		productPOM.guest();
		productPOM.Continue();
		productPOM.FirstName("Anitha");
		productPOM.lastName("Reddy");
		productPOM.email("anithanreddy1804@gmail.com");
		productPOM.Telephone("9964536375");
		productPOM.address("#12 subramanya Aracde block c");
		productPOM.address1("Bannerghatta Road");
		productPOM.city("Bangalore");
		productPOM.postcode("560029");
		productPOM.state();
		productPOM.guestContinue();
		productPOM.comment("Order to the correct address please");
		productPOM.ShippingContinue(); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		productPOM.Condition();

		//to confirm the order
		productPOM.paymentContinue();
		productPOM.confirmOrder(); 
		driver.close(); }

	@Test(priority = 3)

	public void OrderStatusCompletion() {

		driver =DriverFactory.getDriver(DriverNames.CHROME); 
		loginPOM = new AdminLoginPOM(driver); 
		productPOM =new Retail_productsPOM(driver);
		checkOrdersPOM =new CheckOrderDetailsSalesPOM(driver);
		adminURL =properties.getProperty("adminURL"); 
		//open the browser
		driver.get(adminURL);

		// login with the admin credentials 

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		screenShot.captureScreenShot("Dashboard page validation success");

		// to click on the sales_order 
		checkOrdersPOM.clickReports();

		//to change the Status of the order to Completion
		checkOrdersPOM.PendingView();
		productPOM.statusSelection();
		checkOrdersPOM.CommentOrder("Changing the status to complete");
		checkOrdersPOM.AddHistory();

		// check for the success msg after modification and check for assertions
		String success = productPOM.success_msg(); String expected ="Success";
		assertTrue(success.contains(expected));
		System.out.println("Success msg for the addition of the Products is : " +success); 
		driver.close(); }


	@Test(priority = 2)
	public void RetailUserLogin() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RetailUserLoginPOM= new RetailUserLoginPOM(driver);
		baseURL = properties.getProperty("baseURL");
		// open the browser
		driver.get(baseURL);

		RetailUserLoginPOM.UserIcon();
		RetailUserLoginPOM.AccountLogin();

		//login with user credentials
		RetailUserLoginPOM.UserEmail("anithanreddy1804@gmail.com");
		RetailUserLoginPOM.UserPassword("vgy7bhu8nji9");
		RetailUserLoginPOM.LoginButton();

		// to check for the ordered products using order history 
		RetailUserLoginPOM.OrderHistory();

		driver.close();}

}



