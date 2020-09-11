package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericFunctionsPOM;

public class FlightBookingPage extends GenericFunctionsPOM {

	public WebDriver driver;

	public FlightBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// One Way locator
	@FindBy(xpath = "(//input[@name='tripType'])[2]")
	public WebElement onewayRadioButton;

	// Passenger Count locator
	@FindBy(name = "passCount")
	public WebElement numberOfPassengers;

	// Depart From locator
	@FindBy(name = "fromPort")
	public WebElement departfrom;

	// Depart From Month locator
	@FindBy(name = "fromMonth")
	public WebElement fromMonthWE;

	// Depart From Day locator
	@FindBy(name = "fromDay")
	public WebElement fromDayWE;

	// Arriving in Place locator
	@FindBy(name = "toPort")
	public WebElement arrivingInWE;

	// Arriving in Month locator
	@FindBy(name = "toMonth")
	public WebElement returnigMonthWE;

	// Arriving in Day locator
	@FindBy(name = "toDay")
	public WebElement returnigDayWE;

	// Service Class locator
	@FindBy(xpath = "//input[@name='servClass']")
	public WebElement economyclass_rdobtn;

	// Business Class radio button locator
	@FindBy(xpath = "//*[contains(@value,'Business')]")
	public WebElement ServiceClass_Business;

	// First Class radio button locator
	@FindBy(xpath = "//*[contains(@value,'First')]")
	public WebElement ServiceClass_First;

	// Economy Class radio button locator
	@FindBy(xpath = "//*[contains(@value,'Economy')]")
	public WebElement ServiceClass_Economy;

	// Continue button locator
	@FindBy(xpath = "//input[@name='findFlights']")
	public WebElement ContinueButtonWE;

	// Blue Skies Airlines 360 radio button locator
	@FindBy(xpath = "//*[contains(@value,'Blue Skies Airlines$360')]")
	public WebElement BlueSkiesAirlines360WE;

	// Blue Skies Airlines 361 radio button locator
	@FindBy(xpath = "//*[contains(@value,'Blue Skies Airlines$361')]")
	public WebElement BlueSkiesAirlines361WE;

	// Pangaea Airlines 362 radio button locator
	@FindBy(xpath = "//*[contains(@value,'Pangaea Airlines$362')]")
	public WebElement PangaeaAirlines362WE;

	// Unified Airlines 363 radio button locator
	@FindBy(xpath = "//*[contains(@value,'Unified Airlines$363')]")
	public WebElement UnifiedAirlines363WE;

	// Reserve flights locator
	@FindBy(name = "reserveFlights")
	public WebElement reserveFlightWE;

	// Passengers first name locator
	@FindBy(name = "passFirst0")
	public WebElement passFirstName;

	// Passengers last name locator
	@FindBy(name = "passLast0")
	public WebElement passLastName;

	// Passengers meal preference locator
	@FindBy(name = "pass.0.meal")
	public WebElement firstPassengerMeal;

	// Passengers credit card type locator
	@FindBy(name = "creditCard")
	public WebElement creditCardType;

	// Passengers credit card number locator
	@FindBy(name = "creditnumber")
	public WebElement creditCardNumber;

	// Passengers credit card expiration month locator
	@FindBy(name = "cc_exp_dt_mn")
	public WebElement creditCardExpiryMonth;

	// Passengers credit card expiration year locator
	@FindBy(name = "cc_exp_dt_yr")
	public WebElement creditCardExpiryYear;

	// Passengers credit card first name locator
	@FindBy(name = "cc_frst_name")
	public WebElement creditCardFirstName;

	// Passengers credit card mid name locator
	@FindBy(name = "cc_mid_name")
	public WebElement creditCardMiddleName;

	// Passengers credit card last name locator
	@FindBy(name = "cc_last_name")
	public WebElement creditCardLastName;

	// Passengers credit card billing address line 1 locator
	@FindBy(name = "billAddress1")
	public WebElement billingAddress1;

	// Passengers credit card billing address line 2 locator
	@FindBy(name = "billAddress2")
	public WebElement billingAddress2;

	// Passengers credit card billing address city locator
	@FindBy(name = "billCity")
	public WebElement billingAddressCity;

	// Passengers credit card billing address state locator
	@FindBy(name = "billState")
	public WebElement billingAddressState;

	// Passengers credit card billing address zip locator
	@FindBy(name = "billZip")
	public WebElement billingAddressZipCode;

	// Passengers credit card billing address country locator
	@FindBy(name = "billCountry")
	public WebElement billingAddressCountry;

	@FindBy(xpath = "//font[contains(text(),'Same as Billing Address')]/preceding-sibling::input")
	public WebElement deliveryAddressCheckboxWE;

	@FindBy(name = "buyFlights")
	public WebElement securePurchaseWE;

	public void flightBooking(String passengers, String departFrom, String fromMonth, String fromDay, String arrivingIn,
			String returnigMonth, String returnigDay, String classPreference, String departAirline, String airlines,
			String fname, String lname, String meal, String ccNumber, String mname, String ccType, String expireMonth,
			String expireYear, String address1, String address2, String city, String state, String country,
			String zipcode) throws InterruptedException {

		selectItemFromDropDown(numberOfPassengers, passengers);
		selectItemFromDropDown(departfrom, departFrom);
		selectItemFromDropDown(fromMonthWE, fromMonth);
		selectItemFromDropDown(fromDayWE, fromDay);
		selectItemFromDropDown(arrivingInWE, arrivingIn);
		selectItemFromDropDown(returnigMonthWE, returnigMonth);
		selectItemFromDropDown(returnigDayWE, returnigDay);
		// selectItemFromDropDown(numberOfPassengers, classPreference);

		if (classPreference.equalsIgnoreCase("Business")) {
			ServiceClass_Business.click();
		} else if (classPreference.equalsIgnoreCase("Economy")) {
			ServiceClass_Economy.click();
		} else if (classPreference.equalsIgnoreCase("First")) {
			ServiceClass_First.click();
		} else {
			System.out.println("******** NO SUCH OPTION OF CLASS PREFERENCE *********");
		}

		Thread.sleep(3000);
		clickButton(ContinueButtonWE);

		if (departAirline.equalsIgnoreCase("Blue Skies Airlines 360")) {
			BlueSkiesAirlines360WE.click();
		} else if (departAirline.equalsIgnoreCase("Blue Skies Airlines 361")) {
			BlueSkiesAirlines361WE.click();
		} else if (departAirline.equalsIgnoreCase("Unified Airlines 363")) {
			UnifiedAirlines363WE.click();
		} else if (departAirline.equalsIgnoreCase("Pangaea Airlines 362")) {
			PangaeaAirlines362WE.click();
		} else {
			System.out.println("******** NO SUCH OPTION OF CLASS PREFERENCE *********");
		}

		Thread.sleep(3000);
		clickButton(reserveFlightWE);

		enterValueToTextBox(passFirstName, fname);
		enterValueToTextBox(passLastName, lname);
		selectItemFromDropDown(firstPassengerMeal, meal);
		selectItemFromDropDown(creditCardType, ccType);
		enterValueToTextBox(creditCardNumber, ccNumber);
		selectItemFromDropDown(creditCardExpiryMonth, expireMonth);
		selectItemFromDropDown(creditCardExpiryYear, expireYear);
		enterValueToTextBox(creditCardFirstName, fname);
		enterValueToTextBox(creditCardLastName, lname);
		enterValueToTextBox(creditCardMiddleName, mname);
		enterValueToTextBox(billingAddress1, address1);
		enterValueToTextBox(billingAddress2, address2);
		enterValueToTextBox(billingAddressCity, city);
		enterValueToTextBox(billingAddressState, state);
		enterValueToTextBox(billingAddressZipCode, zipcode);
		selectItemFromDropDown(billingAddressCountry, country);
		deliveryAddressCheckboxWE.click();
		
		Thread.sleep(3000);
		clickButton(securePurchaseWE);
		Thread.sleep(3000);

	}

}
