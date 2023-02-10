Feature: Store Data tab in SMT application for Country Admin user
  We will be using this feature file for Store Data functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

  Background: User login to SMT application and navigate to Store Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Country Admin"
   	And   User select "Country Admin" from "Role" in "Settings" page
   	And   User click on "Apply" button
   	And   User click on "Store Data" tab
   	And   User wait for "2" seconds
   	
  Scenario: Verify user is able to validate exported hierarchy
  	Given User click on "Store Hierarchy" tab
  	And   User wait for "2" seconds
		When  User click on "Export Hierarchy" button
		And   User wait for "5" seconds
		Then  User verify data of UI and downloaded Excel for store hierarchy
		
	Scenario: Verify user is able to update level names
  	Given User click on "Store Hierarchy" tab
		When  User update store level names
		Then  User validate the updated level names
		And   User update previous store level names
		
	Scenario Outline: Verify user is not able to delete store hierarchy as data is associated with them
  	Given User click on "Store Hierarchy" tab
  	When  User click on "Delete Store Hierarchy" button
  	And   User wait for "3" seconds
		Then  "<Heading>" heading is visible
		And   User click on "OK" button
		Examples:
			|Heading                                                                                                                      |
			|This action cannot be completed as one or more stores in the hierarchy have store operators and/or data associated with them |
			
	Scenario: Verify user is able to import hierarchy and validate the store
  	Given User click on "Store Hierarchy" tab
  	And   User wait for "2" seconds
		When  User click on "Export Hierarchy" button
		And   User wait for "5" seconds
		And   User copy downloaded file into repository
		Then  User make necessary changes to exported hierarchy
		Then  User click on "Import Hierarchy" button
		Then  User verify data of UI and downloaded Excel for store hierarchy