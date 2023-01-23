Feature: Reports tab in SMT application for Store Operator user
  We will be using this feature file for Reports functionality validations in SMT application mentioning all possible scenarios for Store Operator user.

  Background: User login to SMT application and navigate to Reports tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	And   User click on "Apply" button
   	And   User click on "Reports" tab
   	And   User wait for "20" seconds
   	
  	Scenario Outline: Verify user is able to download all excel report
			Given User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Arrivals"
  	  
  	  Given User click on "Issues" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Issues"
  	  
  	  Given User click on "Physical Count & Adjustment" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Physical Count & Adjustment"
  	  
  	  Given User click on "Stock Management Summary" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Stock Management Summary"
  	  
  	  Given User click on "Stock Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			And   User type and select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Stock Status"
  	  
  	  Given User click on "Storage Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			And   User type and select "<Storage Temperature>" from "Storage Temperature" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  #	  Then  Reports Data is visible in table to user
  #	  And   User click on Export Report button
  #	  And   User click on Export Excel button
  #	  And   User wait for "10" seconds
  #	  And   User press escape button on keyboard
  #	  And   User wait for "2" seconds
  #	  Then  User validate UI and "Excel" data for "Storage Status"
  	  
  	  Given User click on "Cold Chain Equipment" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Cold Chain Equipment"
  	  
  		Examples:
      | Store  | Start Date | Level  | Store  | Product Category | Storage Temperature | Start Month |
      | UAE L2 | 01-01-2022 | Level2 | UAE L2 | Vaccine Routine  | +5C Capacity        | 08-2022     |
      
   Scenario Outline: Verify user is able to download all pdf report
			Given User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Arrivals"
  	  
  	  Given User click on "Issues" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Issues"
  	  
  	  Given User click on "Physical Count & Adjustment" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Physical Count & Adjustment"
  	  
  	  Given User click on "Stock Management Summary" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Stock Management Summary"
  	  
  	  Given User click on "Stock Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			And   User type and select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Stock Status"
  	  
  	  Given User click on "Storage Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			And   User type and select "<Storage Temperature>" from "Storage Temperature" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  #	  Then  Reports Data is visible in table to user
  #	  And   User click on Export Report button
  #	  And   User click on Export PDF button
  #	  And   User wait for "10" seconds
  #	  And   User press escape button on keyboard
  #	  And   User wait for "2" seconds
  #	  Then  User validate UI and "PDF" data for "Storage Status"
 
  	  Given User click on "iSC Performance" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			When  User enter "<Start Month>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on "Stocked According to Plan" button
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance"
  
  	  Given User click on "Supply Adequacy" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			And   User select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "10" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User wait for "2" seconds
  	  
  	  Given User click on "Cold Chain Equipment" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Cold Chain Equipment"
  	  
  		Examples:
      | Store  | Start Date | Level  | Store  | Product Category | Storage Temperature | Start Month |
      | UAE L2 | 01-01-2022 | Level2 | UAE L2 | Vaccine Routine  | +5C Capacity        | 08-2022     |
  