package com.OnlineApp.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OnlineApp.qa.pages.HomePage;
import com.OnlineApp.qa.pages.LoginPage;
import com.OnlineApp.qa.pages.RegisterPage;
import com.OnlineApp.qa.testBase.Testbase;

public class RegisterUser extends Testbase {

	HomePage homePage;
	LoginPage loginPage;
	RegisterPage registerPage;
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
	}
	
	@Test(dataProvider="SearchProvider",description = "Register user to application")
	public void registerUserTest(String FirstName, String LastName,
			String address1,String city, String State, String zip, 
			String Phone)
	{
		loginPage = homePage.clickSignIn();
		registerPage = loginPage.createAccount(prop.getProperty("user"), prop.getProperty("sitename"));
		registerPage.fillRegisterForm(FirstName, LastName, address1, city, 
				State, zip, Phone);
		
	}

	@AfterMethod
	public void closure()
	{
		homePage.clickLogout();
		driver.quit();
	}
	

	@DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Mrunal", "Tare", "37th street", "Miami", 
				"Florida", "41057", "9009878990"}
           
        };
	}
	
}
