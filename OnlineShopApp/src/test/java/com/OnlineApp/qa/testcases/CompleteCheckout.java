package com.OnlineApp.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OnlineApp.qa.pages.HomePage;
import com.OnlineApp.qa.pages.LoginPage;
import com.OnlineApp.qa.pages.OrderProductPage;
import com.OnlineApp.qa.pages.WomenStorePage;
import com.OnlineApp.qa.testBase.Testbase;

public class CompleteCheckout extends Testbase{
	HomePage homePage;
	LoginPage loginPage;
	WomenStorePage womenStorePage;
	OrderProductPage orderProductPage;
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
		
	}

	@Test(dataProvider="SearchProvider",description = "proceed to checkout after adding product")
	public void completeCheckout(String...products)
	{
		loginPage = homePage.clickSignIn();
		womenStorePage = loginPage.loginApplication(prop.getProperty("email"), prop.getProperty("password"));
		womenStorePage.addProductToCart(products);
		orderProductPage = homePage.clickViewCartBtn();
		orderProductPage.proceedToCheckout();
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
