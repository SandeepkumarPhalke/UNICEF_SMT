package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class HomePage extends PageObject{
	
	@FindBy(xpath = "//span[@class='MuiButton-label']")
	WebElement loginButton;
	
	@FindBy(xpath = "//button//span[text()='Proceed To Login']")
	WebElement proceedToLoginButton;
	
	@FindBy(xpath = "//button//span[text()='Procéder à la connexion']")
	WebElement proceedToLoginButton_FR;
	
	@FindBy(xpath = "//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']")
	WebElement languageChangeDropdown;
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeText;
	
	@FindBy(xpath = "//span[text()='Accueil']")
	WebElement homeText_FR;
	
	@Step
	public void clickLoginButton() {
		
		$(loginButton).click();
	}
	
	@Step
	public void clickProceedToLoginButton(String language) {
		
		if(language.equals("English")){
			$(proceedToLoginButton).click();
		}
		else if(language.equals("French")){
			$(proceedToLoginButton_FR).click();
		}
	}
	
	@Step
	public void changeLanguage(String language) {
		
		String langId = "";
		if(language.equals("English")){
			langId="1";
		}
		else if(language.equals("French")){
			langId="2";
		}
		
		$(languageChangeDropdown).waitUntilVisible().click();
		$("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li["+langId+"]").click();
	}
	
	@Step
	public void validateHomePageTextExists(String homeTextSpelling) {
		
		if(homeTextSpelling.equals("Home")){
			Assert.assertTrue($(homeText).isDisplayed());
		}
		else if(homeTextSpelling.equals("Accueil")){
			Assert.assertTrue($(homeText_FR).isDisplayed());
		}
	}
	
	@Step
	public void validateLoginButtonOnHomePage(){
		Assert.assertTrue($(loginButton).isDisplayed());
	}
}
