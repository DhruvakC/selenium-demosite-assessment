package sampleProjectThroughXMLValues;

import org.testng.annotations.Test;

import utilities.GenericFunctions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ValuesFromXMLFile  extends GenericFunctions  {
 
	// Before test method to launch browser.
	// It is included in both groups.
	@Parameters({ "browser" })
	@BeforeTest (groups={"LogInTestCases"})
	public void openChromeAppURLmethod(String browser) throws InterruptedException {
		System.out.println("browser passed as :- " + browser);
		launchApp("http://newtours.demoaut.com/", browser);
		Thread.sleep(2000);

	}

	// Login with newly created User.
	// It is part of LogInTestCases group
	@Parameters({ "username", "password" })
	@Test (groups={"LogInTestCases"}, priority = 1)
	public void loginWithNewlyCreatedUser(String username, String password) throws InterruptedException {
		textBoxValueFilling("//*[contains(@name,'userName')]", username);
		textBoxValueFilling("//*[contains(@name,'password')]", password);

		buttonClick("//*[contains(@name,'login')]");
		Thread.sleep(3000);

	}
		
	@Test(dependsOnMethods = "loginWithNewlyCreatedUser", groups={"LogInTestCases"}, priority = 2 )
	public void logout() throws InterruptedException {
		buttonClick("//*[contains(text(),'SIGN-OFF')]");
		Thread.sleep(3000);
	}

	// Register New User.
	// It is part of RegisterTestCases group
	@Parameters({ "username", "password" })
	@Test(groups={"RegisterTestCases"},priority = 2) 
	public void registerNewUser (String username, String password) {

		String registrationConfirmation = "//*[contains(text(),'Thank you')]";

		
		buttonClick("//*[contains(text(),'REGISTER')]");
		textBoxValueFilling("//*[contains(@name,'email')]", "username");
		textBoxValueFilling("//*[contains(@name,'password')]", "password");
		textBoxValueFilling("//*[contains(@name,'confirmPassword')]", "password");
		buttonClick("//*[contains(@name,'register')]");
		
		//Verify that user registered correctly or not.
		Assert.assertEquals(doesTextExistsOnPage(registrationConfirmation), true);
		
		buttonClick("//*[contains(text(),'Home')]");

	}

	// After test method to close browser.
	// It is included in both groups.
	@AfterTest(groups={"LogInTestCases", "RegisterTestCases"})
	public void afterTest() {
		closeApp();
	}

}
