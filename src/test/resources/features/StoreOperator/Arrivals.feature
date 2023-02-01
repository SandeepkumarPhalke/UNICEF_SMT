Feature: Arrivals tab in SMT application for Store Operator user
  We will be using this feature file for Arrivals functionality validations in SMT application mentioning all possible scenarios for Store Operator user.

  Background: User login to SMT application and navigate to Arrivals tab
 	 	Given User is on home page of SMT application
   	And   User is able to see login button on home page
   	When  User click on login button
   	And   User click on Proceed To Login button in "English"
   	Then  User login as "Store Operator"
   	And   User select "Store Operator" from "Role" in "Welcome" tab
   	And   User click on "Apply" button
   	And   User click on "Arrivals" tab
   	And   User wait for "2" seconds
   	
  	Scenario Outline: Verify user is able to add arrival line and arrival receipt type data and finalize it
			Given User click on "Log New Arrival" button
  		Then  "Stock Arrival" text is visible
  	  And   User select "<Receipt Type>" from "Receipt Type" in "Arrivals" tab
  	  And   User enter random text in "smtNumber"
  	  And   User enter random number in "shippingReferance"
  	  And   User enter random text in "fundingSource"
  	  And   User select "<Currency>" from "Currency" in "Arrivals" tab
  	  And   User enter random number in "freightCost"
  		When  User click on "Add Line to Arrival" button
  		Then  "Add Product to Arrival" heading is visible
  	  And   User select "<Product Type>" from "Product Type" in "Arrivals" tab
  	  And   User select "<Product>" from "Product" in "Arrivals" tab
  	  And   User enter random text in "batchNo"
  	  And   User select "<Producer>" from "Producer" in "Arrivals" tab
  	  And   User select "<Commercial Name>" from "Commercial Name" in "Arrivals" tab
  	  And   User select "<Formulation>" from "Formulation" in "Arrivals" tab
  	  And   User select "<Presentation>" from "Presentation" in "Arrivals" tab
  	  And   User select "<VVM Stage>" from "VVM Stage" in "Arrivals" tab
  	  And   User enter "<Units>" in "units"
  	  And   User select "<Routine or SIA>" from "Routine or SIA" in "Arrivals" tab
  	  And   User select "<Origin>" from "Origin" in "Arrivals" tab
  	  And   User select "<Shipping/Freeze Indicator>" from "Shipping/Freeze Indicator" in "Arrivals" tab
  	  And   User enter "<No Of Vials>" in "noOfVials"
  	  And   User enter "<Volume>" in "totalVolume"
  	  And   User select "<Storage Location>" from "Storage Location" in "Arrivals" tab
  	  And   User enter "<Total Cost>" in "totalCost"
  	  And   User enter random text in "comments"
  		And   User click on "Create" button
  	  When  User click on "Continue" button
  		Then  Arrivals line is created successfully
  	  And   Arrivals line Data is visible in arrival line table to user
  		When  User click on "Finalize" button
  	  And   User click on "Continue" button
  	  And   User wait for "3" seconds
  	  Then  Arrivals Data is visible in arrivals table to user
  	  And   Validate arrival state is "Complete"
  		Examples:
      | Receipt Type | Currency | Product Type | Product     | Producer                       | Commercial Name | Formulation          | Presentation | VVM Stage       | Routine or SIA | Origin    | Shipping/Freeze Indicator | Storage Location | Units | No Of Vials | Volume | Total Cost |
      | Arrival      | AUD      | Vaccine      | bOPV        | PT ONEJECT INDONESIA           | BIOPOLIO B1/3   | Liquid: ready to use | 10           | 1.Initial stage | Routine        | Indonesia | Alarm                     | Ambient_2022     | 20    | 20          | 20     | 1000       |      
      
   Scenario Outline: Verify user is able to update arrival line and arrival receipt type data before finalizing
   		Given User click on "Log New Arrival" button
  	  Then  "Stock Arrival" text is visible
  	  And   User select "<Receipt Type>" from "Receipt Type" in "Arrivals" tab
  	  And   User enter random text in "smtNumber"
  	  And   User enter random number in "shippingReferance"
  	  And   User enter random text in "fundingSource"
  	  And   User select "<Currency>" from "Currency" in "Arrivals" tab
  	  And   User enter random number in "freightCost"
  		When  User click on "Add Line to Arrival" button
  		Then  "Add Product to Arrival" heading is visible
  	  And   User select "<Product Type>" from "Product Type" in "Arrivals" tab
  	  And   User select "<Product>" from "Product" in "Arrivals" tab
  	  And   User enter random text in "batchNo"
  	  And   User select "<Producer>" from "Producer" in "Arrivals" tab
  	  And   User select "<Commercial Name>" from "Commercial Name" in "Arrivals" tab
  	  And   User select "<Formulation>" from "Formulation" in "Arrivals" tab
  	  And   User select "<Presentation>" from "Presentation" in "Arrivals" tab
  	  And   User select "<VVM Stage>" from "VVM Stage" in "Arrivals" tab
  	  And   User enter "<Units>" in "units"
  	  And   User select "<Routine or SIA>" from "Routine or SIA" in "Arrivals" tab
  	  And   User select "<Origin>" from "Origin" in "Arrivals" tab
  	  And   User select "<Shipping/Freeze Indicator>" from "Shipping/Freeze Indicator" in "Arrivals" tab
  	  And   User enter "<No Of Vials>" in "noOfVials"
  	  And   User enter "<Volume>" in "totalVolume"
  	  And   User select "<Storage Location>" from "Storage Location" in "Arrivals" tab
  	  And   User enter "<Total Cost>" in "totalCost"
  	  And   User enter random text in "comments"
  		And   User click on "Create" button
  	  When  User click on "Continue" button
  		Then  Arrivals line is created successfully
  	  And   Arrivals line Data is visible in arrival line table to user
  		When  User click on "Save as draft and go back" button
  	  And   User click on "Yes" button
  	  And   Validate arrival state is "Draft"
  		Then  Arrivals Data is visible in arrivals table to user
  		When  User edit the Arrivals data
  		Then  "Stock Arrival" text is visible
  	  And   User select "<Receipt Type>" from "Receipt Type" in "Arrivals" tab
  	  And   User enter random text in "smtNumber"
  	  And   User enter random number in "shippingReferance"
  	  And   User enter random text in "fundingSource"
  	  And   User select "<Currency>" from "Currency" in "Arrivals" tab
  	  And   User enter random number in "freightCost"
  		When  User edit the line in arrival
      And   User select "<Product Type>" from "Product Type" in "Arrivals" tab
  	  And   User select "<Product>" from "Product" in "Arrivals" tab
  	  And   User enter random text in "batchNo"
  	  And   User select "<Producer>" from "Producer" in "Arrivals" tab
  	  And   User select "<Commercial Name>" from "Commercial Name" in "Arrivals" tab
  	  And   User select "<Formulation>" from "Formulation" in "Arrivals" tab
  	  And   User select "<Presentation>" from "Presentation" in "Arrivals" tab
  	  And   User select "<VVM Stage>" from "VVM Stage" in "Arrivals" tab
  	  And   User enter "<Units>" in "units"
  	  And   User select "<Routine or SIA>" from "Routine or SIA" in "Arrivals" tab
  	  And   User select "<Origin>" from "Origin" in "Arrivals" tab
  	  And   User select "<Shipping/Freeze Indicator>" from "Shipping/Freeze Indicator" in "Arrivals" tab
  	  And   User enter "<No Of Vials>" in "noOfVials"
  	  And   User enter "<Volume>" in "totalVolume"
  	  And   User select "<Storage Location>" from "Storage Location" in "Arrivals" tab
  	  And   User enter "<Total Cost>" in "totalCost"
  	  And   User enter random text in "comments"
  	  And   User click on "Update" button
  	  And   User click on "Continue" button
  		Then  Arrivals line is updated successfully
      And   Arrivals line Data is visible in arrival line table to user
    	When  User click on "Finalize" button
  	  And   User click on "Continue" button
  		Then  Arrivals data is update successfully
  	  And   Arrivals Data is visible in arrivals table to user
  	 	And   Validate arrival state is "Complete"
  		Examples:
      | Receipt Type | Currency | Product Type | Product     | Producer             | Commercial Name | Formulation          | Presentation | VVM Stage       | Routine or SIA | Origin    | Shipping/Freeze Indicator | Storage Location | Units | No Of Vials | Volume | Total Cost |
      | Arrival      | AUD      | Vaccine      | bOPV        | PT ONEJECT INDONESIA | BIOPOLIO B1/3   | Liquid: ready to use | 10           | 1.Initial stage | Routine        | Indonesia | Alarm                     | Ambient_2022     | 20    | 20          | 20     | 1000       |      
      
   Scenario Outline: Verify user is able to delete arrival line  And arrival receipt type data before finalizing
   		Given User click on "Log New Arrival" button
  	  Then  "Stock Arrival" text is visible
  	  And   User select "<Receipt Type>" from "Receipt Type" in "Arrivals" tab
  	  And   User enter random text in "smtNumber"
  	  And   User enter random number in "shippingReferance"
  	  And   User enter random text in "fundingSource"
  	  And   User select "<Currency>" from "Currency" in "Arrivals" tab
  	  And   User enter random number in "freightCost"
  		When  User click on "Add Line to Arrival" button
  		Then  "Add Product to Arrival" heading is visible
  	  And   User select "<Product Type>" from "Product Type" in "Arrivals" tab
  	  And   User select "<Product>" from "Product" in "Arrivals" tab
  	  And   User enter random text in "batchNo"
  	  And   User select "<Producer>" from "Producer" in "Arrivals" tab
  	  And   User select "<Commercial Name>" from "Commercial Name" in "Arrivals" tab
  	  And   User select "<Formulation>" from "Formulation" in "Arrivals" tab
  	  And   User select "<Presentation>" from "Presentation" in "Arrivals" tab
  	  And   User select "<VVM Stage>" from "VVM Stage" in "Arrivals" tab
  	  And   User enter "<Units>" in "units"
  	  And   User select "<Routine or SIA>" from "Routine or SIA" in "Arrivals" tab
  	  And   User select "<Origin>" from "Origin" in "Arrivals" tab
  	  And   User select "<Shipping/Freeze Indicator>" from "Shipping/Freeze Indicator" in "Arrivals" tab
  	  And   User enter "<No Of Vials>" in "noOfVials"
  	  And   User enter "<Volume>" in "totalVolume"
  	  And   User select "<Storage Location>" from "Storage Location" in "Arrivals" tab
  	  And   User enter "<Total Cost>" in "totalCost"
  	  And   User enter random text in "comments"
  		When  User click on "Create" button
  	  And   User click on "Continue" button
  		Then  Arrivals line is created successfully
  	  And   Arrivals line Data is visible in arrival line table to user
  		When  User click on "Save as draft and go back" button
  	  And   User click on "Yes" button
  	  And   Validate arrival state is "Draft"
  		Then  Arrivals Data is visible in arrivals table to user   
      And   User edit the Arrivals data
    	When  User delete the line in arrival
      And   User click on "Yes" button
    	Then  Arrivals line is deleted successfully
      And   Arrivals line Data is not visible in arrival line table to user
    	When  User click on "Save as draft and go back" button
  	  And   User click on "Yes" button
  		And   User delete the Arrivals data
      And   User click on "Yes" button
    	Then  Arrivals data is deleted successfully
      And   Arrivals Data is not visible in arrivals table to user
    	Examples:
      | Receipt Type | Currency | Product Type | Product     | Producer                       | Commercial Name | Formulation          | Presentation | VVM Stage       | Routine or SIA | Origin    | Shipping/Freeze Indicator | Storage Location | Units | No Of Vials | Volume | Total Cost |
      | Arrival      | AUD      | Vaccine      | bOPV        | PT ONEJECT INDONESIA           | BIOPOLIO B1/3   | Liquid: ready to use | 10           | 1.Initial stage | Routine        | Indonesia | Alarm                     | Ambient_2022     | 20    | 20          | 20     | 1000       |      
  
    
  