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
	public static String randomNumber;
	public static String uniqueRandomNumber;

	@FindBy(xpath = "//span[text()='Data saved successfully']")
	WebElement createMessage;

	@FindBy(xpath = "//span[text()='Data updated successfully']")
	WebElement updateMessage;

	@FindBy(xpath = "//span[text()='Data deleted successfully']")
	WebElement deleteMessage;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']")
	WebElement numberOfRowsDropdown;

	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiTablePagination-select MuiSelect-selectMenu MuiInputBase-input']//following::li[text()='20']")
	WebElement numberOfRows20RowsOption;

	@FindBy(xpath = "//span[@title='Next Page']")
	WebElement nextPageButton;

	@FindBy(xpath = "//input[@spellcheck='false']")
	WebElement enterFilterTextbox;

	@Steps
	ReportsPage rp;

	@Step
	public void clickOnTab(String tabName) {

		String webElement = "//span[text()='" + tabName + "']";
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
	public void clickOnCheckBox(String buttonName) {

		String webElement = "//h2[text()='Physical Count & Adjustments']//following::input[@name='acceptAdjustment' and @type='checkbox']";
		$(webElement).waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void validateIsHeadingVisible(String headingName) {

		String webElement = "//h2[text()='" + headingName + "']";
		Assert.assertTrue($(webElement).isVisible());
	}

	@Step
	public void enterRandomText(String textField) {

		String webElement = "//input[@name='" + textField + "']";
		$(webElement).click();
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		if (textField.equals("smtNumber")) {

			uniqueRandomText = generateRandomtext();
			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		} else if (textField.equals("batchNo")) {

			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		} else {

			$(webElement).waitUntilEnabled().sendKeys(generateRandomtext());
		}
	}

	@Step
	public void enterRandomEmail(String textField) {

		String webElement = "//input[@name='" + textField + "']";
		$(webElement).click();
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		$(webElement).waitUntilEnabled().sendKeys(generateRandomtext() + "@test.test");
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
		$(webElement).sendKeys(Keys.BACK_SPACE);
		$(webElement).sendKeys(Keys.BACK_SPACE);
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
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
	public void selectNumberOfRowsOnPage() {

		$(numberOfRowsDropdown).waitUntilClickable().click();
		$(numberOfRows20RowsOption).waitUntilClickable().click();
	}

	@Step
	public void clickNextPageButton() {

		$(nextPageButton).waitUntilClickable().click();
	}

	@Step
	public void typeAndSelectValueFromDropdown(String value, String dropdownName) {

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
	public void typeAndSelectValueFromDropdownWithInput(String value, String dropdownName) throws AWTException {

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
	public void validateUIAndExcelData(String reportTabName) throws IOException {

		Assert.assertEquals((rp.getDataInUITable(reportTabName)).replace(",", ""), getDataInExcel(reportTabName));
	}

	@Step
	public void validateUIAndPDFData(String reportTabName) throws IOException {

		if(reportTabName.equals("Stock Management Summary")) {
			
			Assert.assertTrue(getDataInPDF().contains(rp.getDataInUITable(reportTabName)));
		}else if(reportTabName.equals("Stock Status")){
			
			Assert.assertTrue(getDataInPDF().contains((rp.getDataInUITable(reportTabName)).replace(",", "")));
		}else if(reportTabName.equals("iSC Performance")){
			
			Assert.assertTrue(getDataInPDF().contains("ISC Performance Report"));
		}else if(reportTabName.equals("Cold Chain Equipment")){
			
			Assert.assertTrue(getDataInPDF().contains((rp.getDataInUITable(reportTabName)).substring(15)));
		}else {
			
			Assert.assertTrue(getDataInPDF().contains((rp.getDataInUITable(reportTabName)).substring(14)));
		}
		
	}

	@Step
	public String getDataInExcel(String reportTabName) throws IOException {

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
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		if (reportTabName.equals("Arrivals")) {

			return (sheet.getRow(4).getCell(1)).toString();
		} else if (reportTabName.equals("Issues")) {

			return (sheet.getRow(4).getCell(3)).toString();
		} else if (reportTabName.equals("Stock Management Summary")) {

			return (sheet.getRow(4).getCell(2).getRawValue()).toString();
		} else if (reportTabName.equals("Physical Count & Adjustment")) {

			return (sheet.getRow(4).getCell(2)).toString();
		} else if (reportTabName.equals("Cold Chain Equipment")) {

			return (sheet.getRow(4).getCell(4)).toString();
		} else if (reportTabName.equals("Stock Status")) {

			return (sheet.getRow(34).getCell(1).getRawValue()).toString();
		}

		return "No Data Found in Excel.";
	}

	@Step
	public String getDataInPDF() throws IOException {

		PDDocument document = null;

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

		try {
			document = PDDocument.load(chosenFile);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			return text;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			document.close();
		}
		return "No Data Found in PDF.";
	}
}
