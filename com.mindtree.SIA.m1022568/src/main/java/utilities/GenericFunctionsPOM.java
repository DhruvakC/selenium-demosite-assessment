package utilities;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class GenericFunctionsPOM {

	public static void enterValueToTextBox(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to enter value to Textbox " + element);
		}
	}

	public static void clickButton(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to click button.");
		}
	}

	public static void selectItemFromDropDown(WebElement element, String textToBeselected) {
		try {
			Select se = new Select(element);
			se.selectByVisibleText(textToBeselected);
		} catch (Exception e) {
			Assert.assertTrue(false, "Unable to select exepected item from DropDown");
		}
	}

}
