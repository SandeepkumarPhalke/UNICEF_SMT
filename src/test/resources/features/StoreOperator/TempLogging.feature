Feature: Arrivals tab in SMT application for Store Operator user
  We will be using this feature file for Store Operator user using Arrivals functionality validations in SMT application mentioning all possible scenarios.

  Background: User login to SMT application and navigate to Arrivals tab
 	 	Given 	User is on home page
   	When  	User is getting correct title of home page
   	Then  	User click on login button
   	When  	User click on Proceed To Login button in "English"
   	Then  	User login as "Store Operator"
   	Given 	User click on "Apply" button
   	
  Scenario Outline: Verify user is able to add details of temperature, alarms and save
  	And   	User click on "Store Data" tab
  	Given   User click on "Add" button
  	And     "Add new storage data" heading is visible
  	And     User select "<Equipment category>" from "Equipment category" in "Store Data" tab
  	And     User select "<Supplier>" from "Supplier" in "Store Data" tab
  	And     User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Store Data" tab
  	And     User enter random text in "equipmentName"
  	And     User select "<Status>" from "Status" in "Store Data" tab
  	When    User click on "Create" button
  	Then    Storage Data is created successfully
  	And     Storage Data is visible in storage data table to user
   	And     User click on "Temp Logging" tab
   	Given   User click on "Edit" button in templogging tab
   	And     User wait for "1" seconds
  	And     User enter "valid" temperature details in table
  	When    User click on "Save" button in templogging tab
  	Then    Temperature logging data is created successfully
  	And     User wait for "10" seconds
  	Then    Temperature and alarm data is visible in table
  	Examples:
      | Equipment category | Supplier | Equipment Type/Model | Status     |
      | Walk In Freezer    | Haier    | VLS 354A AC          | Functional |
  	
  Scenario: Verify user is able to update details of temperature, alarms and save
  	And     User click on "Temp Logging" tab
  	Given   User click on "Edit" button in templogging tab
  	And     User enter "valid" temperature details in table
  	When    User click on "Save" button in templogging tab
  	And     User wait for "1" seconds
  	Then    Temperature logging data is created successfully
  	And     User wait for "10" seconds
  	Then    Temperature and alarm data is visible in table
  	
  Scenario: Verify user is able to cancel details of temperature, alarms
  	And     User click on "Temp Logging" tab
  	Given   User click on "Edit" button in templogging tab
  	And     User enter "valid" temperature details in table
  	When    User click on "Cancel" button in templogging tab
  	When    User click on "Yes" button
  	Then    Temperature and alarm data is visible in table
   	And   	User click on "Store Data" tab
   	Given   User click on delete button of newly created storage data
 		When    User click on "Yes" button
 		Then    Storage Data is deleted successfully
 		And     Storage Data is not visible in storage data table to user
  