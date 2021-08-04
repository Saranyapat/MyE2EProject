package com.myproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class AddressPage extends BaseClass{
	
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedtoCheckout;
	@FindBy (id = "addressesAreEquals")
	WebElement checkBox;
	
	public AddressPage(){
		PageFactory.initElements(getDriver(), this);
		
	}
	  /*public void sameAdresscheckBox() {
		  action.isEnabled(driver,checkBox);
		
	  }*/
public ShippingPage clickOnCheckout() throws Throwable {
	//action.fluentWait(driver, proceedtoCheckout, 10);
	Thread.sleep(3000);
	action.scrollByVisibilityOfElement(getDriver(), proceedtoCheckout);
	action.click(getDriver(), proceedtoCheckout);
	return new ShippingPage();
}
}
