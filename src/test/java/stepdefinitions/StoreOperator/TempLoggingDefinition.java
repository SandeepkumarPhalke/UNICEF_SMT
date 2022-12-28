package stepdefinitions.StoreOperator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.IssuingPage;
import pages.StoreOperator.TempLoggingPage;

public class TempLoggingDefinition {

	@Steps
	TempLoggingPage tlp;
	
	@Steps
	CommonPage cp;

	@When("User click on {string} button in templogging tab")
	public void user_click_on_button_in_templogging_tab(String buttonName) {

		if (buttonName.equals("Edit")) {

			tlp.clickOnEditTemperatureButton(buttonName);
		} else if (buttonName.equals("Save")) {

			tlp.clickOnSaveTemperatureButton(buttonName);
		} else if (buttonName.equals("Cancel")) {

			tlp.clickOnCancelTemperatureButton(buttonName);
		}

	}
	
	@And("User enter {string} temperature details in table")
	public void user_enter_temperature_details_in_table(String entryType) {
		
		if(entryType.equals("valid")) {
			
			tlp.enterValidDetailsInTable();
		}
	}
	
	@Then("Temperature logging data is created successfully")
	public void temperature_logging_data_created_sucessfully(){
	    
	    cp.createdMessageDisplayed();
	}
	
	@Then("Temperature and alarm data is visible in table")
	public void temperature_and_alarm_data_is_visible_in_table(){
	    
	    tlp.validateDetailsInTable();
	}
	
}
