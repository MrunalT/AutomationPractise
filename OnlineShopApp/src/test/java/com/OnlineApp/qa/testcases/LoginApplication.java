package com.OnlineApp.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OnlineApp.qa.pages.HomePage;
import com.OnlineApp.qa.pages.LoginPage;
import com.OnlineApp.qa.pages.WomenStorePage;
import com.OnlineApp.qa.testBase.Testbase;


public class LoginApplication extends Testbase {
	HomePage homePage;
	LoginPage loginPage;
	WomenStorePage myAccount;
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
	}
	
	@Test(description = "Log in to Application")
	public void loginApplication()
	{
		myAccount = loginPage.loginApplication(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void closure()
	{
		homePage.clickLogout();
		driver.quit();
	}
	
	
	
	
	
}
