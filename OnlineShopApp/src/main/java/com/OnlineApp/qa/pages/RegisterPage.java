package com.OnlineApp.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;


public class RegisterPage extends Testbase{

	CommonFunction commonFunction;
	
	
	@FindBy(name = "customer_firstname")
	WebElement txtFirstName;
	
	@FindBy(name = "customer_lastname")
	WebElement txtLastName;
	
	@FindBy(name = "email")
	WebElement txtEmail;
	
	@FindBy(id = "passwd")
	WebElement txtPwd;
	
	@FindBy(id = "firstname")
	WebElement txtAddrFirstName;
	
	@FindBy(id = "lastname")
	WebElement txtAddrLastName;
	
	@FindBy(id = "address1")
	WebElement txtAddres;
	
	@FindBy(id = "city")
	WebElement txtCity;
	
	@FindBy(id = "id_state")
	WebElement ListState;
	
	@FindBy(id = "postcode")
	WebElement txtZip;
	
	@FindBy(id = "phone_mobile")
	WebElement txtPhone;
	
	@FindBy(id = "submitAccount")
	WebElement btnRgister;
	
	
	
	public RegisterPage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
	}
	
	
	
	public void fillRegisterForm(String FirstName, String LastName,
			String address1,String city, String State, String zip, 
			String Phone)
	{
		
		commonFunction.enterValue(txtFirstName, FirstName, "First Name", false);
		
		commonFunction.enterValue(txtLastName, LastName, "Last Name",false);
		
		
		Assert.assertEquals(txtEmail.getAttribute("value"),LoginPage.getNewUSer
				,"Email address not matched");
		Reporter.log("<br>Following prepopulated email address matched: "+txtEmail.getAttribute("value")+"</br>");
		
		commonFunction.enterValue(txtPwd, prop.getProperty("password"), "Password",true);
		
		commonFunction.enterValue(txtAddres, address1, "Address",false);
		
		commonFunction.enterValue(txtCity, city, "City",false);
		
		commonFunction.selectValFromDrpdwn(ListState, State, "State");
		
		commonFunction.enterValue(txtZip, zip, "Zip",false);
		
		commonFunction.enterValue(txtPhone, Phone, "Phone",false);
		
		commonFunction.click(btnRgister, "Register Button");
		
		Assert.assertEquals("My account - My Store", driver.getTitle(),"failed to create account");
		
		Reporter.log("<br>Account is created succesfully.</br>");
	}
}
