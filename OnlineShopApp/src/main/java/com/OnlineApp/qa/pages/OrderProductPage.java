package com.OnlineApp.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;

public class OrderProductPage extends Testbase{
	CommonFunction commonFunction;
	JavascriptExecutor js ;
	public static String txtOrderID1;
	
	
	@FindBy(id = "total_price")
	WebElement totalAmtfield;
	
	@FindBy(xpath = "//*[text() = 'Proceed to checkout']")
	WebElement btnSummeryProceedToCheckout;
	
	@FindBy(xpath = "//*[contains(text(),'Shopping-cart summary')]")
	WebElement labelShoppingSummary;
	
	@FindBy(xpath = "//*[contains(text(),'Addresses')]")
	WebElement labelAddress;
	
	@FindBy(xpath = "//*[text()='Shipping' and @class= 'page-heading']")
	WebElement labelShipping;
	
	@FindBy(name = "processAddress")
	WebElement btnAddressProceedToCheckout;
	
	@FindBy(name = "processCarrier")
	WebElement btnShippingProceedToCheckout;
	
	@FindBy(xpath = "//*[contains(text(),'Please choose your payment method')]")
	WebElement labelPayement;
	
	@FindBy(id = "cgv")
	WebElement chkBxTermsOfService;
	
	@FindBy(xpath = "//*[@title= 'Pay by bank wire']")
	WebElement btnPaymentByBankWire;
	
	@FindBy(xpath = "//strong[text()= 'Your order on My Store is complete.']")
	WebElement labelOrderConfirmation;
	
	@FindBy(xpath = "//*[text() = 'I confirm my order']")
	WebElement btnConfirmOrder;
	
	@FindBy(xpath = "//*[@class = 'box']")
	WebElement txtOrderID;
	
	
	public OrderProductPage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
		js = (JavascriptExecutor) driver;
	}
	
	

	public void proceedToCheckout()
	{
		handleShoppingSummary();
		handleAddressTab();
		handleShipping();
		makePayment();
		confirmOrder();
	}
	
	public void handleShoppingSummary()
	{
		Assert.assertTrue(labelShoppingSummary.isDisplayed(), "Shopping summary page is not opened.");
		Reporter.log("<b><br>Shopping summary page is opened.</b></br>");
		
		String totalAmt = totalAmtfield.getText();
		Reporter.log("<b></br>Total Amount on shopping summary</br> "+totalAmt+"</b>");
	
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		commonFunction.click(btnSummeryProceedToCheckout, "Proceed to checkount button");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void handleAddressTab()
	{
		Assert.assertTrue(labelAddress.isDisplayed(), "Addresses page is not opened.");
		Reporter.log("<b><br>Addresses page is opened.</b></br>");
		
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		commonFunction.click(btnAddressProceedToCheckout, "Proceed to checkount button");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	public void handleShipping()
	{
		Assert.assertTrue(labelShipping.isDisplayed(), "Shipping page is not opened.");
		Reporter.log("<b><br>Shipping page is opened.</b></br>");
		
		js.executeScript("window.scrollBy(0,500)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		commonFunction.click(chkBxTermsOfService, "Terms of Service");
		
		commonFunction.click(btnShippingProceedToCheckout, "Proceed to checkount button");
		
	}
	
	public void makePayment()
	{
		Assert.assertTrue(labelPayement.isDisplayed(), "Payment page is not opened.");
		Reporter.log("<b><br>Payment page is opened.</b></br>");
		
		String totalAmt = totalAmtfield.getText();
		Reporter.log("<b></br>Total Amount on Payment Page</br> "+totalAmt+"</b>");
		
		commonFunction.click(btnPaymentByBankWire, "Payment by Bank wire button");
		
		Assert.assertTrue(btnConfirmOrder.isDisplayed(), "Order confirm page is not opened.");
		Reporter.log("<b><br>Order confirm page is opened.</b></br>");
		
	}
	
	public void confirmOrder() {
	
	commonFunction.click(btnConfirmOrder, "Order confirm button");
	
	Assert.assertTrue(labelOrderConfirmation.isDisplayed(), "Order confimation page is not opened.");
	Reporter.log("<b><br>Order is confirmed</b></br>");
	
	 txtOrderID1 = txtOrderID.getText();
	 Reporter.log("Following order information is displayed: <b>"+txtOrderID1+"</b>");
	}
	
	
}
