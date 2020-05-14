package com.OnlineApp.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;

public class HomePage extends Testbase{
	
	LoginPage loginPage;
	MyAccountPage myAcc;
	CommonFunction commonFunction;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign in')]")
	WebElement btnSignIn;
	
	@FindBy(xpath = "//*[@title = 'View my customer account']")
	WebElement btnMyProfile;
	
	@FindBy(xpath = "//*[@title = 'View my shopping cart']")
	WebElement btnViewCart;
	
	@FindBy(className = "logout")
	WebElement btnSignOFF;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
	}
	
	public void verifyHomePageTitle()
	{
		Assert.assertEquals("My Store", driver.getTitle(),"Failed to open Home page");
		Reporter.log("<br><b>Application invoked successfully.</b></br>");
		Reporter.log("<br><b>Home Page is displayed.</b></br>");
	}
	
	public LoginPage clickSignIn()
	{
		commonFunction.click(btnSignIn, "Sign In Button");
		Assert.assertEquals("Login - My Store", driver.getTitle(),"Failed to open Sign in page");
		Reporter.log("<br><b>Sign In Page is displayed.</b></br>");
		
		return new LoginPage();
	}	
	
	public MyAccountPage clickMyProfile()
	{
		commonFunction.click(btnMyProfile, "My Profile Button");
		Assert.assertEquals("My account - My Store", driver.getTitle(),"Failed to open My Profile page");
		Reporter.log("<br><b>My Account Page is displayed.</b></br>");
		
		return new MyAccountPage();
	}
	
	public OrderProductPage clickViewCartBtn()
	{
		commonFunction.click(btnViewCart, "View Cart Button");
		Assert.assertEquals(driver.getTitle(), "Order - My Store","Failed to open Shopping summary page");
		Reporter.log("<br><b>Shopping cart summary is opened<b></br>");
		
		return new OrderProductPage();
	}
	
	public void clickLogout()
	{
		commonFunction.click(btnSignOFF, "Sign off Button");
	}
}
