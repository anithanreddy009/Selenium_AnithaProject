package com.training.pom;

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

		@FindBy(xpath="//*[@class ='fa fa-save']")
		private WebElement saveBtn;

		@FindBy(xpath="//*[@class ='alert alert-success']")
		private WebElement success;
		
		@FindBy(xpath="//*[@class ='fa fa-pencil']")
		private WebElement EditBtn;

		@FindBy(linkText=("Data"))
		private WebElement dataLink;

		@FindBy(id="input-quantity")
		private WebElement productQuantity;


		@FindBy(xpath="//*/tr[2]/td[1]")
		private WebElement checkbox1;
		
		@FindBy(xpath="//*/tr[3]/td[1]")
		private WebElement checkbox2;

		@FindBy(id="input-meta-title1")
		private WebElement metaTagTitle1;

		public void Checkbox1() {
			this.checkbox1.click();
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

		public void DataLink() {
			this.dataLink.click();
		}
		public void Quantity(String quantity) {
			this.productQuantity.clear();
			this.productQuantity.sendKeys(quantity);
		}
		public void saveBtn() {
			this.saveBtn.click();
		}
			
		public void AddButtonclick() {
			this.addBtn.click();

		}

		public void productName(String name) {
			this.productName1.sendKeys(name);
		}
		public void metaTagTitle(String metatag) {
			this.metaTagTitle.sendKeys(metatag);
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
		public void productquantity(String quantity) {
			this.Quantity.sendKeys(quantity);
		}
		public String success() {
			return this.success.getText();
		}
		public void Links() {

			this.linksTab.click();
		}


		public void categoryDropdownclick() {
			Actions action =new Actions(driver);
			this.Category.click();	
			action.moveToElement(driver.findElement(By.linkText("Test_Roopa"))).click().build().perform();}


		public void save() {
			this.saveBtn.click();
		}

		
		public void statusButtonclick() {
			
			this.StatusBtn.click();	
			Select enabled = new Select(driver.findElement(By.name("filter_status")));
			enabled.selectByVisibleText("Enabled");
					
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
			
			
		//@FindBy(xpath="//*[@value='777']")
		@FindBy(xpath="//*/tr[2]/td[1]")
		private WebElement productselection;
		
		@FindBy(xpath="//*[@class ='fa fa-trash-o']")
		private WebElement delclick;
		
			
		public void select() {
			this.productselection.click();
		}

		public void clickDel() {
			this.delclick.click();

		}

		public String success_msg() {
			return this.success.getText();
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



