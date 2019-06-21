	package com.training.pom;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class RetailUserLoginPOM {

		private WebDriver driver;
		public  RetailUserLoginPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//*[@class='fa fa-user-o']")
		private WebElement UserIcon;

		@FindBy(xpath ="//*[contains(text(),'LOGIN / REGISTER')]")
		private WebElement Register;

		@FindBy(xpath="//input[@class='form-control' and @id='input-email']")
		private WebElement UserEmail;

		@FindBy(xpath="//*[contains(text(),'Order History')]")
		private WebElement HistoryLink;
		
		@FindBy(xpath="//*[@id='input-password']")
		private WebElement UserPassword;
		
		@FindBy(xpath="//*[@type='submit' and @value='Login']")
		private WebElement LoginButton;
		
		@FindBy(linkText ="View your order history")
		private WebElement OrderHistory;
		
		@FindBy(linkText ="MY ORDERS")
		private WebElement MyOrders;
		
		@FindBy(xpath ="//*[@class='fa fa-eye']")
		private WebElement OrdersHistoryView;
		
		@FindBy(xpath ="//*[@class='fa fa-reply']")
		private WebElement Return;
		
		@FindBy(xpath ="//*[@value='3' and@ name='return_reason_id']")
		private WebElement Returnreason;
		
		@FindBy(name ="opened")
		private WebElement OpenedProduct;
		
		@FindBy(id ="input-comment")
		private WebElement Returncomment;
		
		@FindBy(xpath ="//*[@type='submit' and @value='Submit']")
		private WebElement Returnsubmit;
		
		public void viewOrderHistory() {
			this.OrdersHistoryView.click();
		}
		public void OrderHistoryLink() {
			this.HistoryLink.click();
		}
		public void Return() {
			this.Return.click();
		}
		
		public void ReturnReason() {
			this.Returnreason.click();
		}
		
		public void openedProduct() {
			this.OpenedProduct.click();
		}
		
		public void ReturnComment(String comment) {
			this.Returncomment.sendKeys(comment);
		}
		
		public void ReturnSubmit() {
			this.Returnsubmit.click();
		}
		public void MyOrders() {
			this.MyOrders.click();
		}
		
		public void AccountLogin() {
			this.Register.click();
		}
		
		public void UserEmail(String email) {
			this.UserEmail.sendKeys(email);
		}
		
		public void UserPassword(String pwd) {
			this.UserPassword.sendKeys(pwd);

		}

		public void LoginButton() {
			this.LoginButton.click();
		}
		public void UserIcon() {
			this.UserIcon.click();
		}

		public void OrderHistory() {
			this.OrderHistory.click();
		}

		

}
