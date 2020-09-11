package sampleProjectThroughJSON;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pages.SignInPage;
import projectThroughPOM.SignIn;
import utilities.GenericFunctions;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class A_ExtractValueThroughJSON extends GenericFunctions{
	
	Logger log = Logger.getLogger(SignIn.class);
	JsonParser parser = new JsonParser();	

			
	
 @Test
  public void hanleJSONfile() {
	  
		JsonParser parser = new JsonParser();

		try {
			Object fileObj = parser.parse(new FileReader
					("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));
			
			JsonObject jsonObject = (JsonObject)fileObj;
			JsonElement name = jsonObject.get("browser");
			System.out.println("Value of browser variable is " +name);
		}
		
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Something went wrong. \n");
		}
  }
	

}
