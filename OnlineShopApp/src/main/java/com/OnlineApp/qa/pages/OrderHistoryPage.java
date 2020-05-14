package com.OnlineApp.qa.pages;

import java.util.List;

import javax.naming.InitialContext;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.OnlineApp.qa.testBase.Testbase;

public class OrderHistoryPage extends Testbase {
	
	

	OrderHistoryPage()
	{
		
	}
	public void verifyOrderHistoryAmount()
	{
		
		  List  col = driver.findElements(By.xpath("//*[@id='order-list']/thead/tr/th"));
	        System.out.println("No of cols are : " +col.size()); 
	        //No.of rows 
	        List  rows = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr/td[1]")); 
	        System.out.println("No of rows are : " + rows.size());
	        String orderRef;
	        for (int i =1;i<=rows.size();i++)
	        {    
	        	orderRef= driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[1]")).getText().trim();
	        	if(OrderProductPage.txtOrderID1.contains(orderRef))
	        	{
	        		String getAmt = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[3]")).getText().trim();
	        		System.out.println("Amount on History "+getAmt);
	        		Reporter.log("<br>The amount of order id <b>"+orderRef+"</b> under ORDER HISTORY is verified.</br>"
	        				+ "<br> verified value: <b>"+getAmt+"</b>");
	        		break;
	        	}
	            
	        }
	}

}
