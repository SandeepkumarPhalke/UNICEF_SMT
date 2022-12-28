package stepdefinitions;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.HomePage;
import pages.SignInPage;
import pages.StoreOperator.ArrivalsPage;
import pages.StoreOperator.IssuingPage;
import pages.StoreOperator.StoreDataPage;

public class CommonDefinitions {

	@Steps
	HomePage hp;

	@Steps
	CommonPage cp;

	@Steps
	StoreDataPage sdp;

	@Steps
	ArrivalsPage ap;
	
	@Steps
	IssuingPage ip;

	@Steps
	SignInPage sip;
	
	@Given("User is on home page")
	public void user_is_on_home_page() {

		hp.open();
	}

	
	
	@When("User click on {string} tab")
	public void user_click_on_tab(String tabName) {

		cp.clickOnTab(tabName);
	}
	
	@When("User login as {string}")
	public void user_login_as(String userType) {

		if(userType.equals("Store Operator")) {
			
			sip.userLogin(userType);
		}
	}

	@When("User click on {string} button")
	public void user_click_on_button(String buttonName) {

		cp.clickOnButton(buttonName);
	}

	@Then("{string} heading is visible")
	public void heading_is_visible(String headingName) {

		cp.isHeadingVisible(headingName);
	}

	@Given("{string} text is visible")
	public void text_is_visible(String text) {

		cp.textIsVisible(text);
	}

	@Given("User wait for {string} seconds")
	public void user_wait_for_seconds(String time) throws NumberFormatException, InterruptedException {

		Thread.sleep(Integer.parseInt(time)*1000);
	}
	
	@Given("User enter random number in {string}")
	public void user_enter_random_number_in(String textField) {

		cp.enterRandomNumber(textField);
	}

	@Given("User enter random text in {string}")
	public void user_enter_random_text_in(String textField) {

		cp.enterRandomText(textField);
	}

	@And("User enter {string} in {string}")
	public void user_enter_in(String text, String textboxName) {

		cp.enterTextInTextbox(text, textboxName);
	}

	@Given("User select {string} from {string} in {string} tab")
	public void user_select_from(String value, String dropdownName, String tabName) {

		if (tabName.equals("Store Data")) {

			sdp.selectValueFromDropdown_StoreData(value, dropdownName);
		} else if (tabName.equals("Arrivals")) {

			ap.selectValueFromDropdown_Arrivals(value, dropdownName);
		} else if (tabName.equals("Issuing")) {

			ip.selectValueFromDropdown_Issuing(value, dropdownName);
		}

	}
	
	@Given("User type and select {string} from {string} in {string} tab")
	public void user_type_and_select_from(String value, String dropdownName, String tabName) {

		if (tabName.equals("Issuing")) {

			ip.selectValueFromDropdown_Issuing(value, dropdownName);
		}

	}

}
