Feature: Stock Overview tab in SMT application for Store Operator user
  We will be using this feature file for Stock Overview functionality validations in SMT application mentioning all possible scenarios for Store Operator user.

  Background: User login to SMT application and navigate to Store Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	And   User select "Store Operator" from "Role" in "Welcome" tab
   	And   User click on "Apply" button
   	And   User click on "Stock Overview" tab
   	And   User wait for "5" seconds
   	
  Scenario: Verify user is able to validate data is present for all the listed products
  	Given User is on stock overview page
  	Then  User validates the detail present against each product