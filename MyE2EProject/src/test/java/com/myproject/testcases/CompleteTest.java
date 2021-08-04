package com.myproject.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.myproject.utility.Log;
import com.myproject.base.BaseClass;
import com.myproject.pageobjects.AddressPage;
import com.myproject.pageobjects.AddtoCartPage;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.LoginPage;
import com.myproject.pageobjects.OrderConfirmationPage;
import com.myproject.pageobjects.OrderPage;
import com.myproject.pageobjects.OrderSummary;
import com.myproject.pageobjects.PaymentPage;
import com.myproject.pageobjects.SearchResultPage;
import com.myproject.pageobjects.ShippingPage;
import com.mystore.dataprovider.DataProviders;


public class CompleteTest extends BaseClass{
	IndexPage IP;
	 LoginPage LP;
	 SearchResultPage SRP;
	 AddtoCartPage ACP;
	 OrderPage OP;
	 AddressPage AP;
	 ShippingPage SP;
	 PaymentPage PP;
	 OrderSummary OS;
	 OrderConfirmationPage OCP;
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
	public void endtoEndTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("endToEndTest");
		IP= new IndexPage();
		SRP=IP.searchProduct(productName);
		ACP=SRP.clickOnProduct();
		ACP.enterQuantity(qty);
		ACP.selectSize(size);
		ACP.clickOnAddToCart();
		OP=ACP.clickOnCheckOut();
		LP=OP.clickOnCheckOut();
		AP=LP.login(prop.getProperty("username"), prop.getProperty("password"),AP);
		SP=AP.clickOnCheckout();
		SP.checkTheTerms();
		PP=SP.clickOnProceedToCheckOut();
		OS=PP.clickOnPaymentMethod();
		OCP=OS.clickOnconfirmOrderBtn();
		String actualMessage=OCP.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("endToEndTest");
	}
		/*Log.startTestCase("endtoEndTest");
		IP = new IndexPage();
		SRP = IP.searchProduct(productName);
		ACP=SRP.clickOnProduct();
		ACP.enterQuantity(qty);
		ACP.selectSize(size);
		ACP.clickOnAddToCart();
		OP = ACP.clickOnCheckOut();
		LP=OP.clickOnCheckOut();
		//AP=LP.Login2(uname, pswrd);
		AP=LP.Login(prop.getProperty("username"), prop.getProperty("password"),AP);
		//AP=LP.Login(prop.getProperty("username"), prop.getProperty("password"),AP);
		SP = AP.clickOnCheckout();
		SP.checkTheTerms();
		PP=SP.clickOnProceedToCheckOut();
		OS=PP.clickOnPaymentMethod();
		OCP = OS.clickOnconfirmOrderBtn();
		String actualMessage = OCP.validateConfirmMessage();
		String expectedMessage = "Your order on My Store is complete.";
		Assert.assertEquals(expectedMessage, actualMessage);
		Log.endTestCase("endtoEndTest");
		
		
	}*/
}
