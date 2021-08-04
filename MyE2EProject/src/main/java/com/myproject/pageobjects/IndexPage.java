package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class IndexPage extends BaseClass {
		
	Action action= new Action();
		
		@FindBy(xpath = "//a[@class='login']") 
		private WebElement signInBtn;
		
		@FindBy(xpath = "//img[@class='logo img-responsive']")
		private WebElement myStoreLogo;
		
		@FindBy(id="search_query_top")
		private WebElement searchProductBox;
		
		@FindBy(name="submit_search")
		private WebElement searchButton;
		
		public IndexPage() {
			PageFactory.initElements(getDriver(), this);
		}
		
		public LoginPage clickOnSignIn() throws Throwable {
			signInBtn.click();
			//action.fluentWait(driver, signInBtn, 10);
			//action.click(driver, signInBtn);
			return new LoginPage(getDriver());
		}
		
		public boolean validateLogo() throws Throwable {
			//myStoreLogo.isDisplayed();
			return action.isDisplayed(getDriver(), myStoreLogo);
		}
		
		public String getMyStoreTitle() {
			String myStoreTitel=getDriver().getTitle();
			return myStoreTitel;
		}
		
		public SearchResultPage searchProduct(String productName) throws Throwable {
			
		action.type(searchProductBox, productName);
			//action.scrollByVisibilityOfElement(driver, searchButton);
			action.click(getDriver(), searchButton);
			Thread.sleep(3000);
			return new SearchResultPage();
		}
		
		

	}

