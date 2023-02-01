package stepdefinitions;

import java.awt.AWTException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.HomePage;
import pages.SignInPage;
import pages.CountryAdmin.ProgrammeDataPage;
import pages.SDAdmin.CreateUserPage;
import pages.StoreOperator.ArrivalsPage;
import pages.StoreOperator.IssuingPage;
import pages.StoreOperator.PhysicalCountAndAdjustmentsPage;
import pages.StoreOperator.ReportsPage;
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

	@Steps
	CreateUserPage cup;

	@Steps
	ReportsPage rp;

	@Steps
	ProgrammeDataPage pdp;

	@Steps
	PhysicalCountAndAdjustmentsPage pcaap;

	@Given("User is on home page of SMT application")
	public void user_is_on_home_page_of_smt_application() {

		hp.open();
	}

	@When("User click on {string} tab")
	public void user_click_on_tab(String tabName) {

		cp.clickOnTab(tabName);
	}

	@When("User login as {string}")
	public void user_login_as(String userRole) throws InterruptedException {

		sip.userLogin(userRole);
		Thread.sleep(10000);
	}

	@When("User click on {string} button")
	public void user_click_on_button(String buttonName) {

		cp.clickOnButton(buttonName);
	}

	@When("User click on {string} button for {string}")
	public void user_click_on_button(String buttonName, String tabName) {

		if (tabName.equals("Programme Data")) {

			pdp.clickOnButton_ProgrammeData(buttonName);
		}
	}

	@Then("{string} heading is visible")
	public void heading_is_visible(String headingName) {

		cp.validateIsHeadingVisible(headingName);
	}

	@Given("{string} text is visible")
	public void text_is_visible(String text) {

		cp.validateTextIsVisible(text);
	}

	@Given("User wait for {string} seconds")
	public void user_wait_for_seconds(String time) {

		cp.waitForTime(time);
	}

	@Given("User enter random number in {string}")
	public void user_enter_random_number_in(String textField) {

		cp.enterRandomNumber(textField);
	}

	@Given("User enter random text in {string}")
	public void user_enter_random_text_in(String textField) {

		cp.enterRandomText(textField);
	}

	@Given("User enter random email in {string}")
	public void user_enter_random_email_in(String textField) {

		cp.enterRandomEmail(textField);
	}

	@And("User enter {string} in {string}")
	public void user_enter_in(String text, String textboxName) {

		cp.enterTextInTextbox(text, textboxName);
	}

	@Given("User select {string} from {string} in {string} tab")
	public void user_select_from_in_tab(String value, String dropdownName, String tabName) {

		if (tabName.equals("Store Data")) {

			sdp.selectValueFromDropdown_StoreData(value, dropdownName);
		} else if (tabName.equals("Arrivals")) {

			ap.selectValueFromDropdown_Arrivals(value, dropdownName);
		} else if (tabName.equals("Issuing")) {

			ip.selectValueFromDropdown_Issuing(value, dropdownName);
		} else if (tabName.equals("Users")) {

			cup.selectValueFromDropdown_Users(value, dropdownName);
		} else if (tabName.equals("Physical Count & Adjustments")) {

			pcaap.selectValueFromDropdown_PhysicalCountAndAdjustments(value, dropdownName);
		} else if (tabName.equals("Reports")) {

			rp.selectValueFromDropdown_Reports(value, dropdownName);
		} else if (tabName.equals("Programme Data")) {

			pdp.selectValueFromDropdown_ProgrammeData(value, dropdownName);
		} else {

			cp.selectValueFromDropdown(value, dropdownName);
		}
	}

	@Given("User type and select {string} from {string} in {string} tab")
	public void user_type_and_select_from(String value, String dropdownName, String tabName) throws AWTException {

		if (dropdownName.equals("Product Category") || dropdownName.equals("Storage Temperature")) {
			cp.typeAndSelectValueFromDropdownWithInput(value, dropdownName);
		} else {

			cp.typeAndSelectValueFromDropdown(value, dropdownName);
		}
	}

	@Then("Verify {string} value is {string}")
	public void verify_value_is(String textField, String textFieldExpectedValue) {

		cp.validateValueOfWebElement(textField, textFieldExpectedValue);
	}

	@Then("User press escape button on keyboard")
	public void user_press_button_on_keyboard() {

		cp.pressEscapeKeyOfKeyboard();
	}

}
