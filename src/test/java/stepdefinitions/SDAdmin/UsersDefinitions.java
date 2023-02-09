package stepdefinitions.SDAdmin;

import java.io.IOException;

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
	
	@Then("User validate newly {string} user is present in users table")
	public void user_validate_created_user(String actionType) {
	    
		if(actionType.equals("created")) {
			
			up.validateUserCreationInUsersTable();
		}else if(actionType.equals("updated")) {
			
			up.validateUserUpdationInUsersTable();
		}
	}
	
	@Then("User verify data of UI and downloaded Excel for {string} users")
	public void user_verify_data_of_ui_and_downloaded_excel_for_users(String string) throws IOException {
	   
		up.validateUIAndExcelData();
	}

	
}
