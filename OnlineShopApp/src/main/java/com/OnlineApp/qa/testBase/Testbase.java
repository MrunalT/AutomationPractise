package com.OnlineApp.qa.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String filePath = System.getProperty("user.dir");
	public static Reporter report;
	//load config.properties file
	public Testbase() {
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(filePath+"\\src\\main\\java\\com\\OnlineApp\\qa\\config\\config.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//initial set up - load driver, select browser, hit url 
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Mrunal\\chromedriver.exe");
	
		if(prop.getProperty("browser").contains("chrome"))
		 driver = new ChromeDriver();
		 
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		 
	}
	
	//quit driver
	public void close()
	{
		driver.quit();
	}
}
