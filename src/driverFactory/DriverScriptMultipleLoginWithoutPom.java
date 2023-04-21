package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.LoginPageOrangeHRM_WithoutPOM;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScriptMultipleLoginWithoutPom extends AppUtil {
	String inputpath="D:\\11oclock_selenium\\DDT_FrameWork\\FileInput\\Login.xlsx";
	String outputpath="D:\\11oclock_selenium\\DDT_FrameWork\\FileOutput\\DataDrivenResult.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void startTest() throws Throwable {
		//creat object for excel file util
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		//count no of rows in login sheet
		int rc=xl.rowCount("Login");
		report=new ExtentReports("./Extentreport/Login.html");
		Reporter.log("No of rows are::"+rc,true);
		for (int i = 1; i <=rc; i++) {
			test=report.startTest("validate Login");
			test.assignAuthor("Mukesh");
			//read username and password cell data
			String username=xl.getCellData("Login",i,0);
			String password=xl.getCellData("Login",i,1);
			//calling login method
			boolean res =LoginPageOrangeHRM_WithoutPOM.verify_Login(username, password);
			if(res) {
				//if res is true write as login success into result cell
				xl.setCellData("Login",i,2,"Login Success",outputpath);
				xl.setCellData("Login",i,3,"Pass",outputpath);
				test.log(LogStatus.PASS,"Login Success");
			}
			else {
				File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./screenshot/iteration/"+i+"Loginpage.png"));
				//if res is true write as login Fail into result cell
				xl.setCellData("Login",i,2,"Login Fail",outputpath);
				xl.setCellData("Login",i,3,"Fail",outputpath);
				test.log(LogStatus.FAIL,"Login Fail");
			}
            report.endTest(test);
            report.flush();
            
		}
	}
}
