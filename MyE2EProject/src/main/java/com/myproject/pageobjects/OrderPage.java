package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class OrderPage extends BaseClass {

	Action action = new Action();
	
		//@FindBy (xpath ="//span[@class='price special-price']")
	@FindBy (xpath ="//*[@id='product_price_1_3_0']")
		WebElement  unitPrice;
		
		@FindBy(xpath ="//span[@id='total_price']")
		WebElement totalPrice;
		
		@FindBy(xpath="//span[text()='Proceed to checkout']")
		WebElement proceedtoCheckout;
		
		public OrderPage() {
			PageFactory.initElements(getDriver(), this);
		}
		
		public double getUnitPrice() {
			
			action.scrollByVisibilityOfElement(getDriver(), unitPrice);
			
			action.fluentWait(getDriver(), unitPrice,10);
			String UP=unitPrice.getText();
			String unit=UP.replaceAll("[^a-zA-Z0-9]","");
			double finalUnitPrice=Double.parseDouble(unit);
			return finalUnitPrice/100;
		}
		
		public double getTotalPrice() {
			action.fluentWait(getDriver(), unitPrice,10);
			String TP=totalPrice.getText();
			String tot=TP.replaceAll("[^a-zA-Z0-9]","");
			double finalTotalPrice=Double.parseDouble(tot);
			return finalTotalPrice/100;
		}
		
		public LoginPage clickOnCheckOut() throws Throwable {
			//action.fluentWait(driver, proceedtoCheckout,10);
			action.scrollByVisibilityOfElement(getDriver(), proceedtoCheckout);
			action.click(getDriver(), proceedtoCheckout);
			return new LoginPage(getDriver());
		}
}