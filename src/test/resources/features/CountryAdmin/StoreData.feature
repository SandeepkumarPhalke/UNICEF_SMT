Feature: Master Data tab in SMT application for Country Admin user
  We will be using this feature file for Master Data functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

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
   	
  Scenario: Verify user is able to add Country Specific Vaccine
  	Given User click on "Store Hierarchy" tab
		When  User click on "Export Hierarchy" button
		Then  User verify data of UI and downloaded Excel for store hierarchy