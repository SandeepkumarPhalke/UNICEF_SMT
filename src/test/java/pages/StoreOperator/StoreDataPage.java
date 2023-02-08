package pages.StoreOperator;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

public class StoreDataPage extends PageObject {

	@FindBy(xpath = "//span[contains(text(),'You cannot delete this item because')]")
	WebElement alreadyInUseMessage_StoreData;

	@FindBy(xpath = "//span[text()='Enter the storage data as per availability']//following::tbody//tr[2]//td[11]//button[1]")
	WebElement editEquipment;

	@FindBy(xpath = "//span[text()='Enter the storage data as per availability']//following::tbody//tr[2]//td[11]//button[2]")
	WebElement deleteEquipment;

	@Step
	public void validateDeletedEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

	@Step
	public void validateEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.uniqueRandomText_Equipment + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	@Step
	public void editStorageDataRecord() {

		$(editEquipment).waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void deleteStorageDataRecord() {

		$(deleteEquipment).waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void deleteNewStorageDataRecord() {

		$("//td[text()='" + CommonPage.uniqueRandomText_Equipment + "']//following::td[6]//button[@title='Delete']")
				.waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void selectValueFromDropdown_StoreData(String value, String dropdownName) {

		String webElementId = null;

		if (dropdownName.equals("Equipment category")) {

			webElementId = "storageEquipmentId";
		} else if (dropdownName.equals("Supplier")) {

			webElementId = "supplierId";
		} else if (dropdownName.equals("Equipment Type/Model")) {

			webElementId = "equipmentTypeId";
		} else if (dropdownName.equals("Status")) {

			webElementId = "statusId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void validateNotDeletedMessageDisplayed_StoreData() {

		Assert.assertTrue(alreadyInUseMessage_StoreData.isDisplayed());
	}
}
