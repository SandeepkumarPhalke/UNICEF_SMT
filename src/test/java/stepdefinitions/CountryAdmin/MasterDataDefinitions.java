package stepdefinitions.CountryAdmin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.CountryAdmin.MasterDataPage;
import pages.CountryAdmin.ProgrammeDataPage;
import pages.SDAdmin.UsersPage;

public class MasterDataDefinitions {

	@Steps
	CommonPage cp;

	@Steps
	MasterDataPage mdp;
	
	@Then("Country specific vaccine data is created successfully")
	public void country_specific_vaccine_data_is_created_successfully() {
	    
		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Country specific vaccine data is updated successfully")
	public void country_specific_vaccine_data_is_updated_successfully() {
	    
		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Country specific vaccine data is deleted successfully")
	public void country_specific_vaccine_data_is_deleted_successfully() {
	    
		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Country specific supply data is created successfully")
	public void country_specific_supply_data_is_created_successfully() {
	    
		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Country specific supply data is updated successfully")
	public void country_specific_supply_data_is_updated_successfully() {
	    
		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Country specific supply data is deleted successfully")
	public void country_specific_supply_data_is_deleted_successfully() {
	    
		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Country specific producers data is created successfully")
	public void country_specific_producers_data_is_created_successfully() {
	    
		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Country specific producers data is updated successfully")
	public void country_specific_producers_data_is_updated_successfully() {
	    
		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Country specific producers data is deleted successfully")
	public void country_specific_producers_data_is_deleted_successfully() {
	    
		cp.validateDeletedMessageDisplayed();
	}

	@Then("Country specific vaccine with producer {string} is visible in country specific vaccination table to user")
	public void country_specific_vaccine_is_visible_in_country_specific_vaccination_table_to_user(String producer) {
	    
		mdp.validateCountrySpecificVaccine(producer);
	}
	
	@Then("Country specific supply with product type {string} is visible in country specific supplies table to user")
	public void country_specific_supply_with_product_type_is_visible_in_country_specific_supplies_table_to_user(String productType) {
	    
		mdp.validateCountrySpecificSupply(productType);
	}

	@Then("Country specific producer with producer type {string} is visible in country specific producer table to user")
	public void country_specific_producer_with_producer_type_is_visible_in_country_specific_producer_table_to_user(String producerTypeName) {
	    
		mdp.validateCountrySpecificProducer(producerTypeName);
	}

	@Then("Country specific equipment data is created successfully")
	public void country_specific_equipment_data_is_created_successfully() {
	    
		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Country specific equipment data is updated successfully")
	public void country_specific_equipment_data_is_updated_successfully() {
	    
		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Country specific equipment data is deleted successfully")
	public void country_specific_equipment_data_is_deleted_successfully() {
	    
		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Country specific equipment with equipment category {string} is visible in country specific equipment table to user")
	public void country_specific_equipment_with_equipment_category_is_visible_in_country_specific_equipment_table_to_user(String equipmentCategoryName) {

		mdp.validateCountrySpecificEquipment(equipmentCategoryName);
	}
	
	@Then("Country specific target group is created successfully")
	public void country_specific_target_group_is_created_successfully() {
		
		cp.validateCreatedMessageDisplayed();
	}
	
	@Then("Country specific target group is updated successfully")
	public void country_specific_target_group_is_updated_successfully() {
		
		cp.validateUpdatedMessageDisplayed();
	}
	
	@Then("Country specific target group is deleted successfully")
	public void country_specific_target_group_is_deleted_successfully() {
		
		cp.validateDeletedMessageDisplayed();
	}
	
	@Then("Country specific target group is not deleted successfully")
	public void country_specific_target_group_is_not_deleted_successfully() {
		
		mdp.validateNotDeletedMessageDisplayed_TargetGroup();
	}

	@Then("Country specific target group with english name is visible in country specific target group table to user")
	public void country_specific_target_group_with_english_name_is_visible_in_country_specific_target_group_table_to_user() {
	 
		mdp.validateCountrySpecificTargetGroupIsVisible();
	}
	
	@Then("Country specific target group with english name is not visible in country specific target group table to user")
	public void country_specific_target_group_with_english_name_is_not_visible_in_country_specific_target_group_table_to_user() {
	 
		mdp.validateCountrySpecificTargetGroupIsNotVisible();
	}
	
	@Then("Country specific used target group with english name is not visible in country specific target group table to user")
	public void country_specific_used_target_group_with_english_name_is_not_visible_in_country_specific_target_group_table_to_user() {
	 
		mdp.validateCountrySpecificUsedTargetGroupIsNotVisible();
	}


}
