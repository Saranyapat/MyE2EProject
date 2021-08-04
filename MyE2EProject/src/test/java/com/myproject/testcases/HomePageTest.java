package com.myproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.HomePage;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.LoginPage;
import com.myproject.utility.Log;
import com.mystore.dataprovider.DataProviders;

public class HomePageTest extends BaseClass{
IndexPage IP;
LoginPage LP;
HomePage HP;
@Parameters("browser")
@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
public void setup(String browser) {
	launchApp(browser); 
}

@AfterMethod(groups = {"Smoke","Sanity","Regression"})
public void tearDown() {
	getDriver().quit();
}
@Test(groups = "Smoke",dataProvider="credentials", dataProviderClass = DataProviders.class)
public void verifyWishListTest(String uname, String pswrd) throws Throwable {
	Log.startTestCase("verifyWishListTest");
	IP=new IndexPage();
	Log.info("user is able to click on login");
	LP=IP.clickOnSignIn();
	Log.info("user entered username and password");
	HP = LP.Login(uname,pswrd);
	//HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
	Log.info("validating mywishlist");
	boolean result = HP.ValidateMyWishlist();
	Assert.assertTrue(result);
	Log.endTestCase("verifyWishListTest");
}
@Test(groups = "Smoke",dataProvider="credentials", dataProviderClass = DataProviders.class)
public void verifyOrderHistoryTest(String uname, String pswrd) throws Throwable {
	Log.startTestCase("verifyOrderHistoryTest");
	IP=new IndexPage();
	Log.info("user is able to click on login");
	LP=IP.clickOnSignIn();
	Log.info("user entered username and password");
	HP = LP.Login(uname,pswrd);
	//HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
	boolean result = HP.ValidateOrderHistory();
	Log.info("validating order history");
	Assert.assertTrue(result);
	Log.endTestCase("verifyOrderHistoryTest");
}
}
