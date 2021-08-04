package com.myproject.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.HomePage;
import com.myproject.pageobjects.IndexPage;
import com.myproject.pageobjects.LoginPage;
import com.myproject.pageobjects.RegisterPage;
import com.myproject.utility.Log;
import com.mystore.dataprovider.DataProviders;

public class RegisterPageTest extends BaseClass{
	IndexPage IP;
 LoginPage LP;
 RegisterPage RP;
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
@Test(dataProvider = "email", dataProviderClass = DataProviders.class)
public void createaccountpageTest(String email) throws Throwable {
	Log.startTestCase("verifyCreateAccountPageTest");
	IP= new IndexPage();
	LP=IP.clickOnSignIn();
	RP=LP.RegisterNewAccount(email);
	boolean result=RP.validateAcountCreatePage();
	Assert.assertTrue(result);
	Log.endTestCase("verifyCreateAccountPageTest");
	
}

@Test(dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
	Log.startTestCase("createAccountTest");
	IP= new IndexPage();
	LP=IP.clickOnSignIn();
	RP=LP.RegisterNewAccount(hashMapValue.get("Email"));
	RP.createAccount(
			hashMapValue.get("Gender"),
			hashMapValue.get("FirstName"),
			hashMapValue.get("LastName"),
			hashMapValue.get("SetPassword"),
			hashMapValue.get("Day"),
			hashMapValue.get("Month"),
			hashMapValue.get("Year"),
			hashMapValue.get("Company"),
			hashMapValue.get("Address"),
			hashMapValue.get("City"),
			hashMapValue.get("State"),
			hashMapValue.get("Zipcode"),
			hashMapValue.get("Country"),
			hashMapValue.get("MobilePhone"));
	HP=RP.validateRegistration();
	Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", HP.getCurrentURL());
	Log.endTestCase("createAccountTest");
}
}
