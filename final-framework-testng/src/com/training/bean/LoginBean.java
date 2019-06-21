package com.training.bean;


public class LoginBean {
	private String userName;
	private String password;
	private String name;
	private String productmodel;
	private String price;
	private String metatag;
	private String quantity;
	

	public LoginBean() {
	}

	public LoginBean(String userName, String password ,String name,String metatag,String productmodel,String price,String quantity) {
		super();
		this.userName = userName;
		this.password = password;
		this.name=name;
		this.metatag = metatag;
		this.productmodel=productmodel;
		this.price=price;
		this.quantity=quantity;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getmetatag() {
		return metatag;
	}
	
	
	public void setmetatag(String metatag) {
		this.metatag = metatag;
	}
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public String getproductmodel() {
		return productmodel;
	}

	public void setproductmodel(String productmodel) {
		this.productmodel = productmodel;
	}
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}
	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + ",price=" + price + ",quantity=" + quantity + ",productmodel=" + productmodel + ",name=" + name + ",metatag=" + metatag +"]";
	}



}
