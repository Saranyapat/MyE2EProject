package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.AddtoCartPage;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.OrderPage;
import com.myproject.pageobjects.SearchResultPage;
import com.myproject.utility.Log;
import com.mystore.dataprovider.DataProviders;

public class OrderTest extends BaseClass{
	IndexPage IP;
	 //LoginPage LP;
	 SearchResultPage SRP;
	 AddtoCartPage ACP;
	 OrderPage OP;
	 @Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup(String browser) {
			launchApp(browser); 
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		
		@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		IP = new IndexPage();
		SRP = IP.searchProduct(productName);
		ACP=SRP.clickOnProduct();
		ACP.enterQuantity(qty);
		ACP.selectSize(size);
		ACP.clickOnAddToCart();
		OP = ACP.clickOnCheckOut();
		double UP = OP.getUnitPrice();
		double TP = OP.getTotalPrice();
		double ETP = (UP*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(TP, ETP);
		OP.clickOnCheckOut();
		Log.endTestCase("verifyTotalPrice");
	} 
}