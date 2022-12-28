package stepdefinitions.StoreOperator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

		cp.createdMessageDisplayed();
	}

	@Then("Storage Data is updated successfully")
	public void storage_data_is_updated_sucessfully() {

		cp.updatedMessageDisplayed();
	}

	@Then("Storage Data is deleted successfully")
	public void storage_data_is_deleted_sucessfully() {

		cp.deletedMessageDisplayed();
	}

	@Then("Storage Data is visible in storage data table to user")
	public void storage_data_is_visible_in_storage_data_table_to_user() {

		sdp.validateEntryInStorageDataTable();
	}

	@Then("Storage Data is not visible in storage data table to user")
	public void storage_data_is_not_visible_in_storage_data_table_to_user() {

		sdp.validateDeletedEntryInStorageDataTable();
	}

	@Given("User click on edit button of newly created storage data")
	public void user_click_on_edit_button_of_newly_created_storage_data() {

		sdp.editStorageDataRecord();
	}

	@Given("User click on delete button of newly created storage data")
	public void user_click_on_delete_button_of_newly_created_storage_data() {

		sdp.deleteStorageDataRecord();
	}
}
