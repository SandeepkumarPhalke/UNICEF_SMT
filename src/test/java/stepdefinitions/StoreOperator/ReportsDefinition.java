package stepdefinitions.StoreOperator;

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

	@Then("Reports Data is visible in table to user")
	public void reports_data_is_visible_in_table_to_user() {

//		rp.validateDataInTable();
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

}
