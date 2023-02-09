package pages.SDAdmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import pages.StoreOperator.ReportsPage;

public class UsersPage extends PageObject {

	@FindBy(xpath = "//span[contains(text(),'+')]//parent::button")
	WebElement addRoleButton;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameInput;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameInput;

	@FindBy(xpath = "//input[@name='userEmail']")
	WebElement userEmailInput;

	@FindBy(xpath = "(//input[@spellcheck='false'])[1]")
	WebElement userRegionDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[2]")
	WebElement userCountryDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[3]")
	WebElement userNationalStoreDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[4]")
	WebElement userLevelTwoDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[5]")
	WebElement userLevelThreeDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[6]")
	WebElement userLevelFourDropdown;

	@FindBy(xpath = "(//input[@spellcheck='false'])[7]")
	WebElement userLevelFiveDropdown;

	@FindBy(xpath = "//tbody//tr[2]//td[5]")
	WebElement createdUserEmailText;

	@FindBy(xpath = "//tbody//tr[2]//td[3]")
	WebElement updatedUserFirstNameText;

	@FindBy(xpath = "//tbody//tr[2]//td[16]//button[1]")
	WebElement editUserButton;
	
	@FindBy(xpath = "//span[contains(text(),'1-')]")
	WebElement numberOfPageRecordsText;

	@Steps
	CommonPage cp;

	@Step
	public void validateCreateUserPage() {

		Assert.assertTrue(addRoleButton.isDisplayed());
	}

	@Step
	public void selectValueFromDropdown_Users(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Role")) {
			webElementId = "userRegion[0].role";
		} else if (dropdownName.equals("Level")) {
			webElementId = "userRegion[0].level";
		}

		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

	@Step
	public void typeAndSelectValueFromDropdownWithInputTag_Users(String value, String dropdownName) {

		if (dropdownName.equals("Region")) {

			$(userRegionDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("Country")) {

			$(userCountryDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("National Store")) {

			$(userNationalStoreDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("Level Two")) {

			$(userLevelTwoDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("Level Three")) {

			$(userLevelThreeDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("Level Four")) {

			$(userLevelFourDropdown).typeAndEnter(value);
		} else if (dropdownName.equals("Level Five")) {

			$(userLevelFiveDropdown).typeAndEnter(value);
		}
	}

	@Step
	public void validateUserCreationInUsersTable() {

		Assert.assertEquals($(createdUserEmailText).getText().trim(), CommonPage.uniqueEmailId);
	}

	@Step
	public void validateUserUpdationInUsersTable() {

		Assert.assertEquals($(updatedUserFirstNameText).getText().trim(), "Automation Updated");
	}

	@Step
	public void clickOnButton_Users(String buttonName) {
		if (buttonName.equals("Edit User")) {

			$(editUserButton).waitUntilEnabled().waitUntilClickable().click();
		}
	}

	@Step
	public void validateUIAndExcelData() throws IOException {

		Assert.assertEquals(getDataInUITable(), getDataInExcel());
	}

	@Step
	public Set<String> getDataInUITable() {

		Set<String> uiEmailsList = new HashSet<>();
		String thisPageLastUserCount;
		if($(numberOfPageRecordsText).isVisible()) {
			
			cp.selectNumberOfRowsOnPage(50);
			String totalUsersCountString = $(numberOfPageRecordsText).getText();
			String totalUsersCount = totalUsersCountString.substring(8);
			
			if (totalUsersCount.length() == 2) {

				thisPageLastUserCount = totalUsersCountString.substring(2, 4).trim();
			} else {

				thisPageLastUserCount = totalUsersCountString.substring(2, 5).trim();
			}

			if (Integer.parseInt(totalUsersCount) > 50) {

				while (thisPageLastUserCount != totalUsersCount) {

					for (int i = 2; i <= Integer.parseInt(thisPageLastUserCount) + 1; i++) {

						String uiEmails = $("//tbody//tr[" + i + "]//td[5]").getText().trim();
						uiEmailsList.add(uiEmails);
					}
					
					cp.clickNextPageButton();
					String totalUsersCountString2 = $(numberOfPageRecordsText).getText();
					thisPageLastUserCount = totalUsersCountString2.substring(3, 5).trim();
				}

			} else {

				for (int i = 2; i <= Integer.parseInt(totalUsersCount) + 1; i++) {

					String uiEmails = $("//tbody//tr[" + i + "]//td[5]").getText().trim();
					uiEmailsList.add(uiEmails);
				}
			}
			
			System.out.println("UI List - " + uiEmailsList.size());
		}
		else {
			
			
		}
		

		return uiEmailsList;
	}

	@Step
	public Set<String> getDataInExcel() throws IOException {

		Set<String> excelEmailsList = new HashSet<>();

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
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (int i = 2; i <= sheet.getLastRowNum(); i++) {

				String excelEmails = (sheet.getRow(i).getCell(3)).toString();
				excelEmailsList.add(excelEmails);
			}
			System.out.println("Excel List - " + excelEmailsList.size());
			return excelEmailsList;
		}
	}
}
