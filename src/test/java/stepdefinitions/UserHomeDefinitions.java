package stepdefinitions;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.UserHomePage;

public class UserHomeDefinitions {

	@Steps
	UserHomePage uhp;
	
	@Then("User is signed in")
	public void user_is_signed_in() {
	    
	   uhp.validateHomePage();
	}
}
