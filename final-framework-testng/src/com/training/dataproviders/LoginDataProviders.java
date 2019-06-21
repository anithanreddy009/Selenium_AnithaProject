package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[7]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			obj[2] = temp.getname(); 
			obj[3] = temp.getmetatag();
			obj[4] = temp.getproductmodel(); 
			obj[5] = temp.getprice();
			obj[6] = temp.getquantity(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "Products")
	public Object[][] getExcelData(){
		// excel file from where the data is retrieved

		String fileName ="C:\\Anitha\\Products.xlsx"; 
		
		String sheetname="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname);

	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Anitha\\Products.xlsx","Sheet1"); 
	}
}
