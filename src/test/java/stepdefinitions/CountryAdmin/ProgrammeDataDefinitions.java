package stepdefinitions.CountryAdmin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.CountryAdmin.ProgrammeDataPage;
import pages.SDAdmin.UsersPage;

public class ProgrammeDataDefinitions {

	@Steps
	CommonPage cp;

	@Steps
	ProgrammeDataPage pdp;
	
	@Then("Routine Vaccine Data is created successfully")
	public void routine_vaccine_data_is_created_successfully() {

		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Routine Vaccine Data is updated successfully")
	public void routine_vaccine_data_is_updated_successfully() {

		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Routine Vaccine Data is deleted successfully")
	public void routine_vaccine_data_is_deleted_successfully() {

		cp.validateDeletedMessageDisplayed();
	}

	@Then("Routine Vaccine producer {string} is visible in Routine Vaccination table to user")
	public void routine_vaccine_producer_is_visible_in_routine_vaccination_table_to_user(String producerName) {

		pdp.validateEntryInRoutineVaccinationTable(producerName);
	}
	
	@Then("Supplementary Vaccine Data is created successfully")
	public void supplementary_vaccine_data_is_created_successfully() {

		cp.validateCreatedMessageDisplayed();
	}

	@Then("Supplementary Vaccine producer {string} is visible in Supplementary Vaccination table to user")
	public void supplementary_vaccine_producer_is_visible_in_routine_vaccination_table_to_user(String producerName) {

		pdp.validateEntryInSupplementaryVaccinationTable(producerName);
	}

	@Then("Supplementary Vaccine Data is updated successfully")
	public void supplementary_vaccine_data_is_updated_successfully() {

		cp.validateUpdatedMessageDisplayed();
	}

	@Then("Supplementary Vaccine Data is deleted successfully")
	public void supplementary_vaccine_data_is_deleted_successfully() {

		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Child survival intervention Data is created successfully")
	public void child_survival_intervention_data_is_created_successfully() {

		cp.validateCreatedMessageDisplayed();
	}

	@Then("Child survival intervention product name {string} is visible in child survival intervention table to user")
	public void child_survival_intervention_product_name_is_visible_in_child_survival_intervention_table_to_user(String productName) {

		pdp.validateEntryInChildSurvivalInterventionTable(productName);
	}

	@Then("Child survival intervention Data is updated successfully")
	public void child_survival_intervention_data_is_updated_successfully() {

		cp.validateUpdatedMessageDisplayed();
	}

	@Then("Child survival intervention Data is deleted successfully")
	public void child_survival_intervention_data_is_deleted_successfullyl() {

		cp.validateDeletedMessageDisplayed();
	}


}
