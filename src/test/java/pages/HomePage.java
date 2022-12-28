package pages;

import org.junit.Assert;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class HomePage extends PageObject{
	
	@Step
	public void clickLoginButton() {
		
		$("//span[@class='MuiButton-label']").click();
	}
	
	@Step
	public void clickProceedToLoginButton(String language) {
		
		if(language.equals("English")){
			$("//button//span[text()='Proceed To Login']").click();
		}
		else if(language.equals("French")){
			$("//button//span[text()='Procéder à la connexion']").click();
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
		
		$("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']").waitUntilVisible().click();
		$("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li["+langId+"]").click();
	}
	
	@Step
	public void isCorrectHomePageTextExists(String homeText) {
		
		if(homeText.equals("Home")){
			Assert.assertTrue($("//span[text()='Home']").isDisplayed());
		}
		else if(homeText.equals("Accueil")){
			Assert.assertTrue($("//span[text()='Accueil']").isDisplayed());
		}
	}
		

}
