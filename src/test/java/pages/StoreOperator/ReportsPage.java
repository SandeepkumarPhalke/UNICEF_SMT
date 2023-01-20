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
