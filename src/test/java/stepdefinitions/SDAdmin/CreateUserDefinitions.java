package stepdefinitions.SDAdmin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.SDAdmin.CreateUserPage;

public class CreateUserDefinitions {

	@Steps
	CreateUserPage cup;

	@Then("User navigates to create user page")
	public void user_navigates_to_create_user_page() {

		cup.validateCreateUserPage();
	}

	@Then("User is created successfully")
	public void user_is_created_successfully() {

		
	}
}
