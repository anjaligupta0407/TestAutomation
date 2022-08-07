package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// 1.By Locators

	private By emailId = By.id("email");
	private By passWord = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPassword = By.xpath("//a[text()='Forgot your password?']");
	private By webTable = By
			.xpath("//legend[text()='Web Table Example']//following::table[1]/descendant::tr/child::td[3]");
	String BeforecourseRow = "(//legend[text()='Web Table Example']//following::table[1]/descendant::tr/child::td[3])[";
	String AfterCourseRow = "]/parent::tr";

	// public condtructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions: features(behaviour) of the page the form of methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}

	public AccountPage doLogin(String un, String ps)// it will landing on the account page
	{
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(passWord).sendKeys(ps);
		driver.findElement(signInButton).click();
		return new AccountPage(driver);// its method responsibility to give you the object of landing page

	}

	
}
