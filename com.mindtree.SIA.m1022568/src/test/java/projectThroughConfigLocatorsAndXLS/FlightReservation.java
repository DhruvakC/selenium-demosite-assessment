package projectThroughConfigLocatorsAndXLS;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtility;
import utilities.GenericFunctions;

/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes Test case to verify Flight reservation action.
 * 
 * 		
*/

public class FlightReservation extends GenericFunctions {

	Logger log = Logger.getLogger(FlightReservation.class);

	@DataProvider(name = "BookFlight", indices = 1)
	public static Object[][] BookFlights() throws Exception {

		Object[][] testObjArray = ExcelUtility.getExcelValue("src\\main\\java\\dataFiles\\dataProvider.xlsx",
				"FlightReservationData");
		return (testObjArray);

	}

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Flight Reservation Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));

	}

	@Test(dataProvider = "BookFlight")
	public void flightBooking(String passengers, String departFrom, String fromMonth, String fromDay, String arrivingIn,
			String returnigMonth, String returnigDay, String classPreference, String departAirline, String airlines,
			String fname, String lname, String meal, String ccNumber, String mname, String ccType, String expireMonth,
			String expireYear, String address1, String address2, String city, String state, String country,
			String zipcode) throws InterruptedException, IOException {

		log.info("Filling up username and password.");
		textBoxValueFilling(getLocatorPath("UserName"), getParameterValue("UserName"));
		textBoxValueFilling(getLocatorPath("Password"), getParameterValue("Password"));
		log.info("Filled up username and password.");

		log.info("Clicking on Sign-In Button.");
		buttonClick(getLocatorPath("Sign-In"));
		log.info("Sign-In Button clicked.");

		Thread.sleep(2000);

		log.info("Confirming flight details. First page of Flight reservation.");
		flightBookingPage1(passengers, departFrom, fromMonth, fromDay, arrivingIn, returnigMonth, returnigDay,
				classPreference);
		buttonClick(getLocatorPath("FlightConfirmationPage1"));
		log.info("Details are taken and routed user to next page.");

		Thread.sleep(2000);

		log.info("Confirming flights to fly.");
		flightBookingPage2(departAirline);
		buttonClick(getLocatorPath("FlightConfirmationPage2"));
		log.info("Clicked on Confirm flights.");

		Thread.sleep(2000);

		log.info("Filling up values of flyer/s to book ticket");
		flightBookingPage3(fname, lname, meal, ccType, ccNumber, expireMonth, expireYear, mname, address1, address2,
				city, state, country, zipcode);
		buttonClick(getLocatorPath("FlightConfirmationPage3.SecurePurchase"));
		log.info("Clicked on Purchase ticket.");

		Thread.sleep(2000);

		log.info("Verifying that user is able to book flight successfully or not.");
		// Verify that newly created user is able to book flight.
		Assert.assertEquals(doesTextExistsOnPage(getLocatorPath("FlightConfirmation")), true);
		log.info("Verified that user is able to book flight successfully.");

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();
		log.info("===============Flight Reservation Test Case Ends========================");
		log.info("");
	}

}
