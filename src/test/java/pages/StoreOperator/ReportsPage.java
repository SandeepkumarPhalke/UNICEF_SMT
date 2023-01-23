package pages.StoreOperator;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

public class ReportsPage extends PageObject {

	@FindBy(xpath = "//button[@title='Export']")
	WebElement exportButton;

	@FindBy(xpath = "//li[text()='Export PDF']")
	WebElement exportPDFButton;

	@FindBy(xpath = "//li[text()='Export Excel']")
	WebElement exportExcelButton;

	@FindBy(xpath = "//td[text()='No records to display']")
	WebElement noRecordsText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[2]")
	WebElement smtNumberText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[3]")
	WebElement arrivalsQuantityText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[4]")
	WebElement batchNumberText;
	
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[5]")
	WebElement equipmentNameText;

	@Step
	public void clickExportButton() {

		$(exportButton).waitUntilClickable().click();
	}

	@Step
	public void clickExportPDFButton() {

		$(exportPDFButton).waitUntilEnabled().click();
	}

	@Step
	public void clickExportExcelButton() {

		$(exportExcelButton).waitUntilClickable().click();
	}

	@Step
	public String getDataInUITable(String reportTabName) {

		if (reportTabName.equals("Physical Count & Adjustment")) {

			return $(arrivalsQuantityText).getText();
		} else if (reportTabName.equals("Cold Chain Equipment")) {

			return $(equipmentNameText).getText();
		} else if (reportTabName.equals("Issues")) {

			return $(batchNumberText).getText();
		} else if (reportTabName.equals("Stock Management Summary")) {

			return $(arrivalsQuantityText).getText();
		} else {

			return $(smtNumberText).getText();
		}
	}

	@Step
	public void validateDataInTable() {

		Assert.assertFalse($(noRecordsText).isVisible());
	}

	@Step
	public void selectValueFromDropdown_Reports(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Level")) {
			webElementId = "storeLevel";
		} else if (dropdownName.equals("Store")) {
			webElementId = "storeId";
		} else if (dropdownName.equals("Product Category")) {
			webElementId = "productCategoryId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}
}
