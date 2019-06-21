package com.training.dataproviders;

import org.testng.annotations.DataProvider;

import com.training.readexcel.ApachePOIExcelRead;

public class InvalidDetailsDataProvidersRTTC_72 {
	@DataProvider(name = "Products")
	public Object[][] getExcelData(){
		
		// excel file from where the data is retrieved
		String fileName ="C:\\Anitha\\Products.xlsx"; 
		
		
		String sheetname = "Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetname);
}
}