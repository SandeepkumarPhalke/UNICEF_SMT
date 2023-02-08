Feature: Users tab in SMT application for SD Admin user
  We will be using this feature file for create user functionality validations in SMT application mentioning all possible scenarios for SD Admin user.

  Background: User login to SMT application
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "SD Admin"
   	And   User click on "Users" tab
   	And   User wait for "2" seconds
    
  	Scenario Outline: Verify user is able to create new SD Admin role user
   		Given User click on "Create New User" button
   		Then  User navigates to create user page 
   		And   User enter "<First Name>" in "firstName"
   		And   User enter "<Last Name>" in "lastName"
   		And   User enter random email in "userEmail"
   		And   User select "<Role>" from "Role" in "Users" tab
   		When  User click on "Submit" button
   		And   User wait for "5" seconds
   #		Then  User is created successfully //we commented this as error is displaye due to email configuration setting in dev enviroenment
   		Examples:
      | First Name | Last Name | Role     |
      | Automation | Testing   | SD Admin |