package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
 public WebDriver driver;
 //ThreadLocal is used to create the copy of the instance and used for parrell execution
 public static ThreadLocal<WebDriver> TLdriver = new ThreadLocal<>();
 /**
  * this method is used to initialize the Thread local driver on the basis of given browser
  * @param browser
  * @return this will return tldriver
  */
 
 public WebDriver init_driver(String browser)
 {
	 System.out.println("Browser valu is :"+browser);
	 if(browser.equals("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 TLdriver.set(new ChromeDriver());
	 }
	 else if(browser.equals("firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
		 TLdriver.set(new FirefoxDriver());
	 }
	 else if(browser.equals("safari"))
	 {
		 TLdriver.set(new SafariDriver());
	 }
	 else
		 System.out.println("Please enter the correct browser name :"+browser);
	 
	 getDriver().manage().deleteAllCookies();
	 getDriver().manage().window().maximize();
	 return getDriver();
	 //return webdriver
 }
 /**
  * this is used to get the driver with thread local
  * @return
  */
 
 public static synchronized WebDriver getDriver()//5 threads are running together and they all would be in a sync so will use syncronized
 {
	 return TLdriver.get();
	 //return the webdriver
 }
}
