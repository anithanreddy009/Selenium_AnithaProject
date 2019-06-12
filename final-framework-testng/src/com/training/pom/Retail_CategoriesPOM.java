package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retail_CategoriesPOM {
	private WebDriver driver; 

	public  Retail_CategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a//i[@class='fa fa-tags fw']")
	private WebElement catalogBtn;

	@FindBy(linkText=("Categories"))
	private WebElement CategoryBtn;

	@FindBy(xpath="//*/tr[2]/td[1]")
	private WebElement jewellerycheckbox;

	@FindBy(xpath="//*[@class ='fa fa-trash-o']")
	private WebElement delclick;

	@FindBy(xpath="//*[contains(@class ,'alert-success')]")
	private WebElement success;

	public void catalogButton() {
		Actions action = new Actions(driver);
		action.moveToElement(catalogBtn).build().perform();
	}	
	public void categoryButton() {
		Actions action = new Actions(driver);
		action.moveToElement(CategoryBtn).click().build().perform();
	}

	public void jewellerycheckboxclick() {
		this.jewellerycheckbox.click(); 

	}


	public void clickDel() {
		this.delclick.click();

	}

	public String success_msg() {
		return this.success.getText();
	}

}





