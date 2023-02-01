Feature: Reports tab in SMT application for Store Operator user
  We will be using this feature file for Reports functionality validations in SMT application mentioning all possible scenarios for Store Operator user.

  Background: User login to SMT application and navigate to Reports tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	And   User select "Store Operator" from "Role" in "Welcome" tab
   	And   User click on "Apply" button
   	And   User click on "Reports" tab
   	And   User wait for "20" seconds
   	
  	Scenario Outline: Verify user is able to download all excel report
			Given User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
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
  	  And   User wait for "2" seconds
  	  
  	  Given User click on "Cold Chain Equipment" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Cold Chain Equipment"
  	  
  		Examples:
      | Store  | Start Date | Level  | Store  | Product Category | Storage Temperature | Start Month |
      | UAE L2 | 01-01-2022 | Level2 | UAE L2 | Vaccine Routine  | +5C Capacity        | 08-2022     |
      
   	Scenario Outline: Verify user is able to download all excel report including sub store
  	  Given User click on "Stock Management Summary" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
			Then  User click on includeSubStore checkbox
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Stock Management Summary" with Sub Store
  	  
  	  Given User click on "Stock Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User type and select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Stock Status" with Sub Store
  	  
  	  Given User click on "Storage Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User type and select "<Storage Temperature>" from "Storage Temperature" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  #	  And   User click on Export Report button
  #	  And   User click on Export Excel button
  #	  And   User wait for "10" seconds
  #	  And   User press escape button on keyboard
  #	  And   User wait for "2" seconds
  #	  Then  User validate UI and "Excel" data for "Storage Status" with Sub Store
  	  
  	  Given User click on "Supply Adequacy" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "10" seconds
  	  And   User wait for "2" seconds
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  #	  Then  User validate UI and "Excel" data for "Supply Adequacy" with Sub Store
  	  
  	  Given User click on "Cold Chain Equipment" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export Excel button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "Excel" data for "Cold Chain Equipment" with Sub Store
  	  
  		Examples:
      | Store  | Start Date | Level  | Store  | Product Category | Storage Temperature | Start Month |
      | UAE L2 | 01-01-2022 | Level2 | UAE L2 | Vaccine Routine  | +5C Capacity        | 08-2022     |
      
  	Scenario Outline: Verify user is able to download all pdf report including sub store
  	  Given User click on "Stock Management Summary" tab
			And   User type and select "<Store>" from "Store" in "Reports" tab
			And   User wait for "2" seconds
			Then  User click on includeSubStore checkbox
  	  When  User enter "<Start Date>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Stock Management Summary" with Sub Store
  	  
  	  Given User click on "Stock Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User type and select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Stock Status" with Sub Store
  	  
  	  Given User click on "Storage Status" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User type and select "<Storage Temperature>" from "Storage Temperature" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  #	  And   User click on Export Report button
  #	  And   User click on Export PDF button
  #	  And   User wait for "10" seconds
  #	  And   User press escape button on keyboard
  #	  And   User wait for "2" seconds
  #	  Then  User validate UI and "PDF" data for "Storage Status" with Sub Store
 
  	  Given User click on "iSC Performance" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			When  User enter "<Start Month>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "5" seconds
  	  And   User click on "Stocked According to Plan" button
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with Sub Store
  
  	  Given User click on "Supply Adequacy" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			And   User select "<Product Category>" from "Product Category" in "Reports" tab
  	  And   User click on "Generate Report" button
  	  And   User wait for "10" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Supply Adequacy" with Sub Store
  	  
  	  Given User click on "Cold Chain Equipment" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User wait for "10" seconds
  	  And   User press escape button on keyboard
  	  And   User wait for "2" seconds
  	  Then  User validate UI and "PDF" data for "Cold Chain Equipment" with Sub Store
  	  
  		Examples:
      | Store  | Start Date | Level  | Store  | Product Category | Storage Temperature | Start Month |
      | UAE L2 | 01-01-2022 | Level2 | UAE L2 | Vaccine Routine  | +5C Capacity        | 08-2022     |
      
      
  	Scenario Outline: Verify user is able to download all pdf report including sub store for iSC Performance tab
  		Given User click on "iSC Performance" tab
			And   User select "<Level>" from "Level" in "Reports" tab
			And   User select "<Store>" from "Store" in "Reports" tab
			Then  User click on includeSubStore checkbox
			When  User enter "<Start Month>" in "startDate"
  	  And   User click on "Generate Report" button
  	  And   User wait for "3" seconds
  	  And   User click on "Temperature" button
  	  And   User wait for "5" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with "Temperature"
  	  And   User click on "Temperature" button
  	  
  	  And   User click on "CCE Functionality" button
  	  And   User wait for "5" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with "CCE Functionality"
  	  And   User click on "CCE Functionality" button
  	  
  	  And   User click on "Wastage" button
  	  And   User wait for "5" seconds
  #	  Then  Reports Data is visible in table to user
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with "Wastage"
  	  And   User click on "Wastage" button
  	  
  	  And   User click on "Full Stock Availibility" button
  	  And   User wait for "5" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with "Full Stock Availability"
  	  And   User click on "Full Stock Availibility" button
  	  
  #	  And   User click on "Stock Out Days" button
  #		And   User wait for "5" seconds
  #	  And   User click on Export Report button
  #	  And   User click on Export PDF button
  #	  And   User press escape button on keyboard
  #	  And   User wait for "10" seconds
  #	  Then  User validate UI and "PDF" data for "iSC Performance" with "Stock Out Days"
  #	  And   User click on "Stock Out Days" button
  	  
  	  And   User click on "Stocked According to Plan" button
  	  And   User wait for "5" seconds
  	  And   User click on Export Report button
  	  And   User click on Export PDF button
  	  And   User press escape button on keyboard
  	  And   User wait for "10" seconds
  	  Then  User validate UI and "PDF" data for "iSC Performance" with "Stocked According to Plan"
  	  And   User click on "Stocked According to Plan" button
  	  
  #	  And   User click on "Forecasted Demand Vs Issues" button
  #		And   User wait for "5" seconds
  #	  And   User click on Export Report button
  #	  And   User click on Export PDF button
  #	  And   User press escape button on keyboard
  #	  And   User wait for "10" seconds
  #	  Then  User validate UI and "PDF" data for "iSC Performance" with "Forecasted Demand Vs Issues"
  #	  And   User click on "Forecasted Demand Vs Issues" button
  	  
  	  Examples:
      | Store  | Level  | Start Month |
      | UAE L2 | Level2 | 08-2022     |