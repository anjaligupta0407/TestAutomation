package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandlerPage {
	private WebDriver driver;
	private By linkedinLink = By.xpath("//a[@href= 'http://www.linkedin.com/groups?home=&gid=891077']");
	private By FacebookLink = By.xpath("//a[@href='http://www.facebook.com/OrangeHRM']");
	private By twitterLink = By.xpath("//a[@href='http://twitter.com/orangehrm']");
	private By youtubeLink = By.xpath("//a[@href='http://www.youtube.com/orangehrm']");
	
   public WindowHandlerPage(WebDriver driver) {
	this.driver=driver;
    }
   public void clickWindow(String ExpectedWindowTitle)
   {
	   String parentWindowId = driver.getWindowHandle();
	   driver.findElement(linkedinLink).click();
	     driver.findElement(FacebookLink).click();
	     driver.findElement(twitterLink).click();
	     driver.findElement(youtubeLink).click();
	     Set<String> windowId = driver.getWindowHandles();
	     List <String> getID = new ArrayList<>(windowId);  
	     if(switchToRightWindow(ExpectedWindowTitle,getID))
	     {
	    	 System.out.println(driver.getCurrentUrl()+ ":" +driver.getTitle());
	     }
	     driver.switchTo().window(parentWindowId);
	     closeAllthwWindowsExceptParent(getID,parentWindowId);
	     
   }
   public void closeAllthwWindowsExceptParent(List<String> getID,String parentWindowId)
   {
	   for(String e:getID)
	   {
		   if(!e.equals(parentWindowId))
		   {
			   driver.switchTo().window(e).close();
		   }
	   }
   }
   public boolean switchToRightWindow(String ExpectedWindowTitle,List<String> getID)
   {
        for(String id : getID)
     {
    	 String actualtitle = driver.switchTo().window(id).getTitle();
    	 if(actualtitle.contains(ExpectedWindowTitle))
    	 {
    	 System.out.println("found the right window :"+actualtitle);
    	 return true;
    	 }
     }
     
    return false;
   }
}
