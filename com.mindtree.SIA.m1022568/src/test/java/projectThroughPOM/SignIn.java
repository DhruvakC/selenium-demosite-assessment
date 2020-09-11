package projectThroughPOM;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.SignInPage;

import utilities.GenericFunctions;

public class SignIn extends GenericFunctions{

	Logger log = Logger.getLogger(SignIn.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Sign In Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}
	
	@Test
	public void signIn() throws InterruptedException, IOException {

		log.info("Filling up username, password and then clicking on Sign-In Button.");
		SignInPage signInObj = new SignInPage(driver);
		signInObj.signIn(getParameterValue("UserName"), getParameterValue("Password"));
		log.info("Username, password values are entered and then Sign-In button clicked.");		
		
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
