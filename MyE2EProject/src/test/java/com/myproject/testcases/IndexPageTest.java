package com.myproject.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myproject.base.BaseClass;
import com.myproject.pageobjects.IndexPage;
import com.myproject.utility.Log;

public class IndexPageTest extends BaseClass {
	
	private IndexPage IP;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verfiyLogo() throws Throwable {
		
		IP = new IndexPage();
		boolean Result = IP.validateLogo();
		Assert.assertTrue(Result);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle = IP.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		Log.endTestCase("verifyTitle");
	}
}
