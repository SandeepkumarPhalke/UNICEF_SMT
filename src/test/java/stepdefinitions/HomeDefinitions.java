package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;

public class HomeDefinitions{
	
	@Steps
	HomePage hp;
	
	@When("User select {string} from language dropdown")
	public void user_select_from_language_dropdown(String language) throws InterruptedException {
	    
		hp.changeLanguage(language);
	}

	@Then("{string} is displayed on the home page")
	public void is_displayed_on_the_home_page(String homeText) {
	    
	    hp.isCorrectHomePageTextExists(homeText);
	}
	
	@Then("User click on login button")
	public void user_click_on_login_button() {
	    
		hp.clickLoginButton();
	}
	
	@When("User click on Proceed To Login button in {string}")
	public void user_click_on_proceed_to_login_button_in(String language) throws InterruptedException {
	    
		hp.clickProceedToLoginButton(language);
	}

}
