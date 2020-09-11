package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericFunctionsPOM;

public class ItineraryPage extends GenericFunctionsPOM {

	public WebDriver driver;

	public ItineraryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Itinerary link locator
	@FindBy(linkText = "ITINERARY")
	public WebElement itineraryWE;

	// Cancel reservation locator
	@FindBy(xpath = "//*[contains(@coords,'38,325,471,364')]")
	public WebElement cancelReservations;

	public void itinerary1() {

		clickButton(itineraryWE);

	}
	public void itinerary2() throws InterruptedException {

		clickButton(cancelReservations);
		Thread.sleep(3000);

	}

}
