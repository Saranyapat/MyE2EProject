package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class AddtoCartPage extends BaseClass {
	

Action action = new Action();
	@FindBy(xpath="//*[@id=\"quantity_wanted\"]")
	WebElement quantity;

	@FindBy(xpath="//*[@id=\"group_1\"]")
	WebElement size;

	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addtocartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	

	public AddtoCartPage() {
	PageFactory.initElements(getDriver(), this);
}
 
	public void enterQuantity(String quantity1) throws Throwable {
		//action.scrollByVisibilityOfElement(driver, quantity);
		action.type(quantity, quantity1);
}
	public void selectSize(String size1) throws Throwable {
		//action.scrollByVisibilityOfElement(driver, size);
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), addtocartBtn);
		action.click(getDriver(), addtocartBtn);
		
	}
	
	public boolean validateAddtoCart() throws Throwable {
		
		action.fluentWait(getDriver(), addToCartMessage, 10);
		return action.isDisplayed(getDriver(), addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), proceedToCheckOutBtn);
		action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
