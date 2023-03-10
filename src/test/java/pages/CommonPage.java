package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.StoreOperator.ReportsPage;

public class CommonPage extends PageObject {

	public static String randomText;
	public static String uniqueRandomText;
	public static String uniqueRandomText_Equipment;
	public static String randomNumber;
	public static String uniqueRandomNumber;
	public static String uniqueEmailId;

	@FindBy(xpath = "//span[text()='Data saved successfully']")
	WebElement createMessage;

	@FindBy(xpath = "//span[text()='Data updated successfully']")
	WebElement updateMessage;

	@FindBy(xpath = "//span[text()='Data deleted successfully']")
	WebElement deleteMessage;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']")
	WebElement numberOfRowsDropdown;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']//following::li[text()='10']")
	WebElement numberOfRows10RowsOption;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']//following::li[text()='20']")
	WebElement numberOfRows20RowsOption;
	
	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']//following::li[text()='50']")
	WebElement numberOfRows50RowsOption;

	@FindBy(xpath = "//span[@title='Next Page']")
	WebElement nextPageButton;

	@FindBy(xpath = "//input[@spellcheck='false']")
	WebElement enterFilterTextbox;

	@Steps
	ReportsPage rp;

	public static int stockBalanceCount;
	public static int updatedStockBalanceCount;

	@Step
	public void clickOnTab(String tabName) {

		String webElement = "//span[contains(text(),'" + tabName + "')]";
		$(webElement).waitUntilClickable().click();
	}

	@Step
	public void clickOnButton(String buttonName) {

		String webElement = "//span[text()='" + buttonName + "']";
		$(webElement).waitUntilEnabled().waitUntilClickable().click();

		try {
			if (buttonName.equals("Apply") && $(webElement).isDisplayed()) {

				$(webElement).waitUntilEnabled().waitUntilClickable().click();
			}
		} catch (Exception e) {

		}
	}

	@Step
	public void validateIsHeadingVisible(String headingName) {

		if (headingName.contains("routine") || headingName.contains("supplementary")
				|| headingName.contains("child survival intervention") || headingName.contains("vaccine")
				|| headingName.contains("suppl") || headingName.contains("Producer")
				|| headingName.contains("Equipment")) {

			String webElement = "//h6[text()='" + headingName + "']";
			Assert.assertTrue($(webElement).isVisible());
		} else {

			String webElement = "//h2[text()='" + headingName + "']";
			Assert.assertTrue($(webElement).isVisible());
		}

	}

	@Step
	public void enterRandomText(String textField) {

		String webElement = "//input[@name='" + textField + "']";
		$(webElement).click();
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		if (textField.equals("smtNumber") || textField.equals("name") || textField.equals("english_text")) {

			uniqueRandomText = generateRandomtext();
			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		} else if (textField.equals("batchNo") || textField.equals("english_txt") || textField.equals("french_")) {

			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		} else if (textField.equals("equipmentName")) {

			uniqueRandomText_Equipment = generateRandomtext();
			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText_Equipment);
		} else {

			$(webElement).waitUntilEnabled().sendKeys(generateRandomtext());
		}
	}

	@Step
	public void waitForTime(String time) {

		try {
			Thread.sleep(Integer.parseInt(time) * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Step
	public void enterRandomEmail(String textField) {

		String webElement = "//input[@name='" + textField + "']";
		$(webElement).click();
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		uniqueEmailId = generateRandomtext() + "@test.test";
		$(webElement).waitUntilEnabled().sendKeys(uniqueEmailId);
	}

	@Step
	public void enterRandomNumber(String textField) {

		String webElement = "//input[@name='" + textField + "']";
		$(webElement).click();
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		$(webElement).waitUntilEnabled().sendKeys(generateRandomNumber12Digits());
	}

	@Step
	public String generateRandomtext() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy hh mm ss");
		randomText = "AutoTest" + sdf.format(date).replace(" ", "");
		return randomText;
	}

	@Step
	public String generateCalendarDate() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		return sdf.format(date);
	}

	@Step
	public String generateRandomNumber12Digits() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy hh mm ss");
		randomNumber = sdf.format(date).replace(" ", "");
		return randomNumber;
	}

	@Step
	public void validateTextIsVisible(String text) {

		String webElement = "//span[text()='" + text + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	@Step
	public void validateCreatedMessageDisplayed() {

		Assert.assertTrue(createMessage.isDisplayed());
	}

	@Step
	public void validateUpdatedMessageDisplayed() {

		Assert.assertTrue(updateMessage.isDisplayed());
	}

	@Step
	public void validateDeletedMessageDisplayed() {

		Assert.assertTrue(deleteMessage.isDisplayed());
	}

	@Step
	public void enterTextInTextbox(String text, String textboxName) {

		String webElement = "//input[@name='" + textboxName + "']";
		$(webElement).click();
		while (($(webElement).getValue()).length() != 0 && !(textboxName.contains("frightPercentage"))) {

			$(webElement).sendKeys(Keys.BACK_SPACE);
		}
		$(webElement).sendKeys(text);
	}

	@Step
	public String encodeString(String inputString) {

		return Base64.getEncoder().encodeToString(inputString.getBytes());
	}

	@Step
	public static String decodeString(String inputString) {

		return new String(Base64.getDecoder().decode(inputString));
	}

	@Step
	public void validateValueOfWebElement(String textField, String textFieldExpectedValue) {

		String webElement = "//input[@name='" + textField + "']";
		Assert.assertEquals($(webElement).getTextValue(), textFieldExpectedValue);
	}

	@Step
	public void selectNumberOfRowsOnPage(int count) {

		$(numberOfRowsDropdown).waitUntilClickable().click();
		if (count == 10) {

			$(numberOfRows10RowsOption).waitUntilClickable().click();
		} else if (count == 20) {

			$(numberOfRows20RowsOption).waitUntilClickable().click();
		} else if (count == 50) {

			$(numberOfRows50RowsOption).waitUntilClickable().click();
		}

	}

	@Step
	public void clickNextPageButton() {

		$(nextPageButton).waitUntilClickable().click();
	}

	@Step
	public void typeAndSelectValueFromDropdownWithDivTag(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Recipient Store / Reason")) {
			webElementId = "recipientStore";
		} else if (dropdownName.equals("Store")) {
			webElementId = "storeId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		$("//div[@id='" + webElementId + "']//following::input[@spellcheck='false']").typeAndEnter(value);
	}

	@Step
	public void typeAndSelectValueFromDropdownWithInputTag(String value, String dropdownName) throws AWTException {

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		$(enterFilterTextbox).typeAndEnter(value);
	}

	@Step
	public void pressEscapeKeyOfKeyboard() {

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	@Step
	public void selectValueFromDropdown(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Role")) {
			webElementId = "roleId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
		waitForTime("2");
	}

	@Step
	public void getStockBalanceInStockOverview(String product) {

		stockBalanceCount = Integer.parseInt(
				$("(//tbody[1]//tr[2])[1]//td[1]//following::span[text()='" + product + "']//following::td[1]")
						.getText().replace("\"", "").replace(",", ""));
	}

	@Step
	public void validateUpdatedStockBalanceInStockOverview(String product, String type, String unitCount) {

		updatedStockBalanceCount = Integer.parseInt(
				$("(//tbody[1]//tr[2])[1]//td[1]//following::span[text()='" + product + "']//following::td[1]")
						.getText().replace("\"", "").replace(",", ""));
		String differenceCount = String.valueOf(updatedStockBalanceCount - stockBalanceCount);
		if (type.equals("Issuing")) {

			if (differenceCount.equals("-" + unitCount)) {

				Assert.assertTrue(true);
			} else {

				Assert.fail("Updated stock balance " + updatedStockBalanceCount + " is not as per the requirement.");
			}
		} else {

			if (differenceCount.equals(unitCount)) {

				Assert.assertTrue(true);
			} else {

				Assert.fail("Updated stock balance " + updatedStockBalanceCount + " is not as per the requirement.");
			}
		}
	}
	
	@Step
	public void copyDownloadedFileToRepository() throws IOException {

		Map<String, Integer> m2 = new HashMap<>();

		File directory = new File("C:/Users/" + System.getProperty("user.name") + "/Downloads");
		File[] files = directory.listFiles(File::isFile);
		long lastModifiedTime = Long.MIN_VALUE;
		File chosenFile = null;

		if (files != null) {
			for (File file : files) {
				if (file.lastModified() > lastModifiedTime) {
					chosenFile = file;
					lastModifiedTime = file.lastModified();
				}
			}
		}

		FileInputStream fis = new FileInputStream(chosenFile);
		File dest = new File (System.getProperty("User.dir")+"\\src\\test\\resources\\Files\\ImportHierrarchy.xlsx");
		FileUtils.copyFile(chosenFile, dest);
	}
}
