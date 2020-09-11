package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes methods like
 * 
 * 					launchApp
 * 					getParameterValue
 * 					getLocatorPath
 * 					closeApp
*/

public class BaseFramework {

	static Properties properties = new Properties();

	static String configFilePath = "src//main//java//dataFiles//Config.Properties";
	static String locatorFilePath = "src//main//java//dataFiles//locators.csv";
	
	static String jsonFilePath = "D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json";

	public WebDriver driver;

	String chromedriverlocation = "Drivers//chromedriver.exe";
	String firefoxdriverlocation = "Drivers//geckodriver.exe";

	Logger log = Logger.getLogger(GenericFunctions.class);

	public void launchApp(String appUrl, String browserName) throws InterruptedException {

		if (browserName.equalsIgnoreCase("FIREFOX") == true) {

			System.setProperty("webdriver.gecko.driver", firefoxdriverlocation);

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);

			// driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(appUrl);

		}

		else if (browserName.equalsIgnoreCase("CHROME") == true) {

			System.setProperty("webdriver.chrome.driver", chromedriverlocation);

			log.info("Starting Web Browser.");

			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(appUrl);
			// driver.navigate().to(appUrl);
			//driver.navigate().forward();

			log.info("Web Browser Started !!!");

		}

		else if (browserName.equalsIgnoreCase("IE") == true) {

		}

		else {
			System.out.println("WebDriver can't start this browser");
		}
	}

	public static void loadFile(String filepath) {
		try {
			FileInputStream input = new FileInputStream(filepath);
			properties.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getParameterValue(String parameter) {
		loadFile(configFilePath);
		return properties.getProperty(parameter);
	}

	public String getLocatorPath(String locator) {
		loadFile(locatorFilePath);
		return properties.getProperty(locator);
	}

	public void closeApp() {

		log.info("Closing web browser.");
		driver.close();
		driver.quit();
		log.info("Web browser closed.");
	}
	
/*	public JsonObject getContentAsJsonObject() throws JsonIOException, JsonSyntaxException, FileNotFoundException
	{
		JsonParser parser = new JsonParser();
		Object fileObj = parser.parse(new FileReader
				("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));
		JsonObject jsonObject = (JsonObject)fileObj;
		
		return jsonObject; 
	}*/
	private JsonObject getJsonObject()  {
		try {
			JsonParser parser = new JsonParser();
			Object fileObj = parser.parse(new FileReader(jsonFilePath));
			JsonObject jsonObject = (JsonObject)fileObj;
			return jsonObject;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getContentAsJsonObject(String parentKeyName)   
	{
		/*JsonParser parser = new JsonParser();
		Object fileObj = parser.parse(new FileReader(jsonFilePath));
		JsonObject jsonObject = (JsonObject)fileObj;*/
		//JsonObject jsonObject = getJsonObject();
		String returnValue = getJsonObject().get(parentKeyName).getAsString();	
		return returnValue; 
	}
	
	public String getContentAsJsonObject(String parentKeyName, String childKeyName ) throws FileNotFoundException
	{
		/*JsonParser parser = new JsonParser();
		Object fileObj = parser.parse(new FileReader(jsonFilePath));
		JsonObject jsonObject = (JsonObject)fileObj;*/
		//JsonObject jsonObject = getJsonObject();
		JsonElement name = getJsonObject().get(parentKeyName);
		JsonObject obj_jsonobj = (JsonObject) name;
		String returnValue = obj_jsonobj.get(childKeyName).getAsString();
		
		return returnValue;
	}
/*	public String getContentAsJsonObject(String parentKeyName, String childKeyName )
	{
		if (childKeyName.equals(null)) {
			String returnValue = getJsonObject().get(parentKeyName).getAsString();	
			return returnValue; 
		}
		if (!childKeyName.equals(null)) {
			JsonElement name = getJsonObject().get(parentKeyName);
			JsonObject obj_jsonobj = (JsonObject) name;
			String returnValue = obj_jsonobj.get(childKeyName).getAsString();		
			return returnValue;
		}
		else {
			System.out.println("Something went wrong.");
			return null;
		}
	}*/
			
}

