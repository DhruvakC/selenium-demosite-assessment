package projectThroughPOM;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FlightBookingPage;
import pages.SignInPage;
import utilities.ExcelUtility;
import utilities.GenericFunctions;

public class FlightBooking extends GenericFunctions {

	Logger log = Logger.getLogger(SignIn.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Flight Booking Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}

	@DataProvider(name = "BookFlight", indices = 1)
	public static Object[][] BookFlights() throws Exception {

		Object[][] testObjArray = ExcelUtility.getExcelValue("src\\main\\java\\dataFiles\\dataProvider.xlsx",
				"FlightReservationData");
		return (testObjArray);

	}

	@Test(dataProvider = "BookFlight")
	public void flightBooking(String passengers, String departFrom, String fromMonth, String fromDay, String arrivingIn,
			String returnigMonth, String returnigDay, String classPreference, String departAirline, String airlines,
			String fname, String lname, String meal, String ccNumber, String mname, String ccType, String expireMonth,
			String expireYear, String address1, String address2, String city, String state, String country,
			String zipcode) throws InterruptedException, IOException {

		log.info("Filling up username, password and then clicking on Sign-In Button.");
		SignInPage signInObj = new SignInPage(driver);
		signInObj.signIn(getParameterValue("UserName"), getParameterValue("Password"));
		log.info("Username, password values are entered and then Sign-In button clicked.");

		FlightBookingPage flightBookingObj = new FlightBookingPage(driver);

		flightBookingObj.flightBooking(passengers, departFrom, fromMonth, fromDay, arrivingIn, returnigMonth,
				returnigDay, classPreference, departAirline, airlines, fname, lname, meal, ccNumber, mname, ccType,
				expireMonth, expireYear, address1, address2, city, state, country, zipcode);

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

		log.info("Verifying that user is able to book flight successfully or not.");
		Assert.assertEquals(doesTextExistsOnPage(getLocatorPath("FlightConfirmation")), true);
		log.info("Verified that user is able to book flight successfully.");

	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();

		log.info("================Flight Booking Test Case Ends=======================");
		log.info("");
	}
}
