package com.OnlineApp.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OnlineApp.qa.pages.HomePage;
import com.OnlineApp.qa.pages.LoginPage;
import com.OnlineApp.qa.pages.MyAccountPage;
import com.OnlineApp.qa.pages.OrderHistoryPage;
import com.OnlineApp.qa.pages.OrderProductPage;
import com.OnlineApp.qa.pages.WomenStorePage;
import com.OnlineApp.qa.testBase.Testbase;

public class VerifyOrderHistory extends Testbase{

	HomePage homePage;
	LoginPage loginPage;
	WomenStorePage womenStorePage;
	OrderProductPage orderProductPage;
	MyAccountPage myAccountPage;
	OrderHistoryPage orderHistoryPage;
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
	}

	@Test(dataProvider="SearchProvider",description = "Check order amt on history page after ordering product")
	public void verifyOrderAmtOnHistory(String...products)
	{
		homePage.verifyHomePageTitle();
		loginPage = homePage.clickSignIn();
		womenStorePage = loginPage.loginApplication(prop.getProperty("email"), prop.getProperty("password"));
		womenStorePage.addProductToCart(products);
		orderProductPage = homePage.clickViewCartBtn();
		orderProductPage.proceedToCheckout();
		myAccountPage = homePage.clickMyProfile();
		orderHistoryPage = myAccountPage.clickOrderHistoryBtn();
		orderHistoryPage.verifyOrderHistoryAmount();
		
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
            { "Faded Short Sleeve T-shirts","Blouse" },
           
        };

    }
	
}
