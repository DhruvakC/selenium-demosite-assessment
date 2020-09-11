package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;*/
import utilities.GenericFunctionsPOM;

public class RegistrationPage extends GenericFunctionsPOM {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Register link locator
	@FindBy(linkText = "REGISTER")
	public WebElement register_lk;

	// FirstName Text box locator
	@FindBy(name = "firstName")
	public WebElement firstname;

	// LastName Text box locator
	@FindBy(name = "lastName")
	public WebElement lasttname;

	// Phone Text box locator
	@FindBy(name = "phone")
	public WebElement phone;

	// Email Text box locator
	@FindBy(id = "userName")
	public WebElement emailWE;

	// Address first line Text box locator
	@FindBy(name = "address1")
	public WebElement addressLine1;

	// Address second line Text box locator
	@FindBy(name = "address2")
	public WebElement addressLine2;

	// city Text box locator
	@FindBy(name = "city")
	public WebElement cityWE;

	// State Text box locator
	@FindBy(name = "state")
	public WebElement stateWE;

	// PostalCode Text box locator
	@FindBy(name = "postalCode")
	public WebElement postalCode;

	// Country drop down locator
	@FindBy(name = "country")
	public WebElement countryList;

	// UserName mandatory field box locator
	@FindBy(id = "email")
	public WebElement UserNameMandatory;

	// Password mandatory field Text box locator
	@FindBy(name = "password")
	public WebElement passwordWE;

	// Confirm password mandatory field Text box locator
	@FindBy(name = "confirmPassword")
	public WebElement confirmPassword;

	// Submit button locator
	@FindBy(name = "register")
	public WebElement submitButtonWE;

	public void registration_Method(String fname, String lname, String pNumber, String email, String address1,
			String address2, String city, String state, String zip, String country, String userName, String password)
			throws InterruptedException {
		clickButton(register_lk);
		enterValueToTextBox(firstname, fname);
		enterValueToTextBox(lasttname, lname);
		enterValueToTextBox(phone, pNumber);
		enterValueToTextBox(emailWE, email);
		enterValueToTextBox(addressLine1, address1);
		enterValueToTextBox(addressLine2, address2);
		enterValueToTextBox(cityWE, city);
		enterValueToTextBox(stateWE, state);
		enterValueToTextBox(postalCode, zip);
		selectItemFromDropDown(countryList, country);

		enterValueToTextBox(UserNameMandatory, userName);
		enterValueToTextBox(passwordWE, password);
		enterValueToTextBox(confirmPassword, password);

		Thread.sleep(3000);
		clickButton(submitButtonWE);
		Thread.sleep(3000);		

	}
}
