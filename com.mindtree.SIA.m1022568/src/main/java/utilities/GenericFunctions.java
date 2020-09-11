package utilities;

import org.openqa.selenium.By;

/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes methods like
 * 
 * 					RegistrationForm
 * 					flightBookingPage1
 * 					flightBookingPage2
 * 					flightBookingPage3
*/

public class GenericFunctions extends BaseUtils {

	public void RegistrationForm(String fname, String lname, String pNumber, String email, String address1,
			String address2, String city, String state, String country, String zip, String userName, String password) {

		textBoxValueFilling(getLocatorPath("First_Name"), fname);
		textBoxValueFilling(getLocatorPath("Last_Name"), lname);
		textBoxValueFilling(getLocatorPath("Phone"), pNumber);
		textBoxValueFilling(getLocatorPath("UserName"), email);
		textBoxValueFilling(getLocatorPath("Address1"), address1);
		textBoxValueFilling(getLocatorPath("Address2"), address2);
		textBoxValueFilling(getLocatorPath("City"), city);
		textBoxValueFilling(getLocatorPath("State"), state);
		textBoxValueFilling(getLocatorPath("Postal_Code"), zip);

		selectDropdown("Country", country);

		textBoxValueFilling(getLocatorPath("RegistrationForm.UserName"), userName);
		textBoxValueFilling(getLocatorPath("RegistrationForm.Password"), password);
		textBoxValueFilling(getLocatorPath("RegistrationForm.ConfirmPassword"), password);

	}

	public void flightBookingPage1(String passengers, String departFrom, String fromMonth, String fromDay,
			String arrivingIn, String returnigMonth, String returnigDay, String classPreference) {

		selectDropdown("Passengers", passengers);
		selectDropdown("Depart_From", departFrom);
		selectDropdown("OnMonth", fromMonth);
		selectDropdown("OnDay", fromDay);
		selectDropdown("Arriving_In", arrivingIn);
		selectDropdown("ReturnigMonth", returnigMonth);
		selectDropdown("ReturnigDay", returnigDay);

		if (classPreference.equalsIgnoreCase("Business")) {
			driver.findElement(By.xpath(getLocatorPath("ServiceClass_Business"))).click();
		} else if (classPreference.equalsIgnoreCase("Economy")) {
			driver.findElement(By.xpath(getLocatorPath("ServiceClass_Economy"))).click();
		} else if (classPreference.equalsIgnoreCase("First")) {
			driver.findElement(By.xpath(getLocatorPath("ServiceClass_First"))).click();
		} else {
			System.out.println("******** NO SUCH OPTION OF CLASS PREFERENCE *********");

		}

	}

	public void flightBookingPage2(String departAirline) {
		if (departAirline.equalsIgnoreCase("Unified Airlines 363")) {
			driver.findElement(By.xpath(getLocatorPath("UnifiedAirline"))).click();
		} else if (departAirline.equalsIgnoreCase("Blue Skies Airlines 360")) {
			driver.findElement(By.xpath(getLocatorPath("BlueSkyAirline1"))).click();
		} else if (departAirline.equalsIgnoreCase("Blue Skies Airlines 361")) {
			driver.findElement(By.xpath(getLocatorPath("BlueSkyAirline2"))).click();
		} else if (departAirline.equalsIgnoreCase("Pangaea Airlines 362")) {
			driver.findElement(By.xpath(getLocatorPath("PangaeaAirline"))).click();
		} else {
			System.out.println("******** NO SUCH OPTION OF Depart airline PREFERENCE *********");
		}

	}

	public void flightBookingPage3(String fname, String lname, String meal, String ccType, String ccNumber,
			String expireMonth, String expireYear, String mname, String address1, String address2, String city,
			String state, String country, String zipcode) {
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.First_Name"), fname);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.Last_Name"), lname);

		selectDropdown("FlightConfirmationPage3.Meal", meal);

		selectDropdown("FlightConfirmationPage3.CardType", ccType);

		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.CardNumber"), ccNumber);

		selectDropdown("FlightConfirmationPage3.CreditCardExpirationMonth", expireMonth);

		selectDropdown("FlightConfirmationPage3.CreditCardExpirationYear", expireYear);

		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.CreditCardFirstName"), fname);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.CreditCardMiddleName"), mname);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.CreditCardLastName"), lname);

		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.BillingAddress1"), address1);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.BillingAddress2"), address2);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.BillingAddressCity"), city);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.BillingAddressState"), state);
		textBoxValueFilling(getLocatorPath("FlightConfirmationPage3.BillingAddressZip"), zipcode);

		selectDropdown("FlightConfirmationPage3.BillingAddressCountry", country);

		driver.findElement(By.xpath(getLocatorPath("FlightConfirmationPage3.DeliveryAddress"))).click();

	}



}
