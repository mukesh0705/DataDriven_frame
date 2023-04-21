package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement clickWelc;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement clickLogout;
	public void verify_Logout() {
		clickWelc.click();
		clickLogout.click();
	}

}
