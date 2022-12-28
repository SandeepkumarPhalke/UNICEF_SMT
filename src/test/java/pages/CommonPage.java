package pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class CommonPage extends PageObject{

	public static String randomText;
	public static String uniqueRandomText;
	public static String randomNumber;
	public static String uniqueRandomNumber;
	
	@FindBy(xpath = "//span[text()='Data saved successfully']")
	WebElement createMessage;
	
	@FindBy(xpath = "//span[text()='Data updated successfully']")
	WebElement updateMessage;
	
	@FindBy(xpath = "//span[text()='Data deleted successfully']")
	WebElement deleteMessage;
	
	@Step
	public void closeBrowser() {
		
		getDriver().quit(); 
	}
	
	@Step
	public void clickOnTab(String tabName){

		String webElement = "//span[text()='"+tabName+"']";
		$(webElement).waitUntilClickable().click();
	}
	
	@Step
	public void clickOnButton(String buttonName) {
		
		String webElement = "//span[text()='"+buttonName+"']";
		$(webElement).waitUntilClickable().click();
	}
	
	@Step
	public void isHeadingVisible(String headingName) {
		
		String webElement = "//h2[text()='"+headingName+"']";
		Assert.assertTrue($(webElement).isVisible());
	}
	
	@Step
	public void enterRandomText(String textField) {

		String webElement = "//input[@name='"+textField+"']";
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		if(textField.equals("smtNumber")) {
			
			uniqueRandomText = generateRandomtext();
			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		}
		else if(textField.equals("batchNo")) {
			
			$(webElement).waitUntilEnabled().sendKeys(uniqueRandomText);
		}
		else{
			
			$(webElement).waitUntilEnabled().sendKeys(generateRandomtext());
		}
	}
	
	@Step
	public void enterRandomNumber(String textField) {

		String webElement = "//input[@name='"+textField+"']";
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		$(webElement).waitUntilEnabled().sendKeys(generateRandomNumber12Digits());
	}
	
	@Step
	public String generateRandomtext() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy hh mm ss");
		randomText = "AutoTest"+ sdf.format(date).replace(" ", "");
		return randomText;
	}
	
	@Step
	public String generateCalendarDate() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		return sdf.format(date);
	}
	
	@Step
	public String generateRandomNumber12Digits() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy hh mm ss");
		randomNumber = sdf.format(date).replace(" ", "");
		return randomNumber;
	}
	
	@Step
	public void textVisible(String text) {

		String webElement = "//span[text()='"+text+"']";
		Assert.assertTrue($(webElement).isDisplayed());
	}
	
	@Step
	public void createdMessageDisplayed() {
		
		Assert.assertTrue(createMessage.isDisplayed());
	}
	
	@Step
	public void updatedMessageDisplayed() {
		
		Assert.assertTrue(updateMessage.isDisplayed());
	}
	
	@Step
	public void deletedMessageDisplayed() {
		
		Assert.assertTrue(deleteMessage.isDisplayed());
	}
	
	@Step
	public void enterTextInTextbox(String text, String textboxName){

		String webElement = "//input[@name='"+textboxName+"']";
		$(webElement).sendKeys(Keys.CONTROL, "a");
		$(webElement).sendKeys(Keys.DELETE);
		$(webElement).sendKeys(text);
	}
	
	@Step
	public void textIsVisible(String text){

		String webElement = "//span[text()='"+text+"']";
		Assert.assertTrue($(webElement).isDisplayed());
	}

}
