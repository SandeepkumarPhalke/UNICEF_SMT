package pages.StoreOperator;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.CommonPage;

public class StockOverviewPage extends PageObject {

	@FindBy(xpath = "//input[@type='radio']")
	WebElement productsRadioButton;
	
	@FindBy(xpath = "//span[text()='Select the product to see additional details']")
	WebElement productDetailsText;
	
	@FindBy(xpath = "//span[text()='Batch-wise details for the selected product']")
	WebElement batchWiseDetailsText;
	
	@FindBy(xpath = "//input[@type='radio']//following::tbody[@class=\"MuiTableBody-root\"]//tr[2]//td[1]")
	WebElement productDetailText;

	@Step
	public void validateStockOverviewLandingPage() {

		Assert.assertTrue($(productDetailsText).isVisible());
		Assert.assertTrue($(batchWiseDetailsText).isVisible());
	}

	@Step
	public void selectAndValidateProducts() {

		List<WebElement> productRadioButtons = getDriver().findElements(By.xpath("//input[@type='radio']"));
		for(WebElement productRadioButton : productRadioButtons) {
			
			productRadioButton.click();
			
			Assert.assertTrue($(productDetailText).waitUntilVisible().isVisible());
		}
	}
}
