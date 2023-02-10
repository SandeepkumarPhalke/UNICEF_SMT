package stepdefinitions.StoreOperator;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.StoreDataPage;

public class StoreDataDefinition {

	@Steps
	StoreDataPage sdp;

	@Steps
	CommonPage cp;

	@Then("Storage Data is created successfully")
	public void storage_data_is_created_sucessfully() {

		cp.validateCreatedMessageDisplayed();
	}

	@Then("Storage Data is updated successfully")
	public void storage_data_is_updated_sucessfully() {

		cp.validateUpdatedMessageDisplayed();
	}

	@Then("Storage Data is deleted successfully")
	public void storage_data_is_deleted_sucessfully() {

		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Storage Data is not deleted successfully")
	public void storage_data_is_not_deleted_sucessfully() {

		sdp.validateNotDeletedMessageDisplayed_StoreData();
	}

	@Then("Storage Data is visible in storage data table to user")
	public void storage_data_is_visible_in_storage_data_table_to_user() {

		sdp.validateEntryInStorageDataTable();
	}

	@Then("Storage Data is not visible in storage data table to user")
	public void storage_data_is_not_visible_in_storage_data_table_to_user() {

		sdp.validateDeletedEntryInStorageDataTable();
	}

	@Given("User click on edit button of storage data")
	public void user_click_on_edit_button_of_storage_data() {

		sdp.editStorageDataRecord();
	}

	@Given("User click on delete button of storage data")
	public void user_click_on_delete_button_of_storage_data() {

		sdp.deleteStorageDataRecord();
	}
	
	@Given("User click on delete button of newly created storage data")
	public void user_click_on_delete_button_of_newly_created_storage_data() {

		sdp.deleteNewStorageDataRecord();
	}
	
	@Given("User verify data of UI and downloaded Excel for store hierarchy")
	public void user_verify_data_of_ui_and_download_excel_for_store_hierarchy() throws IOException {

		sdp.validateUIAndExcelData();
	}
	
	@When("User update store level names")
	public void user_update_store_level_name_and_verify() {
	    
		sdp.updateLevelNameToAutomationNames();
	}
	
	@When("User update previous store level names")
	public void user_update_previous_store_level_name_and_verify() {
	    
		sdp.updateLevelNameToPreviousNames();
	}
	
	@Then("User validate the updated level names")
	public void user_validate_the_updated_level_names() {
	    
		sdp.validateLevelNameToAutomationNames();
	}
}
