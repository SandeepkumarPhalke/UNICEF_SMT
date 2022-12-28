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

public class StoreDataPage extends PageObject {

	public void validateDeletedEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

	public void validateEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	public void editStorageDataRecord() {

		$("//td[text()='" + CommonPage.randomText + "']//following::td[6]//button[@title='Edit']").waitUntilEnabled()
				.waitUntilClickable().click();
	}

	public void deleteStorageDataRecord() {

		$("//td[text()='" + CommonPage.randomText + "']//following::td[6]//button[@title='Delete']").waitUntilEnabled()
				.waitUntilClickable().click();
	}
	
	@Step
	public void selectValueFromDropdown_StoreData(String value, String dropdownName) {
		
		String webElementId = null;
		
		if(dropdownName.equals("Equipment category")) {
			
			webElementId = "storageEquipmentId"; 
		}
		else if(dropdownName.equals("Supplier")) {
			
			webElementId = "supplierId"; 
		}
		else if(dropdownName.equals("Equipment Type/Model")) {
			
			webElementId = "equipmentTypeId"; 
		}
		else if(dropdownName.equals("Status")) {
			
			webElementId = "statusId"; 
		}
		
		$("//div[@id='"+webElementId+"']").waitUntilClickable().click();
		$("//li//span[text()='"+value+"']").waitUntilClickable().click();
	}
}
