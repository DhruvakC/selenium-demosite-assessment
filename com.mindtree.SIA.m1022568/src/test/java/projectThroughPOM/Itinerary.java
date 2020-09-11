package projectThroughPOM;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ItineraryPage;
import pages.SignInPage;
import utilities.GenericFunctions;

public class Itinerary extends GenericFunctions {

	Logger log = Logger.getLogger(Itinerary.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Itinerary Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}

	@Test
	public void itinerary() throws InterruptedException, IOException {

		log.info("Filling up username, password and then clicking on Sign-In Button.");
		SignInPage signInObj = new SignInPage(driver);
		signInObj.signIn(getParameterValue("UserName"), getParameterValue("Password"));
		log.info("Username, password values are entered and then Sign-In button clicked.");

		ItineraryPage itineraryObj = new ItineraryPage(driver);
		itineraryObj.itinerary1();

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");
		
		itineraryObj.itinerary2();

		try {
			log.info("Verifying that after cancellation of ticket user is landed to Home page.");
			Assert.assertEquals(driver.getTitle(), getParameterValue("WelcomePage"));
			// Assert.assertEquals(doesTextExistsOnPage(FlightConfirmationPage), true);
			log.info("Verifed that after cancellation of ticket user is landed to Home page.");

		} catch (Exception e) {
			System.out.println(e.toString());
			log.info("Cant verify that user is on home page. Something went wrong.");
		}

	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();

		log.info("================Itinerary Test Case Ends=======================");
		log.info("");
	}

}
