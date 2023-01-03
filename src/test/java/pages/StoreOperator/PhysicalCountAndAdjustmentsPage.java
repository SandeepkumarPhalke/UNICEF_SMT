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

public class PhysicalCountAndAdjustmentsPage extends PageObject {

	@FindBy(xpath = "//span[text()='Accept Adjustment?']")
	WebElement acceptAdjustmentCheckbox;
	
	@FindBy(xpath = "((//td[text()='Physical Count']//following::td[3])[1]//child::button)[1]")
	WebElement viewPhysicalCountDetails;
	
	@FindBy(xpath = "((//td[text()='Adjustment']//following::td[3])[1]//child::button)[1]")
	WebElement viewAdjustmentDetails;
	
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
		
//		$("//td[text()='"+CommonPage.uniqueRandomText+"']//following::td[8]//button").click();
		$("//td[text()='AutoTest231222042523']//following::td[8]//button").click();
	}
	
	@Step
	public void clickAcceptAdjustmentCheckbox() {
		
		$(acceptAdjustmentCheckbox).click();
	}
	
	@Step
	public void validateUpdatedDataOnPhysicalCountAndAdjustmentsTab(String expectedQuantity) {
		
//		$("//td[text()='"+CommonPage.uniqueRandomText+"']//following::td[1]")
		Assert.assertEquals($("//td[text()='AutoTest231222042523']//following::td[1]").getText(),expectedQuantity);
	}
	
	@Step
	public void clickOnButton(String buttonName) {
		
		if(buttonName.equals("View Physical Count Details")) {
			
			$(viewPhysicalCountDetails).waitUntilEnabled().waitUntilClickable().click();
		} else if(buttonName.equals("View Adjustment Details")) {
			
			$(viewAdjustmentDetails).waitUntilEnabled().waitUntilClickable().click();
		}
	}
	
	@Step
	public void validateUpdatedDifference(String expectedDifferenceQuantity) {
		
//		$("//td[text()='"+CommonPage.uniqueRandomText+"']//following::td[8]")
		Assert.assertEquals($("//td[text()='AutoTest231222042523']//following::td[8]").getText(),expectedDifferenceQuantity);
	}
}
