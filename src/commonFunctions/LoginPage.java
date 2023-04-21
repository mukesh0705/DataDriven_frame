package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement EnterUser;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement EnterPass;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement Login;
	
	public void verify_Login(String username,String password) {
		EnterUser.sendKeys(username);
		EnterPass.sendKeys(password);
		Login.click();

	}
}