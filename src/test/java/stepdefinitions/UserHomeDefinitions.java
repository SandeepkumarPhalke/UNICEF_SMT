package stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.UserHomePage;

public class UserHomeDefinitions {
	
	@Steps
	UserHomePage uhp;
	
	@Then("User is signed in and navigated to user home page")
	public void user_is_signed_in_and_navigated_to_user_home_page() {
	    
	   uhp.validateSignedinUserNameLogo();
	}
}
