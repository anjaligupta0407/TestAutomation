package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@id='center_column']//span");
	
	public AccountPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getAccountsSectionsList(){
		List<String>accountList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		for(WebElement e:accountsHeaderList)
		{
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
			
		}
		return accountList;

		
	}
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}


}
