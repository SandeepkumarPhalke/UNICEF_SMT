package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import freemarker.core.Environment;
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
	
	@Step
	public void validateHomePage(){
		Assert.assertEquals(getDriver().getTitle(), "SMT");
	}
	
	@Step
	public void enterEmail() {
		
		emailInput.sendKeys("coamilind@mailinator.com");
	}
	
	@Step
	public void enterPassword() {
		
		passwordInput.sendKeys("Test@123");
	}
	
	@Step
	public void clickSignInButton() {
		
		singInButton.click();
	}
	
	@Step
	public void signInButtonIsDisplayed() {
		
		Assert.assertTrue(singInButton.isDisplayed());
	}
	
	@Step
	public void enterEmail(String email) {
		
		$("//input[@type='email']").waitUntilVisible().sendKeys(email);
	}
	
	@Step
	public void enterPassword(String password) {
		
		$("//input[@type='password']").sendKeys(password);
	}
	
	@Step
	public void userLogin(String userType) {
		
		if(userType.equals("Store Operator")) {

			emailInput.sendKeys(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("storeOperatorEmail"));
		}
		
		passwordInput.sendKeys(CommonPage.decodeString(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("userPassword")));
		singInButton.click();
	}
}
