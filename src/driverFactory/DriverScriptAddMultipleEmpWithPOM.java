package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class DriverScriptAddMultipleEmpWithPOM extends AppUtilPom{
	@Test
	public void startTest() throws Throwable 
	{
		String inputpath="D:\\11oclock_selenium\\DDT_FrameWork\\FileInput\\EmployeeData.xlsx";
		String outputpath="D:\\11oclock_selenium\\DDT_FrameWork\\FileOutput\\dhinchika.xlsx";

		AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);

		ExcelFileUtil Excel=new ExcelFileUtil(inputpath);
		int rc=Excel.rowCount("EmpData");
		Reporter.log("No of rows are::"+rc,true);

		for(int i=1;i<=rc;i++) 
		{
			String FirstName=Excel.getCellData("EmpData", i, 0);
			String MiddleName=Excel.getCellData("EmpData",i, 1);
			String LastName=Excel.getCellData("EmpData",i, 2);

			boolean res=emp.verify_Eid(FirstName, MiddleName, LastName);

			if (res) 
			{
				Excel.setCellData("EmpData",i,3,"Pass", outputpath);
			} 
			else 
			{
				Excel.setCellData("EmpData",i,3,"Fail", outputpath);
			}

		}
	}

}

