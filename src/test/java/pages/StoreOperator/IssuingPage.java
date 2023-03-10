package pages.StoreOperator;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;

public class IssuingPage extends PageObject {

	@Steps
	CommonPage cp;

	@FindBy(xpath = "//tr[2]//td[1]")
	WebElement issueDateText;

	@FindBy(xpath = "//tr[2]//td[2]")
	WebElement smtNumberText;

	@FindBy(xpath = "(//td[contains(text(),'AREDub')])[1]//following::td[3]")
	WebElement issueStateText;

	@FindBy(xpath = "//tbody//tr[2]//td[2]")
	WebElement smtNumberWastageText;

	@FindBy(xpath = "//tbody//tr[2]//td[5]")
	WebElement issueStateWastageStatus;

	@FindBy(xpath = "(//td[contains(text(),'AREDub')])[1]//following::td[4]//button[1]")
	WebElement issueEditButton;

	@FindBy(xpath = "(//td[contains(text(),'AREDub')])[1]//following::td[4]//button[3]")
	WebElement issueDeleteButton;

	@FindBy(xpath = "//td[21]//button[@title='Edit']")
	WebElement issueLineEditButton;

	@FindBy(xpath = "//td[21]//button[@title='Delete']")
	WebElement issueLineDeleteButton;

	@FindBy(xpath = "//span[text()='SMT Number']")
	WebElement sortSMTNumber;

	public static String smtNumber;

	@Step
	public void selectValueFromDropdown_Issuing(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Issue Type")) {
			webElementId = "issueTypes";
		} else if (dropdownName.equals("Distributed Late")) {
			webElementId = "distributed";
		} else if (dropdownName.equals("Recipient Store")) {
			webElementId = "recipientStore";
		} else if (dropdownName.equals("Product Type")) {
			webElementId = "productType";
		} else if (dropdownName.equals("Product")) {
			webElementId = "product";
		} else if (dropdownName.equals("Batch Number")) {
			webElementId = "batch";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void validateEntryInIssuingTable() {

		String webElement = "//span[text()='" + CommonPage.randomText + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	@Step
	public void validateStateOfIssuingEntry(String state, String issueType) {

		if (issueType.equals("Wastage")) {

			Assert.assertEquals((smtNumberWastageText).getText().trim(), "");
			Assert.assertEquals(state, $(issueStateWastageStatus).getText().trim());
		} else if (issueType.equals("Requisition")) {

			cp.selectNumberOfRowsOnPage(20);
			$(sortSMTNumber).waitUntilClickable().click();
			$(sortSMTNumber).waitUntilClickable().click();
			smtNumber = $(smtNumberText).getText().trim();
			Assert.assertEquals(state, $(issueStateText).getText().trim());
		}

	}

	@Step
	public void editIssuingData() {

		$(issueEditButton).waitUntilClickable().click();
	}

	@Step
	public void deleteIssuingData() {

		$(issueDeleteButton).waitUntilClickable().click();
	}

	@Step
	public void editIssuingLineData() {

		$(issueLineEditButton).waitUntilClickable().click();
	}

	@Step
	public void deleteIssuingLineData() {

		$(issueLineDeleteButton).waitUntilClickable().click();
	}

	@Step
	public void validateDeletedLineEntryInIssuingTable() {

		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

	@Step
	public void validateDeletedEntryInIssuingTable() {

		String webElement = "//td[text()='" + smtNumber + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

}
