package projectThroughConfigLocatorsAndXLS;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtility;
//import Utilities.ExcelUtils;
import utilities.GenericFunctions;


/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes Test case to verify Registration action.
 * 
 * 		
*/

public class Registration extends GenericFunctions {

	Logger log = Logger.getLogger(Registration.class);

	@DataProvider(name = "Registration", indices = 1)
	public static Object[][] Registrations() throws Exception {

		Object[][] testObjArray = ExcelUtility.getExcelValue("src\\main\\java\\dataFiles\\dataProvider.xlsx",
				"RegistrationData");
		return (testObjArray);

	}

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {
		log.info("================Registration Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}

	@Test(dataProvider = "Registration")
	public void registrationMethod(String fname, String lname, String pNumber, String email, String address1,
			String address2, String city, String state, String country, String zip, String userName, String password)
			throws InterruptedException, IOException {

		log.info("Clicking on Register button.");
		buttonClick(getLocatorPath("REGISTER"));
		log.info("Clicked on Register button.");

		log.info("Taking user inputs for registration.");
		RegistrationForm(fname, lname, pNumber, email, address1, address2, city, state, country, zip, userName,
				password);
		buttonClick(getLocatorPath("RegistrationForm.SUBMIT"));
		log.info("User filled up all the information necessary for registration.");

		Thread.sleep(2000);

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info("Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

		log.info("Verifying that user is on registration page or not.");
		Assert.assertEquals(doesTextExistsOnPage(getLocatorPath("RegistrationForm.Confirmation")), true);

		log.info("Verified that user is registered successfully.");
	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();

		log.info("================Registration Test Case Ends=======================");
		log.info("");

	}

}
