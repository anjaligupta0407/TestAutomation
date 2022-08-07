package stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;// no need to create a object to use account page class because login page is
									// landing to the account page

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String passWord = credList.get(0).get("password");
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		accountPage = loginPage.doLogin(userName, passWord);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);

	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
      List<String>expAccountSectionsList = sectionsTable.asList();
      System.out.println("Expected accounts section list: " + expAccountSectionsList);
      List<String>actualAccountSectionsList  = accountPage.getAccountsSectionsList();
      System.out.println("Actual accounts section list: " + actualAccountSectionsList);
      Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
      
      
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountPage.getAccountsSectionCount() == expectedSectionCount);

	}

}
