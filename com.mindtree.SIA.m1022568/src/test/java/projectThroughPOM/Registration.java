package projectThroughPOM;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import utilities.ExcelUtility;
import utilities.GenericFunctions;

public class Registration extends GenericFunctions {

	Logger log = Logger.getLogger(Registration.class);

	@BeforeMethod
	public void startWithTestCase() throws InterruptedException {

		log.info("===============Registration Test Case Start========================");
		launchApp(getParameterValue("URL"), getParameterValue("Browser"));
	}

	@DataProvider(name = "Registration", indices = 1)
	public static Object[][] Registrations() throws Exception {

		Object[][] testObjArray = ExcelUtility.getExcelValue("src\\main\\java\\dataFiles\\dataProvider.xlsx",
				"RegistrationData");
		return (testObjArray);

	}

	@Test(dataProvider = "Registration")
	public void registration(String fname, String lname, String pNumber, String email, String address1, String address2,
			String city, String state, String country, String zip, String userName, String password)
			throws InterruptedException, IOException {

		int i = 1;

		for (i = 1; i <= Integer.parseInt(getParameterValue("No_Of_Users")); i++) {
			// System.out.println("i is " + i);

			RegistrationPage regObj = new RegistrationPage(driver);

			log.info("Clicking on registration link and entering details of users");
/*			regObj.registration_Method(fname, lname, pNumber, email, address1, address2, city, state, zip, country,
					userName, password);*/
			regObj.registration_Method(getParameterValue("MultiUserFirstName")+i, getParameterValue("MultiUserLastName")+i, 
					pNumber, getParameterValue("MultiUserEmailAddress")+i+"@gmail.com", address1, address2, city, state, zip, country,
					getParameterValue("MultiUserFirstName")+ i, getParameterValue("Password"));
			log.info("Registration details entered.");

			log.info("Taking screenshot.");
			takeScreenshot(this.getClass().getSimpleName());
			log.info(
					"Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

			log.info("Verifying that user is on registration page or not.");
			Assert.assertEquals(doesTextExistsOnPage(getLocatorPath("RegistrationForm.Confirmation")), true);
			log.info("Verified that user is registered successfully.");
		}

	}

	@AfterMethod
	public void endWithTestCase() {
		closeApp();

		log.info("================Registration Test Case Ends=======================");
		log.info("");
	}

}
