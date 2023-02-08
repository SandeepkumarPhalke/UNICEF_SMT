package pages.StoreOperator;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;

public class PhysicalCountAndAdjustmentsPage extends PageObject {

	@FindBy(xpath = "//span[text()='Accept Adjustment?']")
	WebElement acceptAdjustmentCheckbox;

	@FindBy(xpath = "((//td[text()='Physical Count']//following::td[3])[1]//child::button)[1]")
	WebElement viewPhysicalCountDetails;

	@FindBy(xpath = "((//td[text()='Adjustment']//following::td[3])[1]//child::button)[1]")
	WebElement viewAdjustmentDetails;

	@Steps
	CommonPage cp;

	@Step
	public void selectValueFromDropdown_PhysicalCountAndAdjustments(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Adjustment Type")) {
			webElementId = "adjustmentType";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void editPhysicalCountAndAdjustmentsRecord() {

		$("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[8]//button").click();
	}

	@Step
	public void clickAcceptAdjustmentCheckbox() {

		$(acceptAdjustmentCheckbox).click();
	}

	@Step
	public void validateUpdatedDataOnPhysicalCountAndAdjustmentsTab(String expectedQuantity) {

		Assert.assertEquals($("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[1]").getText(),
				expectedQuantity);
	}

	@Step
	public void clickOnButton(String buttonName) {

		if (buttonName.equals("View Physical Count Details")) {
			if ($(viewPhysicalCountDetails).isVisible()) {

				$(viewPhysicalCountDetails).waitUntilEnabled().waitUntilClickable().click();
			} else {

				cp.selectNumberOfRowsOnPage(20);
				for (int i = 0; i < 5; i++) {
					if ($(viewPhysicalCountDetails).isVisible()) {

						$(viewPhysicalCountDetails).waitUntilEnabled().waitUntilClickable().click();
						break;
					} else {

						cp.clickNextPageButton();
					}
				}
			}
		} else if (buttonName.equals("View Adjustment Details")) {

			if ($(viewAdjustmentDetails).isVisible()) {

				$(viewAdjustmentDetails).waitUntilEnabled().waitUntilClickable().click();
			} else {

				cp.selectNumberOfRowsOnPage(20);
				for (int i = 0; i < 5; i++) {
					if ($(viewAdjustmentDetails).isVisible()) {

						$(viewAdjustmentDetails).waitUntilEnabled().waitUntilClickable().click();
						break;
					} else {

						cp.clickNextPageButton();
					}
				}
			}
		}
	}

	@Step
	public void validateUpdatedDifference(String expectedDifferenceQuantity) {

		if (expectedDifferenceQuantity.contains("-")) {

			Assert.assertEquals($("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[7]").getText(),
					String.valueOf(Integer.parseInt(expectedDifferenceQuantity) * (-1)));
		} else {

			Assert.assertEquals($("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[8]").getText(),
					expectedDifferenceQuantity);
		}
	}

	@Step
	public void validateArrivalAdjustedDetails() {

		Assert.assertTrue($("//td[text()='" + CommonPage.uniqueRandomText + "']//following::td[8]").isDisplayed());
	}
}
