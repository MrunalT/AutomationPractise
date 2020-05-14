package com.OnlineApp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;

public class MyAccountPage extends Testbase{

	OrderHistoryPage orderHistory;
	CommonFunction commonFunction;
	
	@FindBy(xpath = "//*[@title = 'Orders']")
	WebElement btnOrderHistory;
	
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
	}
	
	
	public OrderHistoryPage clickOrderHistoryBtn()
	{
		commonFunction.click(btnOrderHistory, "Order History Button");
		
		Assert.assertEquals("Order history - My Store", driver.getTitle());
		Reporter.log("<br>Order History Page is opened.</br>");
		
		return new OrderHistoryPage();
	}
	
}
