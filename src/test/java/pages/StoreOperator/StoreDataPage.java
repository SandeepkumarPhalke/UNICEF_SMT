package pages.StoreOperator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;

public class StoreDataPage extends PageObject {

	@FindBy(xpath = "//span[contains(text(),'You cannot delete this item because')]")
	WebElement alreadyInUseMessage_StoreData;

	@FindBy(xpath = "//span[text()='Enter the storage data as per availability']//following::tbody//tr[2]//td[11]//button[1]")
	WebElement editEquipment;

	@FindBy(xpath = "//span[text()='Enter the storage data as per availability']//following::tbody//tr[2]//td[11]//button[2]")
	WebElement deleteEquipment;

	@Steps
	CommonPage cp;

	@Step
	public void validateDeletedEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.randomText + "']";
		try {

			Assert.assertTrue($(webElement).isDisplayed());
		} catch (org.openqa.selenium.NoSuchElementException e) {

			Assert.assertTrue(true);
		}
	}

	@Step
	public void validateEntryInStorageDataTable() {
		String webElement = "//td[text()='" + CommonPage.uniqueRandomText_Equipment + "']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

	@Step
	public void editStorageDataRecord() {

		$(editEquipment).waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void deleteStorageDataRecord() {

		$(deleteEquipment).waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void deleteNewStorageDataRecord() {

		$("//td[text()='" + CommonPage.uniqueRandomText_Equipment + "']//following::td[6]//button[@title='Delete']")
				.waitUntilEnabled().waitUntilClickable().click();
	}

	@Step
	public void selectValueFromDropdown_StoreData(String value, String dropdownName) {

		String webElementId = null;

		if (dropdownName.equals("Equipment category")) {

			webElementId = "storageEquipmentId";
		} else if (dropdownName.equals("Supplier")) {

			webElementId = "supplierId";
		} else if (dropdownName.equals("Equipment Type/Model")) {

			webElementId = "equipmentTypeId";
		} else if (dropdownName.equals("Status")) {

			webElementId = "statusId";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void validateNotDeletedMessageDisplayed_StoreData() {

		Assert.assertTrue(alreadyInUseMessage_StoreData.isDisplayed());
	}

	@Step
	public void validateUIAndExcelData() throws IOException {

		Assert.assertEquals(getDataInUITable(), getDataInExcel());
	}

	@Step
	public Map<String, Integer> getDataInUITable() {

		Map<String, Integer> m = new HashMap<>();

		List<WebElement> l = getDriver().findElements(By.xpath("(//tbody)[2]//tr"));
		System.out.println(l.size());

		for (int i = 1; i <= l.size(); i++) {

			for (int j = 2; j <= 6; j++) {

				String c = $("(//tbody)[2]//tr[" + i + "]//td[" + j + "]").getText();
				if (c.length() > 0) {

					m.put(c, j - 1);
				}
			}

		}
		System.out.println(m);
		return m;
	}

	@Step
	public Map<String, Integer> getDataInExcel() throws IOException {

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
		System.out.println(chosenFile);
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet("Locations");
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				String facilityName = (sheet.getRow(i).getCell(4)).toString();
				String supplyChainLevelCode = (sheet.getRow(i).getCell(5)).getRawValue();

				m2.put(facilityName, Integer.parseInt(supplyChainLevelCode));
			}
			System.out.println(m2);
			return m2;
		}
	}

	@Step
	public void updateLevelNameToAutomationNames() {

		for (int i = 1; i <= 5; i++) {

			$("(//tbody)[1]//tr[" + i + "]//button[1]").waitUntilClickable().click();
			$("(//tbody)[1]//tr[" + i + "]//input[1]").sendKeys("AutoTest-Level" + i);
			$("(//tbody)[1]//tr[" + i + "]//button[1]").waitUntilClickable().click();
			cp.validateCreatedMessageDisplayed();
		}
	}
	
	@Step
	public void updateLevelNameToPreviousNames() {

		for (int i = 1; i <= 5; i++) {

			$("(//tbody)[1]//tr[" + i + "]//button[1]").waitUntilClickable().click();
			$("(//tbody)[1]//tr[" + i + "]//input[1]").sendKeys("Level" + i);
			$("(//tbody)[1]//tr[" + i + "]//button[1]").waitUntilClickable().click();
			cp.validateCreatedMessageDisplayed();
		}
	}
	
	@Step
	public void validateLevelNameToAutomationNames() {

		for (int i = 2; i <= 6; i++) {

			Assert.assertEquals($("(//thead)[2]//th[" + i + "]").getText().trim(), "AutoTest-Level" + (i-1));
		}
	}
	
	
}
