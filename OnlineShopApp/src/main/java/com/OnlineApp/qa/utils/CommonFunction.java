package com.OnlineApp.qa.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.OnlineApp.qa.testBase.Testbase;

public class CommonFunction extends Testbase{




	public void click(WebElement element, String objectName)
	{
		element.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Reporter.log("<br> Clicked on <b>"+objectName+"</b></br>");
	}

	public void enterValue(WebElement element, String value, String objectName, boolean mask)
	{
		element.sendKeys(value);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(mask)
		{
			value = maskString(value);
		}

		Reporter.log("<br><b>"+value+"</b> is Entered in <b>"+objectName+"</b></br>");
	}



	public void selectValFromDrpdwn(WebElement element, String visibleText, String objectName)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Reporter.log("<br><b>"+visibleText+"</b> is selected in <b>"+objectName+"</b></br>");
	}

	public String maskString(String val)
	{
		String maskedString = null;
		for(int i = 0; i < val.length() ;i++ )
		{
			maskedString = maskedString+("*");
		}

		return maskedString;

	}

	public String createNewUser(String email, String siteNames) {

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		String timestamp = df.format(dateobj).toString()
				.replaceAll(" ", "").replaceAll(":", "").replaceAll("/", "");
		String userId  = email+"_"+timestamp+"@"+siteNames.trim()+".com";
		return userId;
		
	}
}
