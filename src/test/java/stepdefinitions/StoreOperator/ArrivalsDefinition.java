package stepdefinitions.StoreOperator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.ArrivalsPage;
public class ArrivalsDefinition {
	
	@Steps
	CommonPage cp;

	@Steps
	ArrivalsPage ap;
	
	@Then("Arrivals data is created successfully")
	public void arrival_is_created_sucessfully(){
	    
	    cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Arrivals data is update successfully")
	public void arrival_is_updated_sucessfully(){
	    
	    cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Arrivals data is deleted successfully")
	public void arrival_is_deleted_sucessfully(){
	    
	    cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Arrivals line is created successfully")
	public void arrivals_line_is_created_sucessfully() {

		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Arrivals line is updated successfully")
	public void arrival_line_is_updated_sucessfully() {

		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Arrivals line is deleted successfully")
	public void arrival_line_is_deleted_sucessfully() {

		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Arrivals Data is visible in arrivals table to user")
	public void arrivals_data_is_visible_in_stock_arrival_table_to_user() {

		ap.validateEntryInArrivalsTable();
	}

	@Then("Arrivals Data is not visible in arrivals table to user")
	public void arrivals_data_is_not_visible_in_stock_arrival_table_to_user() {

		ap.validateDeletedEntryInArrivalsTable();
	}
	
	@Then("Arrivals line Data is visible in arrival line table to user")
	public void arrivals_line_data_is_visible_in_arrival_table_to_user() {

		ap.validateEntryInArrivalsTable();
	}

	@Then("Arrivals line Data is not visible in arrival line table to user")
	public void arrivals_line_data_is_not_visible_in_arrival_table_to_user() {

		ap.validateDeletedEntryInArrivalsTable();
	}
	
	@And("Validate arrival state is {string}")
	public void validate_arrival_state_is(String state) {

		ap.validateStateOfArrivalEntry(state);
	}
	
	@When("User edit the Arrivals data")
	public void user_edit_the_arrivals_data() {

		ap.editArrivalsData();
	}
	
	@When("User edit the line in arrival")
	public void user_edit_the_line_in_arrival() {

		ap.editArrivalsLineData();
	}
	
	@When("User delete the Arrivals data")
	public void user_delete_the_arrivals_data() {

		ap.deleteArrivalsData();
	}
	
	@When("User delete the line in arrival")
	public void user_delete_the_line_in_arrival() {

		ap.deleteArrivalsLineData();
	}
}
