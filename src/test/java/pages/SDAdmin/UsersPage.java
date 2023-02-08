package pages.SDAdmin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

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
		Assert.assertEquals($(createdUserEmailText).getText().trim(), CommonPage.uniqueEmailId);
	}	

}
