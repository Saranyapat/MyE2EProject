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

public class LoginPageTest extends BaseClass{
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

	@Test(groups = {"Smoke","Sanity"},dataProvider="credentials", dataProviderClass = DataProviders.class)
	public void LoginTest(String uname, String pswrd) throws Throwable {
		Log.startTestCase("LoginTest");
		IP = new IndexPage();
		Log.info("User is going to click on Login");
		LP = IP.clickOnSignIn();
		Log.info("Enter Username and password");
		HP = LP.Login(uname,pswrd);
		//HP = LP.Login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL = HP.getCurrentURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		 Assert.assertEquals(actualURL, expectedURL);
		 Log.info("Login success");
		 Log.endTestCase("LoginTest");
	}
}
