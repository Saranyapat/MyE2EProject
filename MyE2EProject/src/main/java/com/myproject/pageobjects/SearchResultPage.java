package com.myproject.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
Action action= new Action();

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	//@FindBy(xpath="//div[@Class='product-image-container']")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), productResult);
		action.fluentWait(getDriver(), productResult, 10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return action.isDisplayed(getDriver(), productResult);
		//return productResult.isDisplayed();
	}
	
	public AddtoCartPage clickOnProduct() throws Throwable {
		//action.scrollByVisibilityOfElement(driver, productResult);
		action.click(getDriver(), productResult);
		//click(driver, productResult);
		return new AddtoCartPage();
	}
}