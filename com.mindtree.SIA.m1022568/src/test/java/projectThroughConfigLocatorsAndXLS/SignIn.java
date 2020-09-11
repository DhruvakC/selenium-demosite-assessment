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
 * Description: 	This class includes Test case to verify user sign in.
 * 
 * 		
*/

public class SignIn extends GenericFunctions {

	Logger log = Logger.getLogger(SignIn.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Sign In Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}

	@Test
	public void signInMethod() throws IOException, InterruptedException {

		log.info("Filling up username and password.");
		textBoxValueFilling(getLocatorPath("UserName"), getParameterValue("UserName"));
		textBoxValueFilling(getLocatorPath("Password"), getParameterValue("Password"));
		log.info("Filled up username and password.");

		log.info("Clicking on Sign-In Button.");
		buttonClick(getLocatorPath("Sign-In"));
		log.info("Sign-In Button clicked.");

		Thread.sleep(2000);

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

		try {
			log.info("Verifying that user is signed in successfully or not.");
			Assert.assertEquals(driver.getTitle(), getParameterValue("FlightConfirmationPage"));
			log.info("Verified that user is signed in successfully.");
		} catch (Exception e) {
			System.out.println(e.toString());
			log.info("User is not on signed in page. Something went wrong.");
		}
	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();
		
		log.info("================Sign In Test Case Ends=======================");
		log.info("");
	}

}
