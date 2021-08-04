package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.base.BaseClass;

public class HomePage extends BaseClass {
	
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean ValidateMyWishlist() {
		return myWishList.isDisplayed();
	}
	
	public boolean ValidateOrderHistory() {
		return orderHistory.isDisplayed();

	}
	
	public String getCurrentURL() throws Throwable {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}

