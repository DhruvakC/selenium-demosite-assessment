package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

/*
 * @author :		Dhruvak Chokshi
 * Date:			3-Aug-17
 * Completion Date: 5-Aug-17
 * Modified Date:	5-Aug-17
 * Last Modified By:Dhruvak Chokshi
 * Description: 	This class includes methods like
 * 
 * 					buttonClick
 * 					textBoxValueFilling
 * 					selectDropdown
 * 					doesTextExistsOnPage
 * 					takeScreenshot
*/

public class BaseUtils extends BaseFramework {

	public void buttonClick(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void textBoxValueFilling(String locator, String value) {
		driver.findElement(By.xpath(locator)).click();
		driver.findElement(By.xpath(locator)).clear(); // If there is existing text it will remove it.
		driver.findElement(By.xpath(locator)).sendKeys(value);
	}

	public void selectDropdown(String locatorPath, String dropDownValue) {
		Select dropDown = new Select(driver.findElement(By.xpath(getLocatorPath(locatorPath))));
		dropDown.selectByVisibleText(dropDownValue);
	}

	public boolean doesTextExistsOnPage(String locator) {

		if (driver.findElement(By.xpath(locator)).getText() != null) {
			return true;
		}

		else if (driver.findElement(By.xpath(locator)).getText() == null) {
			return false;
		}

		return false;
	}

	public void takeScreenshot(String imageName) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("mmHH_dd_MM_YYYY");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  System.out.println("Reached"); 
		  FileUtils.copyFile(scrFile, new File(
		  				"C:\\Selenium\\SeleniumInternalAssessment2\\SeleniumInternalAssessment2\\Screenshots\\"
		  				+ imageName + "_" + date1 + ".jpg"));

	}

}
