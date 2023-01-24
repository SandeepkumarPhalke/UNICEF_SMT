package stepdefinitions.StoreOperator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.IssuingPage;
import pages.StoreOperator.StockOverviewPage;
import pages.StoreOperator.StoreDataPage;

public class StockOverviewDefinition {

	@Steps
	StockOverviewPage sop;
	
	@Given("User is on stock overview page")
	public void user_is_on_stock_overiew_page() {
	    
		sop.validateStockOverviewLandingPage();
	}

	@Then("User validates the detail present against each product")
	public void user_validates_the_detail_present_against_each_product() {
	    
		sop.selectAndValidateProducts();
	}
}
