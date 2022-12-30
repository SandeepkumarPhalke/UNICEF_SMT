package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class SignInPage extends PageObject{
	
	private EnvironmentVariables environmentVariables;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//button[@id='next']")
	WebElement singInButton;
	
	@FindBy(xpath = "//div[@class='error pageLevel']//p")
	WebElement loginErrorMessageText;
	
	@Step
	public void enterEmail(String email) {
		
		emailInput.sendKeys(email);
	}
	
	@Step
	public void enterPassword() {
		
		passwordInput.sendKeys(CommonPage.decodeString(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("userPassword")));
	}
	
	@Step
	public void clickSignInButton() {
		
		singInButton.click();
	}

	@Step
	public void userLogin(String userRole) {
		
		if(userRole.equals("Store Operator")) {

			emailInput.sendKeys(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("storeOperatorEmail"));
		}else if(userRole.equals("SD Admin")) {

			emailInput.sendKeys(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("sdAdminEmail"));
		}
		
		passwordInput.sendKeys(CommonPage.decodeString(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("userPassword")));
		singInButton.click();
	}
	
	@Step
	public void validateSignInButtonOnHomePage(){
		Assert.assertTrue($(singInButton).isDisplayed());
	}
	
	@Step
	public void validateLoginErrorMessageText(){
		Assert.assertTrue($(loginErrorMessageText).isDisplayed());
	}
}
