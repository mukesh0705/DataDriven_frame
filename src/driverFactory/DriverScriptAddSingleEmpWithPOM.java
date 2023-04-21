package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import commonFunctions.AddEmpPage;

import config.AppUtilPom;
public class DriverScriptAddSingleEmpWithPOM extends AppUtilPom{
@Test
public void startTest()
{
AddEmpPage emp =PageFactory.initElements(driver, AddEmpPage.class);
boolean res =emp.verify_Eid("Selenium", "Manual", "Automation");

System.out.println(res);
}

}