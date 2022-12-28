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

public class ArrivalsPage extends PageObject {

	@FindBy(xpath = "//tr[@class='MuiTableRow-root']//td[3]//following::td[23]//button[1]")
	WebElement editArrivalsLineButton;

	@Step
	public void selectValueFromDropdown_Arrivals(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Receipt Type")) {
			webElementId = "receiptTypeId";
		} else if (dropdownName.equals("Currency")) {
			webElementId = "currencyId";
		} else if (dropdownName.equals("Product Type")) {
			webElementId = "productType";
		} else if (dropdownName.equals("Product")) {
			webElementId = "productId";
		} else if (dropdownName.equals("Producer")) {
			webElementId = "producerId";
		} else if (dropdownName.equals("Commercial Name")) {
			webElementId = "commercialName";
		} else if (dropdownName.equals("Formulation")) {
			webElementId = "formulationId";
		} else if (dropdownName.equals("Presentation")) {
			webElementId = "presentation";
		} else if (dropdownName.equals("VVM Stage")) {
			webElementId = "vvmStageId";
		} else if (dropdownName.equals("Routine or SIA")) {
			webElementId = "routineOrSia";
		} else if (dropdownName.equals("Origin")) {
			webElementId = "producerCountryId";
		} else if (dropdownName.equals("Shipping/Freeze Indicator")) {
			webElementId = "freezeTag";
		} else if (dropdownName.equals("Volume")) {
			webElementId = "totalVolume";
		} else if (dropdownName.equals("Storage Location")) {
			webElementId = "storageLocationId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	public void validateDeletedEntryInArrivalsTable() {

		String webElement = "//td[text()='" + CommonPage.uniqueRandomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

	public void validateEntryInArrivalsTable() {

		String webElement = "//td[text()='" + CommonPage.uniqueRandomText + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	public void validateStateOfArrivalEntry(String state) {

		String webElement = "//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[3]";
		Assert.assertEquals(state, $(webElement).getText().trim());
	}

	public void editArrivalsData() {

		$("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[4]//button[1]").waitUntilClickable()
				.click();
	}

	public void editArrivalsLineData() {

		$("//tr[@class='MuiTableRow-root']//td[3]//following::td[23]//button[1]").waitUntilClickable().click();
	}

	public void deleteArrivalsData() {

		$("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[4]//button[2]").waitUntilClickable()
				.click();
	}

	public void deleteArrivalsLineData() {

		$(editArrivalsLineButton).waitUntilClickable().click();
	}
}
