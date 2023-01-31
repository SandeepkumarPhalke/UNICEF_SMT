package pages.CountryAdmin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;

public class ProgrammeDataPage extends PageObject {

	@FindBy(xpath = "(//span[text()='Routine Vaccinations']//following::span[text()='Add'])[1]")
	WebElement addRoutineVaccine;

	@FindBy(xpath = "//span[text()='Routine Vaccinations']//following::table[1]//tbody//tr[1]//td[2]//following::button[1]")
	WebElement editRoutineVaccine;

	@FindBy(xpath = "//span[text()='Routine Vaccinations']//following::table[1]//tbody//tr[1]//td[2]//following::button[2]")
	WebElement deleteRoutineVaccine;

	@FindBy(xpath = "(//span[text()='Supplementary Vaccinations']//following::span[text()='Add'])[1]")
	WebElement addSupplementaryVaccine;

	@FindBy(xpath = "//span[text()='Supplementary Vaccinations']//following::table[1]//tbody//tr[1]//td[2]//following::button[1]")
	WebElement editSupplementaryVaccine;

	@FindBy(xpath = "//span[text()='Supplementary Vaccinations']//following::table[1]//tbody//tr[1]//td[2]//following::button[2]")
	WebElement deleteSupplementaryVaccine;
	
	@FindBy(xpath = "(//span[text()='Other Child Survival Interventions']//following::span[text()='Add'])[1]")
	WebElement addChildSurvivalIntervention;

	@FindBy(xpath = "//span[text()='Other Child Survival Interventions']//following::table[1]//tbody//tr[1]//td[2]//following::button[1]")
	WebElement editChildSurvivalIntervention;

	@FindBy(xpath = "//span[text()='Other Child Survival Interventions']//following::table[1]//tbody//tr[1]//td[2]//following::button[2]")
	WebElement deleteChildSurvivalIntervention;

	@FindBy(xpath = "//span[text()='Routine Vaccinations']//following::table[1]//tbody//tr[1]//td[2]")
	WebElement producerRoutineVaccine;

	@FindBy(xpath = "//span[text()='Supplementary Vaccinations']//following::table[1]//tbody//tr[1]//td[2]")
	WebElement producerSupplementaryVaccine;
	
	@FindBy(xpath = "//span[text()='Other Child Survival Interventions']//following::table[1]//tbody//tr[1]//td[1]")
	WebElement productNameChildSurvivalIntervention;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement yesButton;

	@Steps
	CommonPage cp;

	@Step
	public void clickOnButton_ProgrammeData(String buttonName) {
		if (buttonName.contains("Routine")) {

			if (buttonName.equals("Add Routine Vaccine")) {

				$(addRoutineVaccine).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Edit Routine Vaccine")) {

				$(editRoutineVaccine).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete Routine Vaccine")) {

				$(deleteRoutineVaccine).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("Supplementary")) {

			if (buttonName.equals("Add Supplementary Vaccine")) {

				$(addSupplementaryVaccine).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Edit Supplementary Vaccine")) {

				$(editSupplementaryVaccine).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete Supplementary Vaccine")) {

				$(deleteSupplementaryVaccine).waitUntilEnabled().waitUntilClickable().click();
			}
		} else if (buttonName.contains("child survival intervention")) {

			if (buttonName.equals("Add child survival intervention")) {

				$(addChildSurvivalIntervention).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Edit child survival intervention")) {

				$(editChildSurvivalIntervention).waitUntilEnabled().waitUntilClickable().click();
			} else if (buttonName.equals("Delete child survival intervention")) {

				$(deleteChildSurvivalIntervention).waitUntilEnabled().waitUntilClickable().click();
			}
		}
	}

	@Step
	public void selectValueFromDropdown_ProgrammeData(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Vaccine Name")) {
			webElementId = "vaccineNameId";
		} else if (dropdownName.equals("Producer")) {
			webElementId = "producer";
		} else if (dropdownName.equals("Formulation")) {
			webElementId = "formulation";
		} else if (dropdownName.equals("Target Groups")) {
			webElementId = "targetGroupId";
		} else if (dropdownName.equals("Presentation")) {
			webElementId = "presentation";
		} else if (dropdownName.equals("Administration Type")) {
			webElementId = "administrationId";
		} else if (dropdownName.equals("Dilution-Syringes") || dropdownName.equals("Product Name")) {
			webElementId = "syringesId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	public void validateEntryInRoutineVaccinationTable(String producerName) {

		Assert.assertEquals(producerName, $(producerRoutineVaccine).getText());
	}

	public void validateEntryInSupplementaryVaccinationTable(String producerName) {

		Assert.assertEquals(producerName, $(producerSupplementaryVaccine).getText());
	}
	
	public void validateEntryInChildSurvivalInterventionTable(String productName) {

		Assert.assertEquals(productName, $(productNameChildSurvivalIntervention).getText());
	}
}
