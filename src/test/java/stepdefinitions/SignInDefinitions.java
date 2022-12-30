package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.SignInPage;

public class SignInDefinitions {

	@Steps
	SignInPage sp;

	@Then("User enter email {string}")
	public void user_enter_email(String email) {

		sp.enterEmail(email);
	}

	@Then("User enter password")
	public void user_enter_password() {

		sp.enterPassword();
	}

	@When("User click on sign in button")
	public void user_click_on_sign_in_button() throws InterruptedException {

		sp.clickSignInButton();
		Thread.sleep(10000);
	}

	@Given("User is on sign in page")
	public void user_is_on_sign_in_page() {

		sp.validateSignInButtonOnHomePage();
	}
	
	@Then("Login error message is displayed to user")
	public void login_error_message_is_displayed_to_user() {
	   
		sp.validateLoginErrorMessageText();
	}
}
