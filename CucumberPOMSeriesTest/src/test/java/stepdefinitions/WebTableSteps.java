package stepdefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.LoginPage;
import com.pages.WebTablePage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class WebTableSteps {
	public WebTablePage webTablePage = new WebTablePage(DriverFactory.getDriver());
	
	@Given("user is on practice page")
	public void user_is_on_practice_page() {
		DriverFactory.getDriver()
		.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@When("user gets the highest price of the table")
	public void user_gets_the_highest_price_of_the_table() {
		webTablePage.getWebTablePriceList();
		
	
	   
	}
	@When("get all the names position and amount from the table which belongs to the {string}")
	public void get_all_the_names_position_and_amount_from_the_table_which_belongs_to_the(String City) {
 		webTablePage.getWebTableFixedHeaderContentByCity(City);
	}
	
	@When("radio button is working fine")
	public void radio_button_is_working_fine() {
	    webTablePage.checkRadioButton();
	}




}
