package sampleProjectThroughJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pages.RegistrationPage;
import projectThroughPOM.SignIn;
import utilities.GenericFunctions;
import org.apache.log4j.Logger;

public class E_RegistrationTestCase_POM_JSON2 extends GenericFunctions {

	Logger log = Logger.getLogger(E_RegistrationTestCase_POM_JSON2.class);
	
	@BeforeTest
	public void openChromeAppURLmethod() throws InterruptedException, JsonIOException, JsonSyntaxException, FileNotFoundException {
			
		String websiteName = getContentAsJsonObject("website");
		String browserName = getContentAsJsonObject("browser");

		launchApp(websiteName, browserName);
	}
	
	@Test
	public void registration_Method() throws JsonIOException, JsonSyntaxException, InterruptedException, IOException {
		
		RegistrationPage regObj = new RegistrationPage(driver);
		log.info("Clicking on registration link and entering details of users");
		
		//System.out.println("\n Value of firstname variable is " +getContentAsJsonObject("registration","firstname"));
		regObj.registration_Method(getContentAsJsonObject("registration","firstname"),getContentAsJsonObject("registration","lastname"),
				getContentAsJsonObject("registration","phone"),getContentAsJsonObject("registration","Email"),
				getContentAsJsonObject("registration","address1"),getContentAsJsonObject("registration","address2"),
				getContentAsJsonObject("registration","address1"),getContentAsJsonObject("registration","state"),
				getContentAsJsonObject("registration","zip"),getContentAsJsonObject("registration","country"),
				getContentAsJsonObject("registration","username"),getContentAsJsonObject("registration","password"));

		
		log.info("Registration details entered.");

		log.info("Taking screenshot.");
		takeScreenshot(this.getClass().getSimpleName());
		log.info(
				"Screenshot taken and placed under D:\\Selenium\\SeleniumInternalAssessment\\Screenshots\\ folder.");

		log.info("Verifying that user is on registration page or not.");
		Assert.assertEquals(doesTextExistsOnPage(getLocatorPath("RegistrationForm.Confirmation")), true);
		log.info("Verified that user is registered successfully.");
		
  }
	
	@AfterTest
	public void close() {
		closeApp();
	}
}
