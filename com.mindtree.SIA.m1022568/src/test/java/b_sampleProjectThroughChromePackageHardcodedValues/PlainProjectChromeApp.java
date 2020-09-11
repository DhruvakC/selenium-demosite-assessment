package b_sampleProjectThroughChromePackageHardcodedValues;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.GenericFunctions;

public class PlainProjectChromeApp extends GenericFunctions {


	// Before test method to launch browser.
	//@Test(priority = 0)
	@BeforeTest()
	public void openChromeAppURLmethod() throws InterruptedException {
		launchApp("http://demo.guru99.com/test/newtours/", "Chrome");

	}

	// Method to launch Firefox browser. Disabled at the moment.
	@Test(priority = 1, enabled = false)
	public void openFirefoxAppURLmethod() throws InterruptedException {
		launchApp("http://demo.guru99.com/test/newtours/", "Firefox");
		Thread.sleep(3000);
	}

	// Test case # 1 to Register New User.
	@Test(priority = 2) 
	public void registerNewUser () {

		String registrationConfirmation = "//*[contains(text(),'Thank you')]";

		
		buttonClick("//*[contains(text(),'REGISTER')]");
		textBoxValueFilling("//*[contains(@name,'email')]", "Dhruvak1");
		textBoxValueFilling("//*[contains(@name,'password')]", "Admin12!@");
		textBoxValueFilling("//*[contains(@name,'confirmPassword')]", "Admin12!@");
		buttonClick("//input[@name='submit']");
		
		//Verify that user registered correctly or not.
		Assert.assertEquals(doesTextExistsOnPage(registrationConfirmation), true);
		
		buttonClick("//*[contains(text(),'Home')]");

	}

	// Test case # 2 to Login with newly created User.
	@Test(priority = 3)
	public void loginWithNewlyCreatedUser() throws InterruptedException {
		textBoxValueFilling("//*[contains(@name,'userName')]", "Dhruvak1");
		textBoxValueFilling("//*[contains(@name,'password')]", "Admin12!@");

		buttonClick("//*[contains(@name,'login')]");
		Thread.sleep(3000);
	}

	// Test case # 3 to Book flight tickets.
	@Test(dependsOnMethods = "loginWithNewlyCreatedUser", priority = 4)
	public void flightBooking() throws InterruptedException {
		
		String flighConfirmationLocator = "//*[contains(text(),'Flight Confirmation')]";
		
		buttonClick("//*[contains(@name,'findFlights')]");
		Thread.sleep(2000);

		buttonClick("//*[contains(@name,'reserveFlights')]");
		Thread.sleep(2000);

		textBoxValueFilling("//*[contains(@name,'passFirst0')]", "Dhruvak");
		Thread.sleep(2000);
		textBoxValueFilling("//*[contains(@name,'passLast0')]", "Chokshi");
		textBoxValueFilling("//*[contains(@name,'creditnumber')]", "1234");
		Thread.sleep(2000);
		buttonClick("//*[contains(@name,'buyFlights')]");

		Thread.sleep(2000);

		//Verify that newly created user is able to book flight.
		Assert.assertEquals(doesTextExistsOnPage(flighConfirmationLocator), true);

	}

	// Test case # 4 to LogOut from site.
	@Test(dependsOnMethods = "loginWithNewlyCreatedUser", priority = 5)
	public void logout() throws InterruptedException {
		buttonClick("//*[contains(text(),'SIGN-OFF')]");
		Thread.sleep(3000);
	}

	//After Test close the browser.
	@AfterTest
	public void close() {
		closeApp();
	}

}
