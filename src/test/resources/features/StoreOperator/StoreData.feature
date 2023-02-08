Feature: Store Data tab in SMT application for Store Operator user
  We will be using this feature file for Store Data functionality validations in SMT application mentioning all possible scenarios for Store Operator user.

  Background: User login to SMT application and navigate to Store Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	And   User select "Store Operator" from "Role" in "Settings" page
   	And   User click on "Apply" button
   	And   User click on "Store Data" tab
   	And   User wait for "2" seconds
   	
  Scenario Outline: Verify user is able to add storage data
  	Given User click on "Add" button
  	And   "Add new storage data" heading is visible
  	And   User select "<Equipment category>" from "Equipment category" in "Store Data" tab
  	And   User select "<Supplier>" from "Supplier" in "Store Data" tab
  	And   User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Store Data" tab
  	And   User enter random text in "equipmentName"
  	And   User select "<Status>" from "Status" in "Store Data" tab
  	When  User click on "Create" button
  	Then  Storage Data is created successfully
  	And   Storage Data is visible in storage data table to user
  	Examples:
      | Equipment category | Supplier | Equipment Type/Model | Status     |
      | Walk In Freezer    | Haier    | VLS 354A AC          | Functional |
      
 	Scenario Outline: Verify user is able to update storage data
 		Given User click on edit button of storage data
 		And   User wait for "1" seconds
  	And   User select "<Equipment category>" from "Equipment category" in "Store Data" tab
  	And   User wait for "1" seconds
  	And   User select "<Supplier>" from "Supplier" in "Store Data" tab
  	And   User wait for "1" seconds
  	And   User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Store Data" tab
  	And   User enter random text in "equipmentName"
  	And   User select "<Status>" from "Status" in "Store Data" tab
  	When  User click on "Update" button
  	Then  Storage Data is updated successfully
  	And   Storage Data is visible in storage data table to user
  	Examples:
      | Equipment category | Supplier | Equipment Type/Model | Status         |
      | Freezer            | Haier    | BFRV55               | Non Functional |
      
  Scenario: Verify user is able to delete storage data
 		Given User click on delete button of storage data
 		When  User click on "Yes" button
 		Then  Storage Data is deleted successfully
 		And   Storage Data is not visible in storage data table to user
 		
 	Scenario Outline: Verify user is not able to delete storage data already in use
 		Given User click on "Add" button
  	And   "Add new storage data" heading is visible
  	And   User select "<Equipment category>" from "Equipment category" in "Store Data" tab
  	And   User select "<Supplier>" from "Supplier" in "Store Data" tab
  	And   User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Store Data" tab
  	And   User enter random text in "equipmentName"
  	And   User select "<Status>" from "Status" in "Store Data" tab
  	When  User click on "Create" button
  	Then  Storage Data is created successfully
  	And   Storage Data is visible in storage data table to user
  	And   User click on "Arrivals" tab
		And   User wait for "3" seconds
		When  User click on "Log New Arrival" button
  	Then  "Stock Arrival" text is visible
  	And   User select "<Receipt Type>" from "Receipt Type" in "Arrivals" tab
  	And   User enter random text in "smtNumber"
  	And   User enter random number in "shippingReferance"
  	And   User enter random text in "fundingSource"
  	And   User select "<Currency>" from "Currency" in "Arrivals" tab
  	And   User enter random number in "freightCost"
		When  User click on "Add Line to Arrival" button
  	Then  "Add Product to Arrival" heading is visible
  	And   User select "<Product Type>" from "Product Type" in "Arrivals" tab
  	And   User select "<Product>" from "Product" in "Arrivals" tab
  	And   User enter random text in "batchNo"
  	And   User select "<Producer>" from "Producer" in "Arrivals" tab
  	And   User select "<Commercial Name>" from "Commercial Name" in "Arrivals" tab
  	And   User select "<Formulation>" from "Formulation" in "Arrivals" tab
  	And   User select "<Presentation>" from "Presentation" in "Arrivals" tab
  	And   User select "<VVM Stage>" from "VVM Stage" in "Arrivals" tab
  	And   User enter "<Units>" in "units"
  	And   User select "<Routine or SIA>" from "Routine or SIA" in "Arrivals" tab
  	And   User select "<Origin>" from "Origin" in "Arrivals" tab
  	And   User select "<Shipping/Freeze Indicator>" from "Shipping/Freeze Indicator" in "Arrivals" tab
  	And   User enter "<No Of Vials>" in "noOfVials"
  	And   User enter "<Volume>" in "totalVolume"
  	And   User select "<Storage Location>" from "Storage Location" in "Arrivals" tab
  	And   User enter "<Total Cost>" in "totalCost"
  	And   User enter random text in "comments"
  	When  User click on "Create" button
  	And   User click on "Continue" button
  	Then  Arrivals line is created successfully
  	And   Arrivals line Data is visible in arrival line table to user
  	When  User click on "Save as draft and go back" button
  	And   User click on "Yes" button
  	And   Validate arrival state is "Draft"
  	Then  Arrivals Data is visible in arrivals table to user
  	And   User click on "Store Data" tab
   	And   User wait for "2" seconds
  	And   User click on delete button of newly created storage data
 		When  User click on "Yes" button
 		Then  Storage Data is not deleted successfully
 		And   User wait for "2" seconds
 		And   Storage Data is visible in storage data table to user
  	Examples:
      | Equipment category | Supplier | Equipment Type/Model | Status     | Receipt Type | Currency | Product Type | Product     | Producer                       | Commercial Name | Formulation          | Presentation | VVM Stage       | Routine or SIA | Origin    | Shipping/Freeze Indicator | Storage Location    | Units | No Of Vials | Volume | Total Cost |
      | Walk In Freezer    | Haier    | VLS 354A AC          | Functional | Arrival      | AUD      | Vaccine      | bOPV        | PT ONEJECT INDONESIA           | BIOPOLIO B1/3   | Liquid: ready to use | 10           | 1.Initial stage | Routine        | Indonesia | Alarm                     | Newly Created Value | 20    | 20          | 20     | 1000       |
 		