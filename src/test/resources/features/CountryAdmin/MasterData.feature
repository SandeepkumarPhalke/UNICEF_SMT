Feature: Master Data tab in SMT application for Country Admin user
  We will be using this feature file for Master Data functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

  Background: User login to SMT application and navigate to Master Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Country Admin"
   	And   User select "Country Admin" from "Role" in "Welcome" tab
   	And   User click on "Apply" button
   	And   User click on "Master Data" tab
   	And   User wait for "2" seconds
   	
  Scenario Outline: Verify user is able to add Country Specific Vaccine
  	Given User click on "Vaccines" tab
		And   User click on "Add" button
		And   "Add new vaccine" heading is visible
		And   User enter random text in "name"
		And   User enter random text in "english_txt"
		And   User enter random text in "french_txt"
		And   User select "<Product Type>" from "Product Type" in "Master Data" tab
		And   User select "<Producer>" from "Producer" in "Master Data" tab
		And   User enter "Automation Testing" in "commercialName"
		And   User select "<Formulation>" from "Formulation" in "Master Data" tab
		And   User select "<Presentation Mode>" from "Presentation Mode" in "Master Data" tab
		And   User select "<Administration Mode>" from "Administration Mode" in "Master Data" tab
		And   User enter "<Presentation>" in "presentation"
		And   User select "<VVM Type>" from "VVM Type Id" in "Master Data" tab
		And   User enter "<Price/Vial($)>" in "priceVial"
		And   User enter "<Price/Dose($)>" in "priceDose"
		And   User enter "Automation Testing" in "comment"
  	When  User click on "Save" button
  	Then  Country specific vaccine data is created successfully
  	And   User wait for "15" seconds
  	And   Country specific vaccine with producer "<Producer>" is visible in country specific vaccination table to user
  	Examples:
      | Product Type | Producer                                                              | Formulation                                | Presentation Mode | Administration Mode | Presentation | VVM Type | Price/Vial($) | Price/Dose($) | 
      | Vaccine      | Sinopharm Beijing Bio Institute of Biological Products - Revitalhcare | Frozen liquid, to be diluted after thawing | Vial + Ampoule    | IM                  | 10           | VVM-14   | 100           | 150           |
      
  Scenario Outline: Verify user is able to edit Country Specific Vaccine
  	Given User click on "Vaccines" tab
		And   User click on "Edit country specific vaccine" button for "Master Data"
		And   "Edit vaccine" heading is visible
		And   User enter random text in "name"
		And   User enter random text in "english_txt"
		And   User enter random text in "french_txt"
		And   User select "<Product Type>" from "Product Type" in "Master Data" tab
		And   User select "<Producer>" from "Producer" in "Master Data" tab
		And   User enter "Automation Testing" in "commercialName"
		And   User select "<Formulation>" from "Formulation" in "Master Data" tab
		And   User select "<Presentation Mode>" from "Presentation Mode" in "Master Data" tab
		And   User select "<Administration Mode>" from "Administration Mode" in "Master Data" tab
		And   User enter "<Presentation>" in "presentation"
		And   User select "<VVM Type>" from "VVM Type Id" in "Master Data" tab
		And   User enter "Diluent Packed Vol(cm3/dose)" in "diluentPackedVol"
		And   User enter "<Price/Vial($)>" in "priceVial"
		And   User enter "<Price/Dose($)>" in "priceDose"
		And   User enter "Automation Testing" in "comment"
  	When  User click on "Update" button
  	Then  Country specific vaccine data is updated successfully
  	And   User wait for "15" seconds
  	And   Country specific vaccine with producer "<Producer>" is visible in country specific vaccination table to user
  	Examples:
      | Product Type | Producer            | Formulation          | Presentation Mode | Administration Mode | Presentation | VVM Type | Diluent Packed Vol(cm3/dose) | Price/Vial($) | Price/Dose($) | 
      | Diluent      | MK Limited - Terumo | Liquid: ready to use | Plastic Tube      | Intradermal         | 20           | VVM-11   | 10                           | 150           | 200           |
     
  Scenario: Verify user is able to delete Country Specific Vaccine
  	Given User click on "Vaccines" tab
		And   User click on "Delete country specific vaccine" button for "Master Data"
		When  User click on "Yes" button
    Then  Country specific vaccine data is deleted successfully
     
  Scenario Outline: Verify user is able to add Country Specific Supplies
  	Given User click on "Supplies" tab
		And   User click on "Add" button
		And   "Add new supply" heading is visible
		And   User enter random text in "name"
		And   User enter random text in "english_txt"
		And   User enter random text in "french_txt"
		And   User select "<Product Type>" from "Product Type" in "Master Data" tab 
		And   User enter "<Presentation>" in "presentation"
		And   User enter "<Packed Vol>" in "packedVol"
		And   User enter "<Packed Weight>" in "packedWeight"
		And   User enter "<Price Per Unit>" in "pricePerUnit"
		And   User enter "<Fright Percentage>" in "frightPercentage"
  	When  User click on "Save" button
  	Then  Country specific supply data is created successfully
  	And   User wait for "10" seconds
  	And   Country specific supply with product type "<Product Type>" is visible in country specific supplies table to user
  	Examples:
      | Product Type | Presentation | Packed Vol | Packed Weight | Price Per Unit | Fright Percentage | 
      | ITN / Bednet | 10           | 20         | 30            | 40             | 50                |
      
  Scenario Outline: Verify user is able to edit Country Specific Supplies
  	Given User click on "Supplies" tab
		And   User click on "Edit country specific supplies" button for "Master Data"
		And   "Edit supplies" heading is visible
		And   User enter random text in "name"
		And   User enter random text in "english_txt"
		And   User enter random text in "french_txt"
		And   User select "<Product Type>" from "Product Type" in "Master Data" tab 
		And   User enter "<Presentation>" in "presentation"
		And   User enter "<Packed Vol>" in "packedVol"
		And   User enter "<Packed Weight>" in "packedWeight"
		And   User enter "<Price Per Unit>" in "pricePerUnit"
		And   User enter "<Fright Percentage>" in "frightPercentage"
  	When  User click on "Update" button
  	Then  Country specific supply data is updated successfully
  	And   User wait for "10" seconds
  	And   Country specific supply with product type "<Product Type>" is visible in country specific supplies table to user
  	Examples:
      | Product Type        | Presentation | Packed Vol | Packed Weight | Price Per Unit | Fright Percentage | 
      | Vitamin & Deworming | 20           | 30         | 40            | 50             | 100               |
    
  Scenario: Verify user is able to delete Country Specific Supplies
  	Given User click on "Supplies" tab
		And   User click on "Delete country specific supplies" button for "Master Data"
		When  User click on "Yes" button
    Then  Country specific supply data is deleted successfully
    
  Scenario Outline: Verify user is able to add Country Specific Producers
  	Given User click on "Producers" tab
		And   User click on "Add" button
		And   "Add new Producer" heading is visible
		And   User enter random text in "name"
		And   User select "<Producer Type>" from "Producer Type" in "Master Data" tab
		And   User select "<Country>" from "Country" in "Master Data" tab
		And   User enter "Automation Testing" in "initials"
  	When  User click on "Save" button
  	Then  Country specific producers data is created successfully
  	And   User wait for "10" seconds
  	And   Country specific producer with producer type "<Producer Type>" is visible in country specific producer table to user
  	Examples:
      | Producer Type   | Country |
      | Others Supplies | India   |
      
  Scenario Outline: Verify user is able to edit Country Specific Producers
  	Given User click on "Producers" tab
		And   User click on "Edit country specific producer" button for "Master Data"
		And   "Edit Producer" heading is visible
		And   User enter random text in "name"
		And   User select "<Producer Type>" from "Producer Type" in "Master Data" tab
		And   User select "<Country>" from "Country" in "Master Data" tab
		And   User enter "Automation Testing" in "initials"
  	When  User click on "Update" button
  	Then  Country specific producers data is updated successfully
  	And   User wait for "10" seconds
  	And   Country specific producer with producer type "<Producer Type>" is visible in country specific producer table to user
  	Examples:
      | Producer Type   | Country   |
      | Vaccines        | Argentina |
      
  Scenario: Verify user is able to delete Country Specific Producers
  	Given User click on "Producers" tab
		And   User click on "Delete country specific producer" button for "Master Data"
		When  User click on "Yes" button
    Then  Country specific producers data is deleted successfully
      
  Scenario Outline: Verify user is able to add Country Specific Equipment
  	Given User click on "CCE Equipment" tab
		And   User click on "Add" button
		And   "Add new Equipment" heading is visible
		And   User select "<Equipment Category>" from "Equipment Category" in "Master Data" tab
  	And   User select "<Supplier>" from "Supplier" in "Master Data" tab
  	And   User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Master Data" tab
  	And   User select "<Storage Temperature>" from "Storage Temperature" in "Master Data" tab
  	And   User enter "<Gross Capacity>" in "grossCapacity"
  	And   User enter "<Net Capacity>" in "netCapacity"
  	When  User click on "Save" button
  	Then  Country specific equipment data is created successfully
  	And   User wait for "15" seconds
  	And   Country specific equipment with equipment category "<Equipment Category>" is visible in country specific equipment table to user
  	Examples:
      | Equipment Category | Supplier       | Equipment Type/Model | Storage Temperature | Gross Capacity | Net Capacity |
      | Freezer            | Aucma Co. Ltd. | CFD-50               | +5C Capacity        | 10             | 20           |
   
  Scenario Outline: Verify user is able to edit Country Specific Equipment
  	Given User click on "CCE Equipment" tab
		And   User click on "Edit country specific equipment" button for "Master Data"
		And   "Edit Equipment" heading is visible
		And   User select "<Equipment Category>" from "Equipment Category" in "Master Data" tab
  	And   User select "<Supplier>" from "Supplier" in "Master Data" tab
  	And   User select "<Equipment Type/Model>" from "Equipment Type/Model" in "Master Data" tab
  	And   User select "<Storage Temperature>" from "Storage Temperature" in "Master Data" tab
  	And   User enter "<Gross Capacity>" in "grossCapacity"
  	And   User enter "<Net Capacity>" in "netCapacity"
  	When  User click on "Update" button
  	Then  Country specific equipment data is updated successfully
  	And   User wait for "15" seconds
  	And   Country specific equipment with equipment category "<Equipment Category>" is visible in country specific equipment table to user
  	Examples:
      | Equipment Category | Supplier | Equipment Type/Model | Storage Temperature | Gross Capacity | Net Capacity |
      | Refrigerator       | Haier    | New Model            | -20C Capacity       | 20             | 30           |
   
  Scenario Outline: Verify user is able to delete Country Specific Equipment
  	Given User click on "CCE Equipment" tab
		And   User click on "Delete country specific equipment" button for "Master Data"
		When  User click on "Yes" button
    Then  Country specific equipment data is deleted successfully
    
 Scenario: Verify user is able to add Country Specific Target Group
  	Given User click on "Master List" tab
		And   User click on "Edit target groups" button for "Master Data"
		And   User click on "Add target group" button for "Master Data"
#		And   "Add New" heading is visible
		And   User enter random text in "english_text"
		And   User enter random text in "french_text"
		When  User click on "Save" button
  	Then  Country specific target group is created successfully
  	And   User wait for "10" seconds
  	And   Country specific target group with english name is visible in country specific target group table to user
  	
 Scenario: Verify user is able to edit Country Specific Target Group
  	Given User click on "Master List" tab
		And   User click on "Edit target groups" button for "Master Data"
		And   User click on "Edit target group" button for "Master Data"
#		And   "Add New" heading is visible
		And   User enter random text in "english_text"
		And   User enter random text in "french_text"
		When  User click on "Save" button
  	Then  Country specific target group is updated successfully
  	And   User wait for "10" seconds
  	And   Country specific target group with english name is visible in country specific target group table to user
  	
 Scenario: Verify user is able to delete Country Specific Target Group
  	Given User click on "Master List" tab
  	And   User click on "Edit target groups" button for "Master Data"
		And   User click on "Delete target group" button for "Master Data"
		When  User click on "Yes" button
  	Then  Country specific target group is deleted successfully
  	And   Country specific target group with english name is not visible in country specific target group table to user
  
  Scenario Outline: Verify user is not able to delete Country Specific Target Group already in use
  	Given User click on "Master List" tab
		And   User click on "Edit target groups" button for "Master Data"
		And   User wait for "2" seconds
		And   User click on "Add target group" button for "Master Data"
		And   User move mouse
#		And   "Add New" heading is visible
		And   User enter random text in "english_text"
		And   User enter random text in "french_text"
		When  User click on "Save" button
  	Then  Country specific target group is created successfully
  	And   User wait for "10" seconds
  	And   Country specific target group with english name is visible in country specific target group table to user
  	And   User click on "Programme Data" tab
   	And   User wait for "2" seconds
  	When  User click on "Add Routine Vaccine" button for "Programme Data"
  	Then  "Add new routine vaccination" heading is visible
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
  	And   User click on "Master Data" tab
   	And   User wait for "2" seconds
  	And   User click on "Master List" tab
  	And   User click on "Edit target groups" button for "Master Data"
		And   User click on "Delete target group" button for "Master Data"
		When  User click on "Yes" button
  	Then  Country specific target group is not deleted successfully
  	And   User click on "Programme Data" tab
   	And   User wait for "2" seconds
  	And   User click on "Delete Routine Vaccine" button for "Programme Data"
  	When  User click on "Yes" button
    Then  Routine Vaccine Data is deleted successfully
    And   User click on "Master Data" tab
   	And   User wait for "2" seconds
   	And   User click on "Master List" tab
    And   User click on "Edit target groups" button for "Master Data"
		And   User click on "Delete used target group" button for "Master Data"
		When  User click on "Yes" button
  	Then  Country specific target group is deleted successfully
  	And   Country specific used target group with english name is not visible in country specific target group table to user
  	Examples:
      | Vaccine Name | Producer                       | Formulation          | Doses/Target | Target Groups       | Coverage Expected% | Presentation | Wastage Rates(%) | Administration Type | Dilution-Syringes | 
      | bOPV         | Sinovac Life Sciences Co. Ltd. | Liquid: ready to use | 10           | Newly Created Value | 80                 | 20           | 10               | ADS_0.05ml          | ADS_0.1ml         |
      