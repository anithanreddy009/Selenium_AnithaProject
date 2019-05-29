



package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails_RTTC_014POM {

	private WebDriver driver;
	public  ProductDetails_RTTC_014POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-username")
	private WebElement userName; 

	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//*[@type='submit']")
	private WebElement loginBtn; 

	@FindBy(xpath="//a//i[@class='fa fa-tags fw']")
	private WebElement catalogBtn;

	@FindBy(linkText=("Products"))
	private WebElement CategoryBtn;

	@FindBy(id="input-name")
	private WebElement productName;

	@FindBy(id="input-price")
	private WebElement productPrice;

	@FindBy(id="button-filter")
	private WebElement filter;


	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void catalogButton() {
		Actions action = new Actions(driver);
		action.moveToElement(catalogBtn).build().perform();
	}	
	public void categoryButton() {
		Actions action = new Actions(driver);
		action.moveToElement(CategoryBtn).click().build().perform();
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


}



