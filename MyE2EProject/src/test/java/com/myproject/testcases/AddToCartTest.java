package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.AddtoCartPage;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.SearchResultPage;
import com.myproject.utility.Log;
import com.mystore.dataprovider.DataProviders;

public class AddToCartTest extends BaseClass{
	IndexPage IP;
	 //LoginPage LP;
	 SearchResultPage SRP;
	 AddtoCartPage ACP;
	 
		@Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup(String browser) {
			launchApp(browser); 
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void AddtoCartTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		IP = new IndexPage();
		Log.info("user is searching product");
		SRP = IP.searchProduct(productName);
		Log.info("user is clicking on product");
		ACP=SRP.clickOnProduct();
		Log.info("user is selecting quantity and size");
		ACP.enterQuantity(qty);
		ACP.selectSize(size);
		ACP.clickOnAddToCart();
		boolean result=ACP.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
	}
}


