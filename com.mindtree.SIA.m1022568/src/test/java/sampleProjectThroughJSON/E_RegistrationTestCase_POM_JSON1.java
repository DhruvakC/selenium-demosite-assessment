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

public class E_RegistrationTestCase_POM_JSON1 extends GenericFunctions {

	Logger log = Logger.getLogger(E_RegistrationTestCase_POM_JSON1.class);
	
	@BeforeTest
	public void openChromeAppURLmethod() throws InterruptedException, JsonIOException, JsonSyntaxException, FileNotFoundException {
			
		String websiteName = getContentAsJsonObject("website");
		String browserName = getContentAsJsonObject("browser");

		launchApp(websiteName, browserName);
	}
	
	@Test
  public void registration_Method() throws JsonIOException, JsonSyntaxException, InterruptedException, IOException {
		//try {
			JsonParser parser = new JsonParser();
			Object fileObj = parser.parse(new FileReader
					("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));
			
			JsonObject jsonObject = (JsonObject)fileObj;
			JsonElement name = jsonObject.get("registration");
			System.out.println("\n Value of browser variable is " +name);
			JsonObject obj_jsonobj = (JsonObject) name;
			
			System.out.println("\n Value of firstname variable is " +obj_jsonobj.get("firstname"));	

		//}
/*		catch (Exception e){
			e.printStackTrace();
			System.out.println("Something went wrong. \n");
		}*/
		
		RegistrationPage regObj = new RegistrationPage(driver);
		log.info("Clicking on registration link and entering details of users");
		
		regObj.registration_Method(obj_jsonobj.get("firstname").getAsString(),obj_jsonobj.get("lastname").getAsString(),
				obj_jsonobj.get("phone").getAsString(),obj_jsonobj.get("Email").getAsString(), 
				obj_jsonobj.get("address1").getAsString(),obj_jsonobj.get("address2").getAsString(), 
				obj_jsonobj.get("address1").getAsString(),obj_jsonobj.get("state").getAsString(), 
				obj_jsonobj.get("zip").getAsString(),obj_jsonobj.get("country").getAsString(), 
				obj_jsonobj.get("username").getAsString(),obj_jsonobj.get("password").getAsString());
		
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
