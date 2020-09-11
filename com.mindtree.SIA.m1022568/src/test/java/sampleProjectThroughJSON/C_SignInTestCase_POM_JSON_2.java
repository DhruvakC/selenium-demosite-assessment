package sampleProjectThroughJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pages.SignInPage;
import projectThroughPOM.SignIn;
import utilities.GenericFunctions;

public class C_SignInTestCase_POM_JSON_2 extends GenericFunctions {
	Logger log = Logger.getLogger(C_SignInTestCase_POM_JSON_2.class);
	JsonParser parser = new JsonParser();	
	
	@BeforeTest
	public void openChromeAppURLmethod() throws InterruptedException, JsonIOException, JsonSyntaxException, FileNotFoundException {
			
		String websiteName = getContentAsJsonObject("website");
		String browserName = getContentAsJsonObject("browser");

		launchApp(websiteName, browserName);
	}
	
	@Test
	public void signIn() throws InterruptedException, IOException {

		log.info("Filling up username, password and then clicking on Sign-In Button.");
		SignInPage signInObj = new SignInPage(driver);

		String userName = getContentAsJsonObject("username");
		String password = getContentAsJsonObject("password");
		
		signInObj.signIn(userName,password);
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
	
	//After Test close the browser.
	//@Test (priority = 1)
	@AfterTest
	public void close() {
		closeApp();
	}
}
