package stepdefinitions.StoreOperator;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.ArrivalsPage;
import pages.StoreOperator.ReportsPage;

public class ReportsDefinition {

	@Steps
	ReportsPage rp;
	
	@Steps
	CommonPage cp;

	@Then("Reports Data is visible in table to user")
	public void reports_data_is_visible_in_table_to_user() {

		rp.validateDataInTable();
	}

	@Then("User click on Export Report button")
	public void user_click_on_export_report_button() {

		rp.clickExportButton();
	}

	@Then("User click on Export PDF button")
	public void user_click_on_export_pdf_button() {

		rp.clickExportPDFButton();
	}

	@Then("User click on Export Excel button")
	public void user_click_on_export_excel_button() {

		rp.clickExportExcelButton();
	}
	
	@Then("User validate UI and {string} data for {string}")
	public void user_validate_ui_and_data(String reportType, String reportTabName) throws IOException {
	    
		if(reportType.equals("Excel")) {
			
			rp.validateUIAndExcelData(reportTabName);
		} else if(reportType.equals("PDF")) {
			
			rp.validateUIAndPDFData(reportTabName);
		}
		
	}
	
	@Then("User validate UI and {string} data for {string} with {string}")
	public void user_validate_ui_and_data(String reportType, String reportTabName, String reportKPIType) throws IOException {

			rp.validateUIAndPDFDataISCPerformance(reportKPIType);
	}
	
	@Then("User click on includeSubStore checkbox")
	public void user_click_on_includeSubStore_checkbox() {

		
	}

}
