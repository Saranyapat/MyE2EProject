package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.LoginPage;
import com.myproject.pageobjects.RegisterPage;
import com.myproject.pageobjects.SearchResultPage;
import com.myproject.utility.Log;
import com.mystore.dataprovider.DataProviders;

public class SearchProductPageTest extends BaseClass{
	IndexPage IP;
	 //LoginPage LP;
	 SearchResultPage SRP;
	 @Parameters("browser")
		@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
		public void setup(String browser) {
			launchApp(browser); 
		}
		
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
		

		@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void ProductAvailabilityTest(String productName) throws Throwable {
		Log.startTestCase("ProductAvailabilityTest");
		IP = new IndexPage();
		Log.info("user is searching product");
		SRP=IP.searchProduct(productName);
		//SRP = IP.searchProduct("shirt");
		boolean result = SRP.isProductAvailable();
		Log.info("user verifying product availability");
		Assert.assertTrue(result);
		Log.endTestCase("ProductAvailabilityTest");
	}
}
