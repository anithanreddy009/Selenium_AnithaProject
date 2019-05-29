package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Catalog_RTTC_012POM {
	private WebDriver driver; 

	public  Catalog_RTTC_012POM(WebDriver driver) {
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

	@FindBy(linkText=("Categories"))
	private WebElement CategoryBtn;

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
	

}



