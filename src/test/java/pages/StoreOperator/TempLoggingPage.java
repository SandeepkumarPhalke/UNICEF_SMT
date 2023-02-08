package pages.StoreOperator;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

public class TempLoggingPage extends PageObject {

	@FindBy(xpath = "//tbody[1]//tr[1]//td[15]//button[@title='Edit']")
	WebElement editTempLoggingOfEquipment;

	@FindBy(xpath = "//tbody[1]//tr[1]//td[15]//button[@title='Save']")
	WebElement saveTempLoggingOfEquipment;

	@FindBy(xpath = "//tbody[1]//tr[1]//td[15]//button[@title='Cancel']")
	WebElement cancelTempLoggingOfEquipment;

	@Step
	public void clickOnEditTemperatureButton(String buttonName) {

		$(editTempLoggingOfEquipment).waitUntilClickable().click();
	}

	@Step
	public void clickOnSaveTemperatureButton(String buttonName) {

		$(saveTempLoggingOfEquipment).waitUntilClickable().click();
	}

	@Step
	public void clickOnCancelTemperatureButton(String buttonName) {

		$(cancelTempLoggingOfEquipment).waitUntilClickable().click();
	}

	@Step
	public void enterValidDetailsInTable() {

		String webElement = null;
		int min = 2;
		int max = 20;
		int b = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 2; j <= 13; j++) {
				if (i == 0) {

					webElement = "//table[@aria-label='caption table']//tbody//tr//td[text()='" + CommonPage.randomText
							+ "']//following::td[" + j + "]//input";
					b = (int) ((Math.random() * (max - min + 1) + min) * -1);
				} else {

					webElement = "//table[@aria-label='caption table']//tbody//tr//td[text()='" + CommonPage.randomText
							+ "']//parent::tr//following::tr[" + i + "]//td[" + j + "]//input";
					b = (int) (Math.random() * (max - min + 1) + min);
				}

				while (($(webElement).getValue()).length() != 0) {

					$(webElement).sendKeys(Keys.BACK_SPACE);
				}

				$(webElement).sendKeys(Integer.toString(b));
			}
		}
	}

	@Step
	public void validateDetailsInTable() {

		String webElement = null;
		for (int i = 0; i <= 3; i++) {
			for (int j = 2; j <= 13; j++) {
				if (i == 0) {

					webElement = "//table[@aria-label='caption table']//tbody//tr//td[text()='" + CommonPage.randomText
							+ "']//following::td[" + j + "]";
				} else {

					webElement = "//table[@aria-label='caption table']//tbody//tr//td[text()='" + CommonPage.randomText
							+ "']//parent::tr//following::tr[" + i + "]//td[" + j + "]";
				}
				Assert.assertNotEquals($(webElement).getText(), " ");
			}
		}
	}
}