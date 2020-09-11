package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowserTesting {
  
	@Parameters("browser")
	
	@Test
	public void crossBrowserTestingMethod(String browser) throws InterruptedException {
	  
		System.out.println("Sample Output");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\SeleniumInternalAssessment\\Drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://www.google.com");
			Thread.sleep(2000);
			
			driver.close();
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "D://Selenium//SeleniumInternalAssessment//Drivers//geckodriver.exe");
			//WebDriver driver = new InternetExplorerDriver();
			WebDriver driver = new FirefoxDriver();
			//System.setProperty("webdriver.ie.driver", "D://Selenium//SeleniumInternalAssessment//Drivers//IEDriverServer.exe");
			//WebDriver driver = new InternetExplorerDriver();
			
			driver.get("http://www.google.com");
			Thread.sleep(2000);
			
			driver.close();
		}

  }
}
