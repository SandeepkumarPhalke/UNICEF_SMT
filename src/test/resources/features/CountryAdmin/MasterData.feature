Feature: Master Data tab in SMT application for Country Admin user
  We will be using this feature file for Master Data functionality validations in SMT application mentioning all possible scenarios for Country Admin user.

  Background: User login to SMT application and navigate to Store Data tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Country Admin"
   	And   User select "Country Admin" from "Role" in "Welcome" tab
   	And   User click on "Apply" button
   	And   User click on "Master Data" tab
   	And   User wait for "2" seconds
   	
  Scenario Outline: Verify user is able to add Routine Vaccine
  	Given User click on "Vaccines" button
		And   User click on "Add" button
		And   User enter random text in "name"
		And   User enter "Automation Testing" in "english_txt"
		And   User enter "Automation Testing" in "french_txt"
		And   User select "<Product Type>" from "productType" in "Master Data" tab
		And   User select "<Producer>" from "producer" in "Master Data" tab
		And   User enter "Automation Testing" in "commercialName"
		And   User select "<Formulation>" from "formulation" in "Master Data" tab
		And   User select "<Presentation Mode>" from "presentationMode" in "Master Data" tab
		And   User select "<Administration Mode>" from "administrationMode" in "Master Data" tab
		And   User enter "<Presentation>" in "presentation"
		And   User select "<VVM Type>" from "vvmTypeId" in "Master Data" tab
		And   User enter "<Price/Vial($)>" in "priceVial"
		And   User enter "<Price/Dose($)>" in "priceDose"
		And   User enter "Automation Testing" in "comment"
  	When  User click on "Save" button
  	Then  Country specific Vaccine Data is created successfully
  	And   User wait for "10" seconds
  	And   Country specific Vaccine is visible in Country specific Vaccination table to user
  	Examples:
      | Product Type | Producer                                                              | Formulation                                | Presentation Mode | Administration Mode | Presentation | VVM Type | Price/Vial($) | Price/Dose($) | 
      | Vaccine      | Sinopharm Beijing Bio Institute of Biological Products - Revitalhcare | Frozen liquid, to be diluted after thawing | Vial + Ampoule    | IM                  | 10           | VVM-14   | 100           | 150           |
      
  
      
   