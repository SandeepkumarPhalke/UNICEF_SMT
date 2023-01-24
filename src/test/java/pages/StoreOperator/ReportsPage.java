package pages.StoreOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

public class ReportsPage extends PageObject {

	@FindBy(xpath = "//button[@title='Export']")
	WebElement exportButton;

	@FindBy(xpath = "//li[text()='Export PDF']")
	WebElement exportPDFButton;

	@FindBy(xpath = "//li[text()='Export Excel']")
	WebElement exportExcelButton;

	@FindBy(xpath = "//td[text()='No records to display']")
	WebElement noRecordsText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[2]")
	WebElement smtNumberText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[3]")
	WebElement arrivalsQuantityText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[4]")
	WebElement batchNumberText;

	@FindBy(xpath = "//tbody[@class='MuiTableBody-root']//tr[2]//td[5]")
	WebElement equipmentNameText;

	@FindBy(xpath = "//input[@name='isChildInclude' and @type='checkbox']")
	WebElement includeSubstoreCheckbox;

	@FindBy(xpath = "//span[text()='Generate Report']//following::span[text()='Supply Adequacy']")
	WebElement supplyAdequacyText;

	@Step
	public void clickExportButton() {

		$(exportButton).waitUntilClickable().click();
	}

	@Step
	public void clickExportPDFButton() {

		$(exportPDFButton).waitUntilEnabled().click();
	}

	@Step
	public void clickExportExcelButton() {

		$(exportExcelButton).waitUntilClickable().click();
	}

	@Step
	public String getDataInUITable(String reportTabName) {

		if (reportTabName.equals("Physical Count & Adjustment")) {

			return $(arrivalsQuantityText).getText();
		} else if (reportTabName.equals("Cold Chain Equipment")) {

			return $(equipmentNameText).getText();
		} else if (reportTabName.equals("Issues")) {

			return $(batchNumberText).getText();
		} else if (reportTabName.equals("Stock Management Summary")) {

			return $(arrivalsQuantityText).getText();
		} else if (reportTabName.equals("Supply Adequacy")) {

			return $(supplyAdequacyText).getText();
		} else {

			return $(smtNumberText).getText();
		}
	}

	@Step
	public void validateDataInTable() {

		Assert.assertFalse($(noRecordsText).isVisible());
	}

	@Step
	public void selectValueFromDropdown_Reports(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Level")) {
			webElementId = "storeLevel";
		} else if (dropdownName.equals("Store")) {
			webElementId = "storeId";
		} else if (dropdownName.equals("Product Category")) {
			webElementId = "productCategoryId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void validateUIAndExcelData(String reportTabName) throws IOException {

		Assert.assertEquals((getDataInUITable(reportTabName)).replace(",", ""), getDataInExcel(reportTabName));
	}

	@Step
	public void validateUIAndPDFData(String reportTabName) throws IOException {

		if (reportTabName.equals("Stock Management Summary")) {

			Assert.assertTrue(getDataInPDF().contains(getDataInUITable(reportTabName)));
		} else if (reportTabName.equals("Stock Status")) {

			Assert.assertTrue(getDataInPDF().contains((getDataInUITable(reportTabName)).replace(",", "")));
		} else if (reportTabName.equals("iSC Performance")) {

			Assert.assertTrue(getDataInPDF().contains("ISC Performance Report"));
		} else if (reportTabName.equals("Supply Adequacy")) {

			Assert.assertTrue(getDataInPDF().contains("VaccineRoutine"));
		} else if (reportTabName.equals("Cold Chain Equipment")) {

			Assert.assertTrue(getDataInPDF().contains((getDataInUITable(reportTabName)).substring(15)));
		} else {

			Assert.assertTrue(getDataInPDF().contains((getDataInUITable(reportTabName)).substring(14)));
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
		} else if (reportTabName.equals("Stock Status")) {

			return "Supply Adequacy";
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

	@Step
	public void clickIncludeSubStoreCheckbox(String reportTabName) throws IOException {

		$(includeSubstoreCheckbox).waitUntilClickable().click();
	}

	@Step
	public void validateUIAndPDFDataISCPerformance(String reportKPIType) throws IOException {

		if (reportKPIType.equals("Temperature")) {

			Assert.assertTrue(getDataInPDF().contains("Temperature"));
		} else if (reportKPIType.equals("CCE Functionality")) {

			Assert.assertTrue(getDataInPDF().contains("CCE Functionality"));
		} else if (reportKPIType.equals("Wastage")) {

			Assert.assertTrue(getDataInPDF().contains("Wastage"));
		}else if (reportKPIType.equals("Full Stock Availability")) {

			Assert.assertTrue(getDataInPDF().contains("Full Stock Availability"));
		}else if (reportKPIType.equals("Stock Out Days")) {

			Assert.assertTrue(getDataInPDF().contains("Stock Out Days"));
		}else if (reportKPIType.equals("Stocked According to Plan")) {

			Assert.assertTrue(getDataInPDF().contains("Stocked According to Plan"));
		}else if (reportKPIType.equals("Forecasted Demand Vs Issues")) {

			Assert.assertTrue(getDataInPDF().contains("Forecasted Demand Vs Issues"));
		}
	}
}
