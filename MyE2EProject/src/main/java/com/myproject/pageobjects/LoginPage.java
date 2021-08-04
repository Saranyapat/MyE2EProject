package com.myproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myproject.actiondriver.Action;
import com.myproject.base.BaseClass;

public class LoginPage extends BaseClass{
	
	

	Action action= new Action();
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public HomePage Login(String uname, String pword) throws InterruptedException {

		action.fluentWait(getDriver(), userName,10);
		action.scrollByVisibilityOfElement(getDriver(), signInBtn);
		userName.clear();
		userName.sendKeys(uname);
		password.clear();
		password.sendKeys(pword);
		signInBtn.click();
		Thread.sleep(2000);
		HomePage homePage = new HomePage(getDriver());
		return homePage;
	}
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signInBtn);
		return addressPage;
	/*public AddressPage Login(String uname, String pword,AddressPage addressPage) throws InterruptedException {

		//action.fluentWait(driver, userName,10);
		Thread.sleep(2000);
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pword);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;*/
		
		/*//action.fluentWait(driver, userName,10);
		action.scrollByVisibilityOfElement(driver, signInBtn);
		userName.clear();
		userName.sendKeys(uname);
		password.clear();
		password.sendKeys(pword);
		signInBtn.click();
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return addressPage;*/
	}
	public RegisterPage RegisterNewAccount(String newemail) {
		action.fluentWait(getDriver(), emailForNewAccount,10);
		emailForNewAccount.clear();
		emailForNewAccount.sendKeys(newemail);
		createNewAccountBtn.click(); 
		return new RegisterPage();
	}
	
}
