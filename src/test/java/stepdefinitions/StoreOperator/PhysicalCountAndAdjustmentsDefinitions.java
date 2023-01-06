package stepdefinitions.StoreOperator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.ArrivalsPage;
import pages.StoreOperator.PhysicalCountAndAdjustmentsPage;

public class PhysicalCountAndAdjustmentsDefinitions {

	@Steps
	CommonPage cp;

	@Steps
	PhysicalCountAndAdjustmentsPage pcaap;

	@And("User edit the details of arrival data created")
	public void user_edit_the_details_of_arrival_data_created() {

		pcaap.editPhysicalCountAndAdjustmentsRecord();
	}

	@Then("Arrivals data is saved successfully")
	public void arrivals_data_is_saved_successfully() {

		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Arrivals data is updated successfully")
	public void arrivals_data_is_updated_successfully() {

		cp.validateUpdatedMessageDisplayed();
	}

	@Then("User click on acceptAdjustment checkbox")
	public void user_click_on_acceptadjustment_checkbox() {

		pcaap.clickAcceptAdjustmentCheckbox();
	}

	@Then("Updated {string} data is visible in Physical Count & Adjustments tab")
	public void updated_data_is_visible_in_tab(String expectedQuantity) {

		pcaap.validateUpdatedDataOnPhysicalCountAndAdjustmentsTab(expectedQuantity);
	}

	@When("User click on {string} button in arrivals tab")
	public void user_click_on_button_in_arrivals_tab(String buttonName) {

		pcaap.clickOnButton(buttonName);
	}

	@Then("User is able to see difference of updated quantity as {string}")
	public void user_is_able_to_see_difference_of_updated_quantity(String expectedDifferenceQuantity) {

		pcaap.validateUpdatedDifference(expectedDifferenceQuantity);
	}
	
	@Then("User is able to see batch number details of arrival adjusted")
	public void user_is_able_to_see_details_of_arrival() {
	    
		pcaap.validateArrivalAdjustedDetails();
	}
}
