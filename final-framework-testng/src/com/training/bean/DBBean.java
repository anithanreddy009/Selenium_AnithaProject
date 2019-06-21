package com.training.bean;

/**
 * 
 * @author Anitha
 * @ class will get the bean data 
 */
public class DBBean {
	private String url; 
	private String driver; 
	private String userName; 
	private String password;
	private String name;
	private String metatag;
	private String productmodel;
	private String price;
	private String quantity;
	
	public DBBean(){}
	
	public DBBean(String url, String driver, String userName, String password ,
			String name,String metatag,String productmodel,String price,String quantity) {
		super();
		this.url = url;
		this.driver = driver;
		this.userName = userName;
		this.password = password;
		this.name=name;
		this.metatag = metatag;
		this.productmodel = productmodel;
		this.price = price;
		this.quantity = quantity;
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		this.quantity = quantity;}
	
	
}
