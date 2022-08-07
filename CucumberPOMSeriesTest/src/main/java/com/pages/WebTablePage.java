package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTablePage {
	private WebDriver driver;
	private By webTable = By
			.xpath("//legend[text()='Web Table Example']//following::table[1]/descendant::tr/child::td[3]");
	private By webTableFixHeader = By.xpath("//legend[text() ='Web Table Fixed header']//following::div//tr//td[3]");
	private By radioButton = By.xpath("//legend[text()='Radio Button Example']//following::label//input");
	String BeforeradioButton = "(//legend[text()='Radio Button Example']//following::label//input)[";
	String AfterradioButton ="]";
	
	String BeforecourseRow = "(//legend[text()='Web Table Example']//following::table[1]/descendant::tr/child::td[3])[";
	String AfterCourseRow = "]/parent::tr";
	String BeforewebTableFixHeaderRow = "(//legend[text() ='Web Table Fixed header']//following::div//tr)[";
	String AfterwebTableFixHeaderRow = "]";

	// public condtructor of the page class
	public WebTablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getWebTablePriceList() {
		ArrayList<String> priceListBeforeSorting = new ArrayList<>();
		ArrayList<WebElement> priceListFromTable = (ArrayList<WebElement>) driver.findElements(webTable);
		for (WebElement e : priceListFromTable) {
			String text = e.getText();
			priceListBeforeSorting.add(text);

		}
		System.out.println(priceListBeforeSorting);

		HashSet<String> priceListWithoutDuplicate = new HashSet<>(priceListBeforeSorting);

		System.out.println(priceListWithoutDuplicate);
		ArrayList<String> PriceListNewAfterSorting = new ArrayList<>(priceListWithoutDuplicate);
		Collections.sort(PriceListNewAfterSorting, Collections.reverseOrder());

		System.out.println("Sorting price" + PriceListNewAfterSorting);

		for (int i = 0; i <= priceListBeforeSorting.size() - 1; i++) {
			if (PriceListNewAfterSorting.get(0) == priceListBeforeSorting.get(i)) {
				String rowContentswithHighestPrice = getWholeRow(i + 1);
				System.out.println("Printing the row which having the highest price :"+rowContentswithHighestPrice);
			}
		}

	}

	public String getWholeRow(Integer i) {

		return driver.findElement(By.xpath(BeforecourseRow + i + AfterCourseRow)).getText();

	}
	
	public void getWebTableFixedHeaderContentByCity(String City)
	{
		List<WebElement>cityNameList = driver.findElements(webTableFixHeader);

		
		
		List<String>updateCityNameList = new ArrayList<>();
		for (int i = 0; i <= cityNameList.size() - 2; i++)
		{
			updateCityNameList.add(cityNameList.get(i).getText());
			System.out.println("updateCityNameList :"+updateCityNameList);
			if (City.equals(updateCityNameList.get(i))) 
			{
				//System.out.println("City :"+updateCityNameList.get(i));
				String contentOfFixedHeader = getWholeRowForFIxedHeader(i + 2);
				System.out.println("Printing the row which having the reqired city :"+contentOfFixedHeader);
			}
		}
		
		
	}
	public String getWholeRowForFIxedHeader(Integer i )
	{
		return driver.findElement(By.xpath(BeforewebTableFixHeaderRow + i + AfterwebTableFixHeaderRow)).getText();
	}
	
	public void checkRadioButton()
	{
	 List<WebElement>radioButton1 = driver.findElements(radioButton);
	 for(int i=1;i<=3;i++)
	 {
		 if (radioButton1.get(i).isSelected())
		 
			 driver.findElement(By.xpath(BeforeradioButton+ (i+1) +AfterradioButton));
		 
		 else
			 driver.findElement(By.xpath(BeforeradioButton+ i +AfterradioButton)).click();
			 
	 }
	 
		
	
	}
}
