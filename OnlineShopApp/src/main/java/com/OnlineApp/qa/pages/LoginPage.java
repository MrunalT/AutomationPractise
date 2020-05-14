package com.OnlineApp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;


public class LoginPage extends Testbase {
	
	
	CommonFunction commonFunction;
	public static String getNewUSer;
	RegisterPage registerPage;
	WomenStorePage myAccount;
	
	@FindBy(id = "email_create")
	WebElement txtEmailAddress;
	
	@FindBy(id = "SubmitCreate")
	WebElement btnCreateAccount;
	
	@FindBy(xpath = "//*[contains(text(), 'Create an account')]")
	WebElement labelCreateAccount;
	
	@FindBy(id = "email")
	WebElement txtEmailID;
	
	@FindBy(name = "passwd")
	WebElement txtPassword;
	
	@FindBy(name = "SubmitLogin")
	WebElement btnLogin;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
	}
	
	public RegisterPage createAccount(String eMail, String sitename)
	{
		 getNewUSer = commonFunction.createNewUser(eMail, sitename);
		commonFunction.enterValue(txtEmailAddress, getNewUSer, "Email Address", false);
		
		commonFunction.click(btnCreateAccount, "Create Account Button");
		
		Assert.assertTrue(labelCreateAccount.isDisplayed(), "Create Account Info Page is not displayed.");
		
		Reporter.log("<br>Create Account Info Page is displayed.</br>");
		
		return new RegisterPage();
	}
	
	public WomenStorePage loginApplication(String emailAddress ,String password )
	{
		commonFunction.enterValue( txtEmailID,emailAddress, "Registered Email Address", false);
		
		commonFunction.enterValue( txtPassword,password, "Registered Password", true);
		
		commonFunction.click(btnLogin, "Login Button");
		
		Assert.assertEquals("My account - My Store", driver.getTitle(),"failed to create account");
		
		Reporter.log("<br>Account is Logged in succesfully.</br>");
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		return new WomenStorePage();
		
		
	}
	
	
	

}
