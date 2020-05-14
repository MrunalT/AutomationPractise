package com.OnlineApp.qa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.OnlineApp.qa.testBase.Testbase;
import com.OnlineApp.qa.utils.CommonFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;

public class WomenStorePage extends Testbase{
	CommonFunction commonFunction;
	JavascriptExecutor js;
	
	@FindBy(xpath = "//*[@title= 'Women']")
	WebElement btnWomen;
	
	@FindBy(xpath = "//*[@title = 'Continue shopping']")
	WebElement btnContinueShopping;
	
	public WomenStorePage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunction();
		
	}
	
	public void addProductToCart(String...product) 
	{
		Assert.assertTrue(btnWomen.isDisplayed(),"element not visible");
		
		for(String i : product) {
			
		commonFunction.click(btnWomen, "Woment Section");
		
		WebElement productItem = driver.findElement(By.xpath("//*[@title='"+i+"']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView();", productItem);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		js.executeScript("window.scrollTo(0, "+productItem.getLocation().x+")");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		commonFunction.click(productItem, i);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.switchTo().frame(
		        driver.findElements(By.tagName("iframe")).get(0));
		
		new WebDriverWait(driver, 20).until(
		    ExpectedConditions.elementToBeClickable(By
		        .xpath("//*[@type='submit' and @name = 'Submit']"))).click();
		
		Reporter.log("Clicked on Add to cart button.");
		
		 driver.switchTo().defaultContent();
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		commonFunction.click(btnContinueShopping, "Continue Shopping");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
		
	}
	
//	public OrderProductPage clickViewCartBtn()
//	{
//		commonFunction.click(btnViewCart, "View Cart Button");
//		Assert.assertEquals(driver.getTitle(), "Order - My Store");
//		
//		Reporter.log("<br><b>Shopping cart summary is opened<b></br>");
//		
//		return new OrderProductPage();
//	}
}
