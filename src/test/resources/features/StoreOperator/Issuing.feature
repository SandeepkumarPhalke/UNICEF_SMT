Feature: Arrivals tab in SMT application for Store Operator user
  We will be using this feature file for Store Operator user using Arrivals functionality validations in SMT application mentioning all possible scenarios.

  Background: User login to SMT application and navigate to Arrivals tab
 	 	Given User is on home page
   	When  User is getting correct title of home page
   	Then  User click on login button
   	When  User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	Given User click on "Apply" button
   	And   User click on "Issuing" tab
   	
  Scenario Outline: Verify user is able to add issuing line and issuing requisition type data and finalize
  	Given   User click on "Issue New Stock" button
  	And     "Issue New Stock" text is visible
  	And     User select "<Issue Type>" from "Issue Type" in "Issuing" tab
  	And     User type and select "<Recipient Store>" from "Recipient Store / Reason" in "Issuing" tab
  	And     User select "<Distributed Option>" from "Distributed Late" in "Issuing" tab
  	And     User wait for "10" seconds
  	And     User enter random text in "internationaRef"
  	When    User click on "Add Line to Issue" button
  	Then    "Add Product to Issue" heading is visible
  	And     User select "<Product Type>" from "Product Type" in "Issuing" tab
  	And     User select "<Product>" from "Product" in "Issuing" tab
  	And     User select "<Batch Number>" from "Batch Number" in "Issuing" tab
  	And     User wait for "3" seconds
  	And     User enter "<Units>" in "dosesOrUnit"
  	And     User enter random text in "comment"
  	Then    User click on "Save" button
  	Then    Issuing line is created successfully
  	And     Issuing line Data is visible in issuing line table to user
  	When    User click on "Finalize" button
  	Then    Issuing line is updated successfully
  	And     User wait for "5" seconds
  	And     Validate issuing state is "Complete"
  	Examples:
  
      | Issue Type  | Recipient Store | Distributed Option | Product Type | Product | Batch Number | Units |
      | Requisition | Dubai 2         | No                 | Vaccine      | YF      | 200A         | 1     |    
      
   Scenario Outline: Verify user is able to edit issuing line and issuing requisition type data before finalizing
  	Given   User click on "Issue New Stock" button
  	And     "Issue New Stock" text is visible
  	And     User select "<Issue Type>" from "Issue Type" in "Issuing" tab
  	And     User type and select "<Recipient Store>" from "Recipient Store / Reason" in "Issuing" tab
  	And     User select "<Distributed Option>" from "Distributed Late" in "Issuing" tab
  	And     User wait for "10" seconds
  	And     User enter random text in "internationaRef"
  	When    User click on "Add Line to Issue" button
  	Then    "Add Product to Issue" heading is visible
  	And     User select "<Product Type>" from "Product Type" in "Issuing" tab
  	And     User select "<Product>" from "Product" in "Issuing" tab
  	And     User select "<Batch Number>" from "Batch Number" in "Issuing" tab
  	And     User wait for "3" seconds
  	And     User enter "<Units>" in "dosesOrUnit"
  	And     User enter random text in "comment"
  	Then    User click on "Save" button
  	Then    Issuing line is created successfully
  	And     Issuing line Data is visible in issuing line table to user
  	When    User click on "Save as draft and go back" button
  	And     Validate issuing state is "Draft"
  	And     User edit the Issuing data
  	And     "View Issued Stock" text is visible
  	And     User select "<Issue Type>" from "Issue Type" in "Issuing" tab
  	And     User type and select "<Recipient Store>" from "Recipient Store / Reason" in "Issuing" tab
  	And     User select "<Distributed Option>" from "Distributed Late" in "Issuing" tab
  	And     User wait for "10" seconds
  	And     User enter random text in "internationaRef"
  	When    User edit the line in issuing
  	Then    "Editing Issued Stock" heading is visible
  	And     User select "<Product Type>" from "Product Type" in "Issuing" tab
  	And     User select "<Product>" from "Product" in "Issuing" tab
  	And     User select "<Batch Number>" from "Batch Number" in "Issuing" tab
  	And     User wait for "3" seconds
  	And     User enter "<Units>" in "dosesOrUnit"
  	And     User enter random text in "comment"
  	Then    User click on "Update" button
  	Then    Issuing line is updated successfully
  	When    User click on "Finalize" button
  	Then    Issuing line is updated successfully
  	And     User wait for "5" seconds
  	And     Validate issuing state is "Complete"
  	Examples:
  
      | Issue Type  | Recipient Store | Distributed Option | Product Type | Product | Batch Number | Units |
      | Requisition | Dubai 2         | No                 | Vaccine      | YF      | 200A         | 1     |    
      
  
  Scenario Outline: Verify user is able to delete issuing line and delete issuing requisition type data before finalizing
  	Given   User click on "Issue New Stock" button
  	And     "Issue New Stock" text is visible
  	And     User select "<Issue Type>" from "Issue Type" in "Issuing" tab
  #	And     User type and select "<Recipient Store>" from "Recipient Store / Reason" in "Issuing" tab
  	And     User select "<Distributed Option>" from "Distributed Late" in "Issuing" tab
  	And     User wait for "10" seconds
  	And     User enter random text in "internationaRef"
  	When    User click on "Add Line to Issue" button
  	Then    "Add Product to Issue" heading is visible
  	And     User select "<Product Type>" from "Product Type" in "Issuing" tab
  	And     User select "<Product>" from "Product" in "Issuing" tab
  	And     User select "<Batch Number>" from "Batch Number" in "Issuing" tab
  	And     User wait for "3" seconds
  	And     User enter "<Units>" in "dosesOrUnit"
  	And     User enter random text in "comment"
  	Then    User click on "Save" button
  	Then    Issuing line is created successfully
  	And     Issuing line Data is visible in issuing line table to user
  	When    User click on "Save as draft and go back" button
  	And     User wait for "10" seconds
  	And     Validate issuing state is "Draft"
  	And     User edit the Issuing data
		When    User delete the line in issuing
    And     User click on "Yes" button
    Then    Issuing line is deleted successfully
    And     Issuing line Data is not visible in issuing line table to user
    When    User click on "Save as draft and go back" button
    And     User wait for "10" seconds
  	When    User delete the Issuing data
    And     User click on "Yes" button
    Then    Issuing data is deleted successfully
    And     Issuing Data is not visible in issuing table to user
  	Examples:
  
      | Issue Type  | Recipient Store | Distributed Option | Product Type | Product | Batch Number | Units |
      | Requisition | Dubai 2         | No                 | Vaccine      | YF      | 200A         | 1     | 