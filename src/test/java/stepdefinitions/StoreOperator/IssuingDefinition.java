package stepdefinitions.StoreOperator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.IssuingPage;
public class IssuingDefinition {
	
	@Steps
	CommonPage cp;

	@Steps
	IssuingPage ip;
	
	@Then("Issuing data is created successfully")
	public void issuing_is_created_sucessfully(){
	    
	    cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Issuing data is update successfully")
	public void issuing_is_updated_sucessfully(){
	    
	    cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Issuing data is deleted successfully")
	public void issuing_is_deleted_sucessfully(){
	    
	    cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Issuing line is created successfully")
	public void issuing_line_is_created_sucessfully() {

		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Issuing line is updated successfully")
	public void issuing_line_is_updated_sucessfully() {

		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Issuing line is deleted successfully")
	public void issuing_line_is_deleted_sucessfully() {

		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Issuing Data is visible in issuing table to user")
	public void issuing_data_is_visible_in_issuing_table_to_user() {

		ip.validateEntryInIssuingTable();
	}

	@Then("Issuing Data is not visible in issuing table to user")
	public void issuing_data_is_not_visible_in_issuing_table_to_user() {

		ip.validateDeletedEntryInIssuingTable();
	}
	
	@Then("Issuing line Data is visible in issuing line table to user")
	public void issuing_line_data_is_visible_in_issuing_line_table_to_user() {

		ip.validateEntryInIssuingTable();
	}

	@Then("Issuing line Data is not visible in issuing line table to user")
	public void issuing_line_data_is_not_visible_in_storage_data_table_to_user() {

		ip.validateDeletedLineEntryInIssuingTable();
	}
	
	@And("Validate issuing state is {string}")
	public void validate_issuing_state_is(String state) {

		ip.validateStateOfIssuingEntry(state);
	}
	
	@When("User edit the Issuing data")
	public void user_edit_the_issuing_data() {

		ip.editIssuingData();
	}
	
	@When("User edit the line in issuing")
	public void user_edit_the_line_in_issuing() {

		ip.editIssuingLineData();
	}
	
	@When("User delete the Issuing data")
	public void user_delete_the_issuing_data() {

		ip.deleteIssuingData();
	}
	
	@When("User delete the line in issuing")
	public void user_delete_the_line_in_issuing() {

		ip.deleteIssuingLineData();
	}
}
