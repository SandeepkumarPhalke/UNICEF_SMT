package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class UserHomePage extends PageObject{

	@FindBy(xpath = "//div[@class='MuiTypography-root user-name-block MuiTypography-body1']//div[@class='MuiAvatar-root MuiAvatar-circle dd-big-avatar MuiAvatar-colorDefault'][1]")
	WebElement signedinUserNameLogo;
	
	@Step
	public void validateSignedinUserNameLogo() {
		
		Assert.assertTrue($(signedinUserNameLogo).isDisplayed()); 
	}
}
