package pages.CountryAdmin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.ClickStrategy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;

public class MasterDataPage extends PageObject {

	@FindBy(xpath = "//span[text()='Country Specific Vaccines']//following::table//tbody/tr[2]//td[1]")
	WebElement vaccineName;

	@FindBy(xpath = "//span[text()='Country Specific Vaccines']//following::table//tbody/tr[2]//td[4]")
	WebElement producer;

	@FindBy(xpath = "//span[text()='Country Specific Supplies']//following::table//tbody/tr[2]//td[1]")
	WebElement productName;

	@FindBy(xpath = "//span[text()='Country Specific Supplies']//following::table//tbody/tr[2]//td[3]")
	WebElement productType;

	@FindBy(xpath = "//span[text()='Country Specific Producers']//following::table//tbody/tr[2]//td[1]")
	WebElement producerName;

	@FindBy(xpath = "//span[text()='Country Specific Producers']//following::table//tbody/tr[2]//td[2]")
	WebElement producerType;

	@FindBy(xpath = "//span[text()='Country Specific Equipment']//following::table//tbody/tr[2]//td[1]")
	WebElement equipmentCategory;

	@FindBy(xpath = "//span[text()='Country Specific Vaccines']//following::table//tbody/tr[2]//td[19]//button[1]")
	WebElement editVaccine;

	@FindBy(xpath = "//span[text()='Country Specific Vaccines']//following::table//tbody/tr[2]//td[19]//button[2]")
	WebElement deleteVaccine;

	@FindBy(xpath = "//span[text()='Country Specific Supplies']//following::table//tbody/tr[2]//td[10]//button[1]")
	WebElement editSupply;

	@FindBy(xpath = "//span[text()='Country Specific Supplies']//following::table//tbody/tr[2]//td[10]//button[2]")
	WebElement deleteSupply;

	@FindBy(xpath = "//span[text()='Country Specific Producers']//following::table//tbody/tr[2]//td[5]//button[1]")
	WebElement editProducer;

	@FindBy(xpath = "//span[text()='Country Specific Producers']//following::table//tbody/tr[2]//td[5]//button[2]")
	WebElement deleteProducer;

	@FindBy(xpath = "//span[text()='Country Specific Equipment']//following::table//tbody/tr[2]//td[7]//button[1]")
	WebElement editEquipment;

	@FindBy(xpath = "//span[text()='Country Specific Equipment']//following::table//tbody/tr[2]//td[7]//button[2]")
	WebElement deleteEquipment;

	@FindBy(xpath = "//span[text()='Master List']//following::button")
	WebElement editTargetGroups;

	@FindBy(xpath = "//span[text()='Master List']//following::button[@title='Add New']")
	WebElement addTargetGroup;

	@FindBy(xpath = "(//span[text()='Master List']//following::button[@title='Edit'])[1]")
	WebElement editTargetGroup;

	@FindBy(xpath = "(//span[text()='Master List']//following::button[@title='Delete'])[1]")
	WebElement deleteTargetGroup;

	@FindBy(xpath = "//span[text()='Master List']//following::button[@title='Cancel']")
	WebElement cancelTargetGroup;

	@FindBy(xpath = "(//thead)[2]//tr//th[1]")
	WebElement targetGroupName;

	@FindBy(xpath = "//span[text()='This target group is already in use and cannot be deleted']")
	WebElement alreadyInUseMessage_TargetGroup;
	
	public static String targetGroup;

	@Step
	public void validateCountrySpecificVaccine(String producerNameVaccine) {

		Assert.assertEquals($(vaccineName).getText().trim(), CommonPage.uniqueRandomText);
		Assert.assertTrue(producerNameVaccine.contains($(producer).getText().trim()));
	}

	@Step
	public void validateCountrySpecificSupply(String productTypeName) {

		Assert.assertEquals($(productName).getText().trim(), CommonPage.uniqueRandomText);
		Assert.assertTrue(productTypeName.contains($(productType).getText().trim()));
	}

	@Step
	public void validateCountrySpecificProducer(String producerTypeName) {

		Assert.assertEquals($(producerName).getText().trim(), CommonPage.uniqueRandomText);
		Assert.assertTrue(producerTypeName.contains($(producerType).getText().trim()));
	}

	@Step
	public void validateCountrySpecificEquipment(String equipmentCategoryName) {

		Assert.assertEquals(equipmentCategoryName, $(equipmentCategory).getText().trim());
	}

	@Step
	public void validateCountrySpecificTargetGroupIsVisible() {

		Assert.assertTrue($("//td[text()='" + CommonPage.uniqueRandomText + "']").isVisible());
	}

	@Step
	public void validateCountrySpecificTargetGroupIsNotVisible() {

		try {
			Assert.assertFalse($("//td[text()='" + targetGroup + "']").isVisible());
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
	}
	
	@Step
	public void validateCountrySpecificUsedTargetGroupIsNotVisible() {

		try {
			Assert.assertFalse($("//td[text()='" + CommonPage.uniqueRandomText + "']").isVisible());
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
	}

	@Step
	public void selectValueFromDropdown_MasterData(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Product Type")) {
			webElementId = "productType";
		} else if (dropdownName.equals("Producer")) {
			webElementId = "producer";
		} else if (dropdownName.equals("Formulation")) {
			webElementId = "formulation";
		} else if (dropdownName.equals("Presentation Mode")) {
			webElementId = "presentationMode";
		} else if (dropdownName.equals("Administration Mode")) {
			webElementId = "administrationMode";
		} else if (dropdownName.equals("VVM Type Id")) {
			webElementId = "vvmTypeId";
		} else if (dropdownName.equals("Producer Type")) {
			webElementId = "producerType";
		} else if (dropdownName.equals("Country")) {
			webElementId = "country";
		} else if (dropdownName.equals("Equipment Category")) {
			webElementId = "storageEquipmentId";
		} else if (dropdownName.equals("Supplier")) {
			webElementId = "supplier";
		} else if (dropdownName.equals("Equipment Type/Model")) {
			webElementId = "equipmentType";
		} else if (dropdownName.equals("Storage Temperature")) {
			webElementId = "storageTemprature";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void clickOnButton_MasterData(String buttonName) {
		if (buttonName.contains("vaccine")) {

			if (buttonName.equals("Edit country specific vaccine")) {

				$(editVaccine).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete country specific vaccine")) {

				$(deleteVaccine).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("supplies")) {

			if (buttonName.equals("Edit country specific supplies")) {

				$(editSupply).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete country specific supplies")) {

				$(deleteSupply).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("producer")) {

			if (buttonName.equals("Edit country specific producer")) {

				$(editProducer).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete country specific producer")) {

				$(deleteProducer).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("equipment")) {

			if (buttonName.equals("Edit country specific equipment")) {

				$(editEquipment).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete country specific equipment")) {

				$(deleteEquipment).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("target")) {

			if (buttonName.equals("Edit target groups")) {

				$(editTargetGroups).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Add target group")) {

				$(targetGroupName).click();
				$(addTargetGroup).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Edit target group")) {

				$(editTargetGroup).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete target group")) {

				targetGroup = $(targetGroupName).getText().trim();
				$(deleteTargetGroup).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Cancel target group")) {

				$(cancelTargetGroup).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete used target group")) {

				targetGroup = $(targetGroupName).getText().trim();
				$("//td[text()='"+ CommonPage.uniqueRandomText +"']//following::button[2]").waitUntilEnabled().waitUntilClickable().click();
			}
		}
	}

	@Step
	public void validateNotDeletedMessageDisplayed_TargetGroup() {

		Assert.assertTrue(alreadyInUseMessage_TargetGroup.isDisplayed());
	}

}
