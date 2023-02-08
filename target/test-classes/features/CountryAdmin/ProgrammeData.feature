Feature: Programme Data tab in SMT application for Country Admin user
  We will be using this feature file for Programme Data functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

  Background: User login to SMT application and navigate to Programme Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Country Admin"
   	And   User select "Country Admin" from "Role" in "Settings" page
   	And   User click on "Apply" button
   	And   User click on "Programme Data" tab
   	And   User wait for "2" seconds
   	
  Scenario Outline: Verify user is able to add Routine Vaccine
  	Given User click on "Add Routine Vaccine" button for "Programme Data"
  	And   "Add new routine vaccination" heading is visible
  	And   User select "<Vaccine Name>" from "Vaccine Name" in "Programme Data" tab
  	And   User select "<Producer>" from "Producer" in "Programme Data" tab
  	And   User select "<Formulation>" from "Formulation" in "Programme Data" tab
  	And   User enter "<Doses/Target>" in "dosesTarget"
  	And   User select "<Target Groups>" from "Target Groups" in "Programme Data" tab
  	And   User enter "<Coverage Expected%>" in "coverageExpected"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates(%)>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	And   User select "<Dilution-Syringes>" from "Dilution-Syringes" in "Programme Data" tab
  	When  User click on "Save" button
  	Then  Routine Vaccine Data is created successfully
  	And   User wait for "10" seconds
  	And   Routine Vaccine producer "<Producer>" is visible in Routine Vaccination table to user
  	Examples:
      | Vaccine Name | Producer                       | Formulation          | Doses/Target | Target Groups    | Coverage Expected% | Presentation | Wastage Rates(%) | Administration Type | Dilution-Syringes | 
      | bOPV         | Sinovac Life Sciences Co. Ltd. | Liquid: ready to use | 10           | Adolescent Girls | 80                 | 20           | 10               | ADS_0.05ml          | ADS_0.1ml         |
      
  Scenario Outline: Verify user is able to update Routine Vaccine
  	Given User click on "Edit Routine Vaccine" button for "Programme Data"
  	And   "Edit routine vaccination" heading is visible
  	And   User select "<Vaccine Name>" from "Vaccine Name" in "Programme Data" tab
  	And   User select "<Producer>" from "Producer" in "Programme Data" tab
  	And   User select "<Formulation>" from "Formulation" in "Programme Data" tab
  	And   User enter "<Doses/Target>" in "dosesTarget"
  	And   User select "<Target Groups>" from "Target Groups" in "Programme Data" tab
  	And   User enter "<Coverage Expected%>" in "coverageExpected"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates(%)>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	And   User select "<Dilution-Syringes>" from "Dilution-Syringes" in "Programme Data" tab
  	When  User click on "Update" button
  	Then  Routine Vaccine Data is updated successfully
  	And   User wait for "10" seconds
  	And   Routine Vaccine producer "<Producer>" is visible in Routine Vaccination table to user
  	Examples:
      | Vaccine Name | Producer             | Formulation                                        | Doses/Target | Target Groups | Coverage Expected% | Presentation | Wastage Rates(%) | Administration Type | Dilution-Syringes | 
      | BCG          | PT.Tonnindo Eramulya | Lyophilised : reconstituted with excipient diluent | 20           | Live Births   | 70                 | 10           | 20               | ADS_0.5ml           | ADS_0.5ml         |
      
  Scenario: Verify user is able to delete Routine Vaccine
  	Given User click on "Delete Routine Vaccine" button for "Programme Data"
  	When  User click on "Yes" button
    Then  Routine Vaccine Data is deleted successfully  
  
  Scenario Outline: Verify user is able to add Supplementary Vaccine
  	Given User click on "Add Supplementary Vaccine" button for "Programme Data"
  	And   "Add new supplementary vaccination" heading is visible
  	And   User select "<Vaccine Name>" from "Vaccine Name" in "Programme Data" tab
  	And   User select "<Producer>" from "Producer" in "Programme Data" tab
  	And   User select "<Formulation>" from "Formulation" in "Programme Data" tab
  	And   User enter "<No. Of Rounds>" in "noOfRounds"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates(%)>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	And   User select "<Dilution-Syringes>" from "Dilution-Syringes" in "Programme Data" tab
  	When  User click on "Save" button
  	Then  Supplementary Vaccine Data is created successfully
  	And   User wait for "10" seconds
  	And   Supplementary Vaccine producer "<Producer>" is visible in Supplementary Vaccination table to user
  	Examples:
      | Vaccine Name | Producer                       | Formulation          | No. Of Rounds | Presentation | Wastage Rates(%) | Administration Type | Dilution-Syringes | 
      | bOPV         | Sinovac Life Sciences Co. Ltd. | Liquid: ready to use | 10            | 20           | 10               | ADS_0.05ml          | ADS_0.1ml         |
      
  Scenario Outline: Verify user is able to update Supplementary Vaccine
  	Given User click on "Edit Supplementary Vaccine" button for "Programme Data"
  	And   "Edit supplementary vaccination" heading is visible
  	And   User select "<Vaccine Name>" from "Vaccine Name" in "Programme Data" tab
  	And   User select "<Producer>" from "Producer" in "Programme Data" tab
  	And   User select "<Formulation>" from "Formulation" in "Programme Data" tab
  	And   User enter "<No. Of Rounds>" in "noOfRounds"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates(%)>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	And   User select "<Dilution-Syringes>" from "Dilution-Syringes" in "Programme Data" tab
  	When  User click on "Update" button
  	Then  Supplementary Vaccine Data is updated successfully
  	And   User wait for "10" seconds
  	And   Supplementary Vaccine producer "<Producer>" is visible in Supplementary Vaccination table to user
  	Examples:
      | Vaccine Name | Producer              | Formulation                                        | No. Of Rounds | Presentation | Wastage Rates(%) | Administration Type | Dilution-Syringes | 
      | BCG          | PT.Tonnindo Eramulya  | Lyophilised : reconstituted with excipient diluent | 20            | 10           | 20               | ADS_0.1ml           | ADS_0.3ml         |
      
  Scenario: Verify user is able to delete Supplementary Vaccine
  	Given User click on "Delete Supplementary Vaccine" button for "Programme Data"
  	When  User click on "Yes" button
    Then  Supplementary Vaccine Data is deleted successfully   
      
  Scenario Outline: Verify user is able to add child survival intervention
  	Given User click on "Add child survival intervention" button for "Programme Data"
  	And   "Add new other child survival intervention" heading is visible
  	And   User select "<Product Name>" from "Product Name" in "Programme Data" tab
  	And   User enter "<Units/Target>" in "unitsPerTarget"
  	And   User enter "<Target Groups%>" in "targetGroupPercentage"
  	And   User enter "<Coverage Expected%>" in "coverageExpected"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates%>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	When  User click on "Save" button
  	Then  Child survival intervention Data is created successfully
  	And   User wait for "10" seconds
  	And   Child survival intervention product name "<Product Name>" is visible in child survival intervention table to user
  	Examples:
      | Product Name      | Units/Target | Target Groups% | Coverage Expected% | Presentation | Wastage Rates% | Administration Type |
      | Albendazole_200mg | 100          | 10             | 80                 | 200          | 10             | ADS_0.05ml          |
      
  Scenario Outline: Verify user is able to update child survival intervention
  	Given User click on "Edit child survival intervention" button for "Programme Data"
  	And   "Edit other child survival intervention" heading is visible
  	And   User select "<Product Name>" from "Product Name" in "Programme Data" tab
  	And   User enter "<Units/Target>" in "unitsPerTarget"
  	And   User enter "<Target Groups%>" in "targetGroupPercentage"
  	And   User enter "<Coverage Expected%>" in "coverageExpected"
  	And   User select "<Presentation>" from "Presentation" in "Programme Data" tab
  	And   User enter "<Wastage Rates%>" in "wastageRates"
  	And   User select "<Administration Type>" from "Administration Type" in "Programme Data" tab
  	When  User click on "Update" button
  	Then  Child survival intervention Data is updated successfully
  	And   User wait for "10" seconds
  	And   Child survival intervention product name "<Product Name>" is visible in child survival intervention table to user
  	Examples:
      | Product Name      | Units/Target | Target Groups% | Coverage Expected% | Presentation | Wastage Rates% | Administration Type |
      | Albendazole_400mg | 50           | 20             | 70                 | 400          | 20             | ADS_0.1ml           |
      
  Scenario: Verify user is able to delete child survival intervention
  	Given User click on "Delete child survival intervention" button for "Programme Data"
  	When  User click on "Yes" button
    Then  Child survival intervention Data is deleted successfully
   