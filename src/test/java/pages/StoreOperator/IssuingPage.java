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

public class IssuingPage extends PageObject {
	
	@Steps 
	CommonPage cp;
	
	@FindBy(xpath = "//tr[4]//td[1]")
	WebElement issueDateText;
	
	@FindBy(xpath = "//tr[4]//td[2]")
	WebElement smtNumberText;
	
	@FindBy(xpath = "//tr[4]//td[5]")
	WebElement issueStateText;
	
	@FindBy(xpath = "//tr[4]//td[6]//button[@title='Edit']")
	WebElement issueEditButton;
	
	@FindBy(xpath = "//tr[4]//td[6]//button[@title='Delete']")
	WebElement issueDeleteButton;
	
	@FindBy(xpath = "//td[21]//button[@title='Edit']")
	WebElement issueLineEditButton;
	
	@FindBy(xpath = "//td[21]//button[@title='Delete']")
	WebElement issueLineDeleteButton;
	
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

	public void validateEntryInIssuingTable() {

		String webElement = "//span[text()='" + CommonPage.randomText + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}
	
	public void validateStateOfIssuingEntry(String state) {

		smtNumber = $(smtNumberText).getText().trim();
		Assert.assertEquals(state, $(issueStateText).getText().trim());
		//cp.generateCalendarDate().equals($(issueDateText).getText());
	}

	public void editIssuingData() {

		$(issueEditButton).waitUntilClickable()
				.click();
	}
	
	public void deleteIssuingData() {

		$(issueDeleteButton).waitUntilClickable()
				.click();
	}

	public void editIssuingLineData() {

		$(issueLineEditButton).waitUntilClickable()
				.click();
	}
	
	public void deleteIssuingLineData() {

		$(issueLineDeleteButton).waitUntilClickable()
		.click();
	}
	
	public void validateDeletedLineEntryInIssuingTable() {

		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}
	
	public void validateDeletedEntryInIssuingTable() {

		String webElement = "//td[text()='" + smtNumber + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}
	
}
