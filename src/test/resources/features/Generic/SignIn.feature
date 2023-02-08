Feature: SignIn to SMT application
  We will be using this feature file for Login functionality validations in SMT application mentioning all possible scenarios.

  Background: User navigate to sign in page of SMT application
 	  Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
 		
  	Scenario Outline: Login to the application with valid credentials
    	Given User is on sign in page
    	And   User enter email "<Email>"
    	And   User enter password
    	When  User click on sign in button
    	Then  User is signed in and navigated to user home page
    	Examples:
      | Email  									 |
      | coamilind@mailinator.com |
    
   	Scenario Outline: Login to the application with invalid credentials
    	Given User is on sign in page
    	And   User enter email "<Email>"
    	And   User enter password
    	When  User click on sign in button
    	Then  Login error message is displayed to user
    	Examples:
      | Email  						|
      | sandeep@e-zest.in |
      
      
      
      