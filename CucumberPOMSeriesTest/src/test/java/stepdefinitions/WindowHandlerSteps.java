package stepdefinitions;

import com.pages.LoginPage;
import com.pages.WindowHandlerPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WindowHandlerSteps {
	
	private WindowHandlerPage windowHandler = new WindowHandlerPage (DriverFactory.getDriver());
	@Given("user is on OrangeHrm page")
	public void user_is_on_orange_hrm_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
			    
	}

	@When("user switch on window {string}")
	public void user_switch_on_window(String ExpectedWindowTitle) {
		windowHandler.clickWindow(ExpectedWindowTitle);
	}

	
}
