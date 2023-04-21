package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.LoginPage;
import commonFunctions.LogoutPage;

public class AppUtilPom {
	//POM:POM means Page Object Model
	public static WebDriver driver;
	@BeforeTest
	public static void preCondition() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com/");
		LoginPage login=PageFactory.initElements(driver,LoginPage.class);
		login.verify_Login("Admin","Qedge123!@#");	
	}
	@AfterTest
	public static void tearDown() {
		LogoutPage logout=PageFactory.initElements(driver,LogoutPage.class);
		logout.verify_Logout();
		driver.quit();
	}

}
