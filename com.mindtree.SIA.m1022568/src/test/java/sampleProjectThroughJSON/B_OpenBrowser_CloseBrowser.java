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

public class B_OpenBrowser_CloseBrowser extends GenericFunctions {
	Logger log = Logger.getLogger(SignIn.class);
	JsonParser parser = new JsonParser();	
	
	@Test
	public void openChromeAppURLmethod() throws InterruptedException, JsonIOException, JsonSyntaxException, FileNotFoundException {
		
		//System.out.println("Something");

		Object fileObj = parser.parse(new FileReader
				("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));
		JsonObject jsonObject = (JsonObject)fileObj;
		String websiteName = jsonObject.get("website").getAsString();	
		//websiteName.replace('"', ' ');
		//JsonElement websiteName = jsonObject.get("website");
		
		String browserName = jsonObject.get("browser").getAsString();	
		
/*		System.out.println("Website name is " + websiteName);
		System.out.println("Browser name is " + browserName);*/
		
		launchApp(websiteName, browserName);

	}
	
	//After Test close the browser.
	//@Test (priority = 1)
	@AfterTest
	public void close() {
		closeApp();
	}
}
