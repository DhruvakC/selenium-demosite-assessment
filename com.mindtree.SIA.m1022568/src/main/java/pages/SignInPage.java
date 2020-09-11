package pages;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.GenericFunctionsPOM;
import org.openqa.selenium.WebElement;

public class SignInPage extends GenericFunctionsPOM{

	public WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//User Name locator
	@FindBy(name = "userName")
	public static WebElement username;

	//Password locator
	@FindBy(name = "password")
	public WebElement password;

	//Sign-In locator
	@FindBy(name = "login")
	public WebElement signin_btn;

	public void signIn(String usernameinput, String passwordinput) throws InterruptedException {

		enterValueToTextBox(username, usernameinput);
		enterValueToTextBox(password, passwordinput);
		clickButton(signin_btn);
		Thread.sleep(3000);

	}
}
