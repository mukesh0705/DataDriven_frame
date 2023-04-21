package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver;
	//Constructor
	public AddEmpPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickPIM;
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement clickADD;
	@FindBy(name = "firstName")
	WebElement EnterFname;
	@FindBy(name = "middleName")
	WebElement EnterMname;
	@FindBy(name = "lastName")
	WebElement EnterLname;
	@FindBy(xpath = "//input[@id='employeeId']")
	WebElement BeforeEmpId;
	@FindBy(id = "btnSave")
	WebElement SaveBtn;
	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	WebElement AfterEmpId;
	
	public boolean verify_Eid(String Fname,String Mname,String Lname) {
		Actions mouseKey=new Actions(driver);
		//mouseKey.moveToElement(this.clickPIM).click().perform();
		this.clickPIM.click();
		//mouseKey.moveToElement(this.clickADD).click().perform();
		this.clickADD.click();
		this.EnterFname.sendKeys(Fname);
		this.EnterMname.sendKeys(Mname);
		this.EnterLname.sendKeys(Lname);
		String Expectedid=this.BeforeEmpId.getAttribute("value");
		//mouseKey.moveToElement(this.SaveBtn).click().perform();
		this.SaveBtn.click();
		String Actualid=this.AfterEmpId.getAttribute("value");
		if (Expectedid.equals(Actualid)) {
			Reporter.log("Operation Successful"+"   "+Expectedid+"   "+Actualid,true);
			return true;
		}
		else {
			Reporter.log("Operation Fail"+"   "+Expectedid+"   "+Actualid,true);
			return false;
		}
	}
	

}
