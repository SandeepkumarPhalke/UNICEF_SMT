package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.SignInPage;

public class SignInDefinitions{
	
	@Steps
	SignInPage sp;
	
	@When("User is getting correct title of home page")
	public void user_is_getting_correct_title_of_home_page() {
	    
		sp.validateHomePage();
	}
	
	@Then("User enter email")
	public void user_enter_email() {
	    
		sp.enterEmail();
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
	

	@Then("{string} button is displayed")
	public void button_is_displayed(String string) {
	    
	    sp.signInButtonIsDisplayed();
	}
	
	@Given("User enter {string} email")
	public void user_enter_email(String email) {
	   
		sp.enterEmail(email);
	}
	
	@Given("User enter {string} password")
	public void user_enter_password(String password) {
	   
		sp.enterPassword(password);
	}


}
