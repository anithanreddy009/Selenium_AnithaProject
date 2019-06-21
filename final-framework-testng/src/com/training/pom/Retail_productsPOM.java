
package com.training.pom;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Retail_productsPOM {

	private WebDriver driver;
	public  Retail_productsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
																																																																																																																																																																																																																						
	@FindBy(xpath="//tfoot/tr/td/button[@data-original-title='Add Discount']")
	private WebElement Adddiscount;

	@FindBy(name="product_discount[0][date_start]")
	private WebElement startDate;

	@FindBy(linkText = "Reward Points")
	private WebElement rewardPoints;

	@FindBy(name="product_discount[0][date_end]")
	private WebElement EndDate;


	@FindBy(xpath="//a//i[@class='fa fa-tags fw']")
	private WebElement catalogBtn;

	@FindBy(name=("product_discount[0][quantity]"))
	private WebElement DiscountQuantity;

	@FindBy(name=("product_discount[0][price]"))
	private WebElement DiscountPrice;

	@FindBy(linkText=("Products"))
	private WebElement CategoryBtn;

	@FindBy(id="input-name")
	private WebElement productName;

	@FindBy(id="input-price")
	private WebElement productPrice;

	@FindBy(id="button-filter")
	private WebElement filter;

	@FindBy(id="input-status")
	private WebElement StatusBtn;

	@FindBy(id="input-model")
	private WebElement ModelTestbox;

	@FindBy(id="input-quantity")
	private WebElement Quantity;

	@FindBy(id="input-image")
	private WebElement Imagedropdown;

	@FindBy(xpath="//*[@class ='fa fa-plus']")
	private WebElement addBtn;

	@FindBy(id="input-name1")
	private WebElement productName1;

	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;

	@FindBy(linkText ="Data")
	private WebElement DataTab;

	@FindBy(linkText ="Links")
	private WebElement linksTab;

	@FindBy(id="input-category")
	private WebElement Category;

	@FindBy(xpath="//*[@class='fa fa-exclamation-circle']")
	private WebElement ErrorMSg;

	@FindBy(xpath="//*[@class ='fa fa-save']")
	private WebElement saveBtn;

	@FindBy(xpath="//*[@class ='alert alert-success']")
	private WebElement success;

	@FindBy(id="input-payment-telephone")
	private WebElement Telephone;

	@FindBy(id="input-payment-address-1")
	private WebElement Address;

	@FindBy(id="input-payment-city")
	private WebElement City;

	@FindBy(id="input-payment-postcode")
	private WebElement Postcode;

	@FindBy(id="input-payment-country")
	private WebElement country;

	@FindBy(id="input-payment-zone")
	private WebElement state;

	@FindBy(xpath="//*[text()='Add to Cart']")
	private WebElement AddToCart;

	@FindBy(xpath="//*[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement CartBag;

	@FindBy(linkText = "View Cart")
	private WebElement ViewCart;

	@FindBy(linkText = "Checkout")
	private WebElement Checkout;

	@FindBy(name="firstname")
	private WebElement FirstName;

	@FindBy(xpath="//*[@id='button-account' and @value='Continue']")
	private WebElement Continue;

	@FindBy(xpath="//*[@name='account' and @value='guest']")
	private WebElement GuestCheckout;

	@FindBy(id="input-payment-email")
	private WebElement Email;

	@FindBy(xpath="//*[@class ='noty_cont noty_layout_topRight']")
	private WebElement cancel;

	@FindBy(id="input-payment-lastname")
	private WebElement LastName;

	@FindBy(xpath="//*[@class ='fa fa-pencil']")
	private WebElement EditBtn;

	@FindBy(linkText=("Data"))
	private WebElement dataLink;

	@FindBy(id="input-quantity")
	private WebElement productQuantity;

	@FindBy(id="button-shipping-method")
	private WebElement ShippingContinue;

	@FindBy(id="button-guest")
	private WebElement GuestContinue;
	@FindBy(id="button-confirm")
	private WebElement confirm;

	@FindBy(id="input-payment-address-2")
	private WebElement address1;


	@FindBy(name="comment") 
	private WebElement comments;

	@FindBy(xpath="//label//input[@type='checkbox' and @name='agree']") 
	private WebElement condition;

	@FindBy(id="input-points")
	private WebElement rewards;

	@FindBy(linkText = "Nullam sodales in purus vel auctor")
	private WebElement RetailProduct;

	@FindBy(xpath="//*/tr[2]/td[1]")
	private WebElement checkbox1;

	@FindBy(xpath="//*/tr[3]/td[1]")
	private WebElement checkbox2;

	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle1;
	
	@FindBy(id="button-payment-method")
	private WebElement paymentcontinue;

	@FindBy(linkText = "Discount")
	private WebElement discount;
	
	@FindBy(id = "input-order-status")
	private WebElement Status;

	@FindBy(xpath="//*/tr[2]/td[1]")
	private WebElement productselection;

	@FindBy(xpath="//*[@class ='fa fa-trash-o']")
	private WebElement delclick;
	
	public void Discount() {
		this.discount.click();
	}
	public void Rewards(String rewards) {
		this.rewards.sendKeys(rewards);;
	}

	public void Checkbox1() {
		this.checkbox1.click();
	}

	public void AddtoCart() {
		this.AddToCart.click();
	}
	public void CartBag() {
		Actions act =new Actions(driver);
		act.moveToElement(CartBag).build().perform();
	}
	public void viewCart() {
		this.ViewCart.click();
	}
	public void guestContinue() {
		this.GuestContinue.click();
	}

	public void cancel() {
		this.cancel.click();
	}
	public void Checkout() {
		this.Checkout.click();
	}
	public void guest() {
		this.GuestCheckout.click();
	}

	public void Checkbox2() {
		this.checkbox2.click();
	}
	public void catalogButton() {
		Actions action = new Actions(driver);
		action.moveToElement(catalogBtn).build().perform();
	}	
	public void categoryButton() {
		Actions action = new Actions(driver);
		action.moveToElement(CategoryBtn).click().build().perform();}


	public void editButton() {
		this.EditBtn.click();
	}
	public void RetailProduct() {
		this.RetailProduct.click();
	}

	public void DataLink() {
		this.dataLink.click();
	}
	public void Quantity(String quantity) {
		this.productQuantity.clear();
		this.productQuantity.sendKeys(quantity);
	}
	public void DiscountQuantity(String DiscountQuantity) {
		this.DiscountQuantity.clear();
		this.DiscountQuantity.sendKeys(DiscountQuantity);
	}

	public void DiscountPrice(String DiscountPrice) {
		this.DiscountPrice.clear();
		this.DiscountPrice.sendKeys(DiscountPrice);
	}
	public void saveBtn() {
		this.saveBtn.click();
	}

	public void AddButtonclick() {
		this.addBtn.click();

	}
	public void ShippingContinue() {
		this.ShippingContinue.click();

	}

	public void productName(String name) {
		this.productName1.sendKeys(name);
	}
	
	public String getproductName() {
		return this.productName1.getAttribute("value");
	}
	public void Telephone(String telephone) {
		this.Telephone.sendKeys(telephone);
	}
	public void address(String address) {
		this.Address.sendKeys(address);
	}
	public void city(String city) {
		this.City.sendKeys(city);
	}
	public void postcode(String postcode) {
		this.Postcode.sendKeys(postcode);
	}
	public void state() {

		this.state.click();

		Select region = new Select(driver.findElement(By.name("zone_id")));
		region.selectByVisibleText("Karnataka");

	}
	public void metaTagTitle(String metatag) {
		this.metaTagTitle.sendKeys(metatag);
	}
	
	public String getmetaTagTitle() {
		return this.metaTagTitle.getAttribute("value");
	}


	public void Data() {

		this.DataTab.click();
	}
	public void productModel(String model) {
		this.ModelTestbox.sendKeys(model);
	}
	public void productPrice(String price) {
		this.productPrice.sendKeys(price);
	}
	public String getproductModel() {
		return this.ModelTestbox.getAttribute("value");
	}
	public String getproductPrice() {
		return this.productPrice.getAttribute("value");
	}
	public void productquantity(String quantity) {
		this.Quantity.sendKeys(quantity);
	}
	public String getproductquantity() {
		return this.Quantity.getAttribute("value");
	}
	public String success() {
		return this.success.getText();
	}
	public String ErrorMSG() {
		return this.ErrorMSg.getText();
	}

	public void Links() {

		this.linksTab.click();
	}


	public void categoryDropdownclick() {
		Actions action =new Actions(driver);
		this.Category.click();	
		action.moveToElement(driver.findElement(By.linkText("Ear Rings"))).click().build().perform();}


	public void save() {
		this.saveBtn.click();
	}
	public void rewardPointsLink() {
		this.rewardPoints.click();
	}

	public void statusButtonclick() {

		this.StatusBtn.click();	
		Select enabled = new Select(driver.findElement(By.name("filter_status")));
		enabled.selectByVisibleText("Enabled");

	}
	public void statusSelection() {

		this.Status.click();	
		Select sta = new Select(driver.findElement(By.id("input-order-status")));
		sta.selectByVisibleText("Complete");

	}
	
	public void ProductModel(String productmodel) {
		this.ModelTestbox.sendKeys(productmodel);

	}
	public void ProductQuantity(String productquantity) {
		this.Quantity.sendKeys(productquantity);

	}


	public void Imagedropdownclick() {

		this.Imagedropdown.click();	
		Select enabled1 = new Select(driver.findElement(By.name("filter_image")));
		enabled1.selectByVisibleText("Enabled");
	}

	public void select() {
		this.productselection.click();
	}

	public void clickDel() {
		this.delclick.click();

	}

	public String success_msg() {
		return this.success.getText();
	}
	public void Condition() {
		this.condition.click();
	}


	public void sendproductName(String productName) {
		this.productName.clear();
		this.productName.sendKeys(productName);
	}
	public void sendproductPrice(String productPrice) {
		this.productPrice.clear();
		this.productPrice.sendKeys(productPrice);
	}
	public void clickfilter() {
		this.filter.click();
	}

	public void FirstName(String fname) {
		this.FirstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		this.LastName.sendKeys(lname);
	}
	public void email(String email) {
		this.Email.sendKeys(email);
	}
	public void Continue() {
		this.Continue.click();
	}

	public void ViewCart() {
		this.ViewCart.click();
	}

	public void addDiscount() {

		this.Adddiscount.click();

	}
	public String EndDate(String newDate) {
		this.EndDate.click();
		DateFormat date = new SimpleDateFormat("dd/MM/yy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 1);
		newDate = date.format(cal.getTime());
		return this.EndDate(newDate);
	}
	
	
	public String StartDate(String currentDate){
		this.startDate.click();
		DateFormat date = new SimpleDateFormat("dd/MM/yy");
		Date today = Calendar.getInstance().getTime();
		currentDate = date.format(today);
		return this.StartDate(currentDate);
				
	}
	public void address1(String address1) {
		this.address1.sendKeys(address1);

	}
	public void comment(String comment) {
		this.comments.sendKeys(comment);

	}
	public void paymentContinue() {
		this.paymentcontinue.click();		
	}
	public void confirmOrder() {
		this.confirm.click();
	}
	
	
    
}




