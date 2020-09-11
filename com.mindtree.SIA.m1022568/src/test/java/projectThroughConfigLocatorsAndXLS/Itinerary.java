package projectThroughConfigLocatorsAndXLS;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GenericFunctions;

/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes Test case to verify itinerary action.
 * 
 * 		
*/

public class Itinerary extends GenericFunctions {

	Logger log = Logger.getLogger(Itinerary.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Itinerary Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));

	}

	@Test
	public void cancelTicket() throws InterruptedException, IOException {

		log.info("Filling up username and password.");
		textBoxValueFilling(getLocatorPath("UserName"), getParameterValue("UserName"));
		textBoxValueFilling(getLocatorPath("Password"), getParameterValue("Password"));
		log.info("Filled up username and password.");

		log.info("Clicking on Sign-In Button.");
		buttonClick(getLocatorPath("Sign-In"));
		log.info("Sign-In Button clicked.");

		Thread.sleep(2000);

		log.info("Clicking on ITINERARY button.");
		buttonClick(getLocatorPath("ITINERARY"));
		log.info("Clicked ITINERARY button.");

		Thread.sleep(2000);

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

		log.info("Clicking on cancel button to cancel ticket.");
		buttonClick(getLocatorPath("ITINERARY.Cancel"));
		log.info("Clicked on cancel button to cancel ticket.");

		Thread.sleep(2000);

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

		log.info("===============Itinerary Test Case Ends========================");
		log.info("");
	}

}
