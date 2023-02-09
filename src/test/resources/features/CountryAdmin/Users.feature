Feature: Users tab in SMT application for Country Admin user
  We will be using this feature file for Users functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

  Background: User login to SMT application and navigate to Users tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Country Admin"
   	And   User select "Country Admin" from "Role" in "Settings" page
   	And   User click on "Apply" button
   	And   User click on "Users" tab
   	And   User wait for "5" seconds
   	
  #Scenario Outline: Verify user is able to add Store Operator Read Only role user with status as active and with email alerts
  #	Given User click on "Create New User" button
   #	Then  User navigates to create user page
   #	And   User enter "Automation" in "firstName"
   #	And   User enter "Testing" in "lastName"
   #	And   User enter random email in "userEmail"
   #	And   User select "<Role>" from "Role" in "Users" tab
   #	And   User type and select "<Region>" from "Region" in "Users" tab
   #	And   User type and select "<Country>" from "Country" in "Users" tab
   #	And   User select "<Level>" from "Level" in "Users" tab
   #	And   User type and select "<Level Two>" from "Level Two" in "Users" tab
   #	When  User click on "Submit" button
   #	And   User wait for "5" seconds
   #Then  User is created successfully //we commented this as error is displaye due to email configuration setting in dev enviroenment
   #	And   User click on "Store Data" tab
   #	And   User wait for "2" seconds
   #	And   User click on "Users" tab
   #	And   User wait for "5" seconds
   #	And   User click on "Active" tab
   #	Then  User validate newly "Created" user is present in users table
   #	Examples:
      #| Role                     | Region | Country              | Level  | Level Two |
      #| Store Operator Read Only | MENA   | United Arab Emirates | Level2 | Dubai 23  |
      #
  #Scenario: Verify user is able to update Store Operator Read Only role user with status as inactive and without email alerts
  #	Given User click on "Edit User" button for "Users"
   #	Then  User navigates to create user page
   #	And   User enter "Automation Updated" in "firstName"
   #	And   User enter "Testing Updated" in "lastName"
   #	And   User click on "Active" button
   #	And   User click on "Email Alerts" button
   #	When  User click on "Update" button
   #	And   User wait for "5" seconds
   #Then  User is created successfully //we commented this as error is displaye due to email configuration setting in dev enviroenment
   #	And   User click on "Store Data" tab
   #	And   User wait for "2" seconds
   #	And   User click on "Users" tab
   #	And   User wait for "5" seconds
   #	And   User click on "Inactive" tab
   #	Then  User validate newly "Updated" user is present in users table
      #
  #Scenario Outline: Verify user is able to add Store Operator Read Only role user with status as inactive and without email alerts
  #	Given User click on "Create New User" button
   #	Then  User navigates to create user page
   #	And   User enter "Automation" in "firstName"
   #	And   User enter "Testing" in "lastName"
   #	And   User enter random email in "userEmail"
   #	And   User click on "Active" button
   #	And   User click on "Email Alerts" button
   #	And   User select "<Role>" from "Role" in "Users" tab
   #	And   User type and select "<Region>" from "Region" in "Users" tab
   #	And   User type and select "<Country>" from "Country" in "Users" tab
   #	And   User select "<Level>" from "Level" in "Users" tab
   #	And   User type and select "<Level Two>" from "Level Two" in "Users" tab
   #	When  User click on "Submit" button
   #	And   User wait for "5" seconds
   #Then  User is created successfully //we commented this as error is displaye due to email configuration setting in dev enviroenment
   #	And   User click on "Store Data" tab
   #	And   User wait for "2" seconds
   #	And   User click on "Users" tab
   #	And   User wait for "5" seconds
   #	And   User click on "Inactive" tab
   #	Then  User validate newly "Created" user is present in users table
   #	Examples:
      #| Role                     | Region | Country              | Level  | Level Two |
      #| Store Operator Read Only | MENA   | United Arab Emirates | Level2 | Dubai 23  |
      
  Scenario Outline: Verify user is able to export users data
  	Given User click on "Active" tab
  	When  User click on "Export" button
  	Then  User verify data of UI and downloaded Excel for "Active" users
  	
  Scenario Outline: Verify user is able to export users data
  	Given User click on "Inactive" tab
  	When  User click on "Export" button
  	Then  User verify data of UI and downloaded Excel for "Inactive" users
  	
  Scenario Outline: Verify user is able to export users data
  	Given User click on "All Users" tab
  	When  User click on "Export" button
  	Then  User verify data of UI and downloaded Excel for "All Users" users
  	
  Scenario Outline: Verify user is able to export users data
  	Given User click on "Access Requested" tab
  	When  User click on "Export" button
  	Then  User verify data of UI and downloaded Excel for "Access Requested" users
  	