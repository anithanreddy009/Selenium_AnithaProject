
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductRTTC_015POM {
	private WebDriver driver; 

	public  DeleteProductRTTC_015POM(WebDriver driver) {
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
	
	//@FindBy(xpath="//*[@value='777']")
	@FindBy(xpath="//*/tr[2]/td[1]")
	private WebElement productselection;
	
	@FindBy(xpath="//*[@class ='fa fa-trash-o']")
	private WebElement delclick;

	@FindBy(xpath="//*[contains(@class ,'alert-success')]")
	private WebElement success;

	

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
	
	
	public void select() {
		this.productselection.click();
	}

	public void clickDel() {
		this.delclick.click();

	}

	public String success_msg() {
		return this.success.getText();
	}
}



