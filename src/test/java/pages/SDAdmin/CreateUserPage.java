package pages.SDAdmin;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class CreateUserPage extends PageObject{

	@FindBy(xpath = "//span[contains(text(),'+')]//parent::button")
	WebElement addRoleButton;
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@name='userEmail']")
	WebElement userEmailInput;

	@Step
	public void validateCreateUserPage() {
		
		Assert.assertTrue(addRoleButton.isDisplayed());
	}
	
	@Step
	public void selectValueFromDropdown_Users(String value, String dropdownName) {

		String webElementId = null;
		if (dropdownName.equals("Role")) {
			webElementId = "userRegion[0].role";
		}
		
		$("//div[@id='" + webElementId + "']").waitUntilClickable().click();
		$("//li//span[text()='" + value + "']").waitUntilClickable().click();
	}

}
