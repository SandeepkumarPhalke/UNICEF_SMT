package pages;

import org.junit.Assert;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class UserHomePage extends PageObject{

	@Step
	public void validateHomePage() {
		
		Assert.assertTrue($("//span[text()='Export']").waitUntilDisabled().isDisplayed()); 
	}
}
