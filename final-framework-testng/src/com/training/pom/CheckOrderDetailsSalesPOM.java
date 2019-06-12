package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOrderDetailsSalesPOM {

	private WebDriver driver;
	public  CheckOrderDetailsSalesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@class='fa fa-shopping-cart fw']")
	private WebElement sales;

	@FindBy(xpath ="//tr[2]//td[8]//a//i[@class='fa fa-eye']")
	private WebElement view;

	@FindBy(xpath="//td//i[@class = 'fa fa-cog']")
	private WebElement Generate;

	@FindBy(linkText ="Orders")
	private WebElement viewOrders;

	@FindBy(id ="invoice")
	private WebElement invoice;

	public void clickReports() {
		Actions action = new Actions(driver);
		action.moveToElement(sales).build().perform();
		action.moveToElement(viewOrders).click().build().perform();
	}

	public void viewOrders() {
		this.view.click();
	}


	public String GenerateInvoice() throws InterruptedException
	{

		if(this.invoice.isDisplayed()) {
			return this.invoice.getText();
		}
		else {
			this.Generate.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return this.invoice.getText();

		}
	}
}