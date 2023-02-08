package stepdefinitions.SDAdmin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.SDAdmin.UsersPage;

public class UsersDefinitions {

	@Steps
	UsersPage up;
	
	@Steps
	CommonPage cp;

	@Then("User navigates to create user page")
	public void user_navigates_to_create_user_page() {

		up.validateCreateUserPage();
	}

	@Then("User is created successfully")
	public void user_is_created_successfully() {

		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("User validate created user is present in users table")
	public void user_validate_created_user() {
	    
		up.validateUserCreationInUsersTable();
	}
}
